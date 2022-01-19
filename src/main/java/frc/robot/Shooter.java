package frc.robot;


import com.revrobotics.*;

class Shooter {
    SparkMaxPIDController PID;
    CANSparkMax flywheel;

    public Shooter() { 
        flywheel = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
        PID = flywheel.getPIDController();
 
    }

    //public double getRPM() {
        //return flywheel.getv();
   // }

    public void setRPM(int rpm) {
        PID.setReference(rpm, CANSparkMax.ControlType.kVelocity);
    }

    public void setPIDF(double P, double I, double D, double F) {
        PID.setP(P);
        PID.setI(I);
        PID.setD(D);
        PID.setFF(F);

    }

    public void setSpeed(double speed) {
        flywheel.set(speed);
    }
}