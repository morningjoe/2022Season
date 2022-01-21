package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticHub;


public class PnumHubSubsystem extends SubsystemBase{
    PneumaticHub pnumHub = new PneumaticHub(Constants.PNEUMATICS_HUB_ID);
    public void init() {
        
    }

    public void putStats(){
        SmartDashboard.putNumber("PowerHub: Total Current", pnumHub.getCompressorCurrent());

    /**
     * Get the currents of each channel of the PDH and display them on
     * Shuffleboard.
     */
    for (int channel = 0; channel < Constants.PNEM_HUB_CHANNELS; channel++) {
        double pressure = pnumHub.getPressure(channel);
        if (pressure != 0 && pressure > 0) {
            SmartDashboard.putNumber(
                ("PnemHub: Ch" + String.valueOf(channel) + " Pressure"),
                pressure);
        }
      
 }
    }
    public void periodic() {
     putStats();  
    }
}
