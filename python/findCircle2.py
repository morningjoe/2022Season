

import cv2
import numpy as np

cap = cv2.VideoCapture(4)
ret, background = cap.read()
background = cv2.cvtColor(background, cv2.COLOR_BGR2GRAY)

while True :
    ret, frame = cap.read()
    lower_red = np.array([6,150, 80]) # hsv

    upper_red = np.array([25, 255, 255])
    # lower_blue = np.array([100, 50, 50]) # hsv
    # upper_blue = np.array([130, 255, 255])
    #lower_orange = np.array([6, 140, 90]) # hsv Orange: 30 255 198 not Orange: 0 232 150
   # upper_orange = np.array([25, 255, 255])

    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

    mask = cv2.inRange(hsv, lower_red, upper_red)
    mask = cv2.erode(mask, None, iterations=2)
    mask = cv2.dilate(mask, None, iterations=2)

    masked_image = cv2.bitwise_and(frame, frame, mask=mask)
    gray = cv2.cvtColor(masked_image, cv2.COLOR_BGR2GRAY)
    gray = gray-background

    # detect average location of brightest pixels in grey
    # and use that as the center of the circle
    averageLocation = np.where(gray == np.amax(gray))
    x = averageLocation[1][0]
    y = averageLocation[0][0]
    cv2.circle(frame, (x, y), 10, (0, 0, 255), -1)

    edged = cv2.Canny(gray, 30, 200)
    contour, hierarchy = cv2.findContours(edged, 
    cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)
    #contour = cv2.findContours(gray.copy(),cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_SIMPLE)[-2]
    if len(contour) > 0:
        # draw contours
       
        print(len(contour))
        c = max(contour, key = cv2.contourArea)
        ((x,y),radius) = cv2.minEnclosingCircle(c)
        M = cv2.moments(c)
        # show circle
        if (radius > 10):
            # get percentage of black pixels in circle
            # and use that as a measure of how much the circle is filled
            # if the circle is filled more than 50% then we have found the circle
            # otherwise we have not found the circle
            masked_image_grey = cv2.cvtColor(masked_image, cv2.COLOR_BGR2GRAY)
            filled = cv2.countNonZero(masked_image_grey) / (np.pi * radius**2)
            if (filled > 0.9):
                cv2.circle(frame, (int(x), int(y)), int(radius), (0, 0, 255), 2)
                
            
            
            
        # show center
        #center = (int(M["m10"] / M["m00"]), int(M["m01"] / M["m00"]))
        #cv2.circle(frame, center, 5, (0, 0, 255), -1)
        

    # # masked it before find circle
    # # set boundary for haro classic green
    # # reference (BGR)=(0,255,68)

    # #lower = np.array([0, 30, 70], dtype="uint8")
    # #upper = np.array([30, 120, 255], dtype="uint8")

    # #mask = cv2.inRange(frame,lower,upper)
    # #maskedImage = cv2.bitwise_and(frame,frame,mask = mask)
    # #maskedImage = cv2.cvtColor(maskedImage, cv2.COLOR_BGR2GRAY)    
    
    # # find circle
    # if ret :
    #     #maskedImage = cv2.cvtColor(maskedImage, cv2.COLOR_BGR2GRAY)
    #     #cv2.blur(maskedImage,(11,11))
    #     #circles = cv2.HoughCircles(maskedImage,cv2.cv.CV_HOUGH_GRADIENT,10,300,param1=50,param2=200,minRadius=100,maxRadius=150)

    #     #gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)  # convert videofram 2 gray image
    #     cv2.GaussianBlur(gray, (5, 5), 0)
    #     circles = cv2.HoughCircles(gray, cv2.HOUGH_GRADIENT, 5, 300, param1=50, param2=300, minRadius=50, maxRadius=60)

    #     #circles = None
    #     if circles is not None:
    #         count = 0
    #         circles = np.uint16(np.around(circles))
        
    #         for i in circles[0,:]:
    #             cv2.circle(frame,(i[0],i[1]),i[2],(0,255,0),2)
    #             cv2.circle(frame,(i[0],i[1]),2,(0,0,255),10)
    #             font = cv2.FONT_HERSHEY_SIMPLEX
    #             txt = ('[' + str(i[0]) + ',' + str(i[1]) + ']')
    #             cv2.putText(frame, txt, (100,100+count*50), font, 1, (255,0,0), 1)
    #             count = count+1


    cv2.imshow('detected', masked_image)
    cv2.imshow('frame', frame)
    cv2.imshow('mask', mask)
    # show countour
    countour_image = np.zeros((frame.shape[0], frame.shape[1], 3), dtype=np.uint8)
    cv2.drawContours(countour_image, contour, -1, (0, 255, 0), 1)
    cv2.imshow('countour', countour_image)
 
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break


cap.release()
cv2.destroyAllwindows()
   

