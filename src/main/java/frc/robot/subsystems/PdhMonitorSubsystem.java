// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class PdhMonitorSubsystem extends SubsystemBase {

  PowerDistribution m_pdh = new PowerDistribution();

  /** Creates a new ExampleSubsystem. */
  public PdhMonitorSubsystem() {
    // open up smartdashboard window
  }

  public void putStats(){
    SmartDashboard.putNumber("PowerHub: Total Current", m_pdh.getTotalCurrent());

    /**
     * Get the currents of each channel of the PDH and display them on
     * Shuffleboard.
     */
    for (int channel = 0; channel < Constants.PDH_CHANNELS; channel++) {
      SmartDashboard.putNumber(
          ("PowerHub: Ch" + String.valueOf(channel) + " Current"),
          m_pdh.getCurrent(channel));
 }
}

  @Override
  public void periodic() {
    putStats();
    }
  

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
