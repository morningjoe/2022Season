// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.PdhMonitorSubsystem;
import frc.robot.commands.PdhMonitorCommand;
import frc.robot.commands.PnumHubCommand;
import frc.robot.subsystems.PnumHubSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  // private final Joystick Joystick = new Joystick(Constants.JOYSTICK_PORT);
  PdhMonitorSubsystem PdhSub = new PdhMonitorSubsystem();
 PdhMonitorCommand PdhCmd = new PdhMonitorCommand(PdhSub);

  PnumHubSubsystem PnumSub = new PnumHubSubsystem();
  PnumHubCommand PnumCmd = new PnumHubCommand(PnumSub);


  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();

    // make drive command
    // Command driveCmd = new DriveTankCmd(PdhSub,
    // () -> applyDeadZone(Joystick.getRawAxis(Constants.JOYSTICK_X_AXIS)),
    // ()-> applyDeadZone(Joystick.getRawAxis(Constants.JOYSTICK_Y_AXIS)),
    // () -> applyDeadZone(Joystick.getRawAxis(Constants.JOYSTICK_Z_AXIS)));

    
    PdhSub.setDefaultCommand(PdhCmd);
    PnumSub.setDefaultCommand(PnumCmd);
  }

  /**() -> applyDeadZone(ms_stick.getRawAxis(Constants.JOYSTICK_X_AXIS)),
    ()-> applyDeadZone(m_stick.getRawAxis(Constants.JOYSTICK_Y_AXIS)),
    () -> applyDeadZone(m_stick.getRawAxis(Constants.JOYSTICK_Z_AXIS)));
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return m_autoCommand;
  // }
}

