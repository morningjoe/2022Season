// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import java.util.function.Supplier;
import com.revrobotics.RelativeEncoder;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class DriveTankSubsystem extends SubsystemBase {

  // Left
  private final CANSparkMax Left_1 = new CANSparkMax(Constants.Drive_Left_1, MotorType.kBrushless);
  private final CANSparkMax Left_2 = new CANSparkMax(Constants.Drive_Left_2, MotorType.kBrushless);
  private final CANSparkMax Left_3 = new CANSparkMax(Constants.Drive_Left_3, MotorType.kBrushless);


  public final MotorControllerGroup leftGroup = new MotorControllerGroup(Left_1, Left_2, Left_3);

  // Right 
  private final CANSparkMax Right_1 = new CANSparkMax(Constants.Drive_Right_1, MotorType.kBrushless); 
  private final CANSparkMax Right_2 = new CANSparkMax(Constants.Drive_Right_2, MotorType.kBrushless);
  private final CANSparkMax Right_3 = new CANSparkMax(Constants.Drive_Right_3, MotorType.kBrushless);

  public final MotorControllerGroup rightGroup = new MotorControllerGroup(Right_1, Right_2, Right_3);
  // add encoders for all motors with RelativeEncoder
  public final RelativeEncoder rightEncoder = Right_1.getEncoder();
  public final RelativeEncoder leftEncoder = Left_1.getEncoder();

  // print out position
  public void printPosition() {

    System.out.print("\033[H\033[2J");
    System.out.println("row 1: "+Left_1.get()+" "+Right_1.get());
    System.out.println("row 2: "+Left_2.get()+" "+Right_2.get());
    System.out.println("row 3: "+Left_3.get()+" "+Right_3.get());

  }


  /** Creates a new ExampleSubsystem. */
  public DriveTankSubsystem() {}

  public void drive(double X, double Y) {
    //try() fixes mem leak?
    try (DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup)) {
      drive.arcadeDrive(Y, X);
    }

    System.out.println("Right: " + X);
    printPosition();
  }
   


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
