// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // drive train motor id
    public static final int Drive_Left_1 = 0;
    public static final int Drive_Left_2 = 1;
    public static final int Drive_Left_3 = 2;

    public static final int Drive_Right_1 = 3;
    public static final int Drive_Right_2 = 4;
    public static final int Drive_Right_3 = 5;

    // drive train motor speed
    public static final double driveSpeed = 0.6;
    public static final double driveSpeedMax = 0.6;

    // joystick
    public static final double DEAD_ZONE = 0.4;
    public static final int JOYSTICK_PORT = 0;
    public static final int JOYSTICK_X_AXIS = 0;
    public static final int JOYSTICK_Y_AXIS = 1;
    public static final int JOYSTICK_Z_AXIS = 2;
}