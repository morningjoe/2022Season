// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTankSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

/** An example command that uses an example subsystem. */
public class DriveTankCmd extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTankSubsystem DriveTankSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Supplier<Double> XSupplier, YSupplier, ZSupplier;

  public DriveTankCmd(DriveTankSubsystem subsystem, Supplier<Double> XSupplier, Supplier<Double> YSupplier, Supplier<Double> ZSupplier) {
    DriveTankSubsystem = subsystem;
    this.XSupplier = XSupplier;
    this.YSupplier = YSupplier;
    this.ZSupplier = ZSupplier;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double driveSpeed = Constants.driveSpeed;
    double driveSpeedMax = Constants.driveSpeedMax;
    double x = XSupplier.get(); x = Math.abs(x) > driveSpeedMax ? driveSpeedMax * Math.signum(x) : x;
    double y = YSupplier.get(); y = Math.abs(y) > driveSpeedMax ? driveSpeedMax * Math.signum(y) : y;

    DriveTankSubsystem.drive(x, y);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
