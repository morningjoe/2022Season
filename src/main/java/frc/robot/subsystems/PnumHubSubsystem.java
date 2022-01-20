package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class PnumHubSubsystem extends SubsystemBase{
    Compressor compressor = new Compressor(Constants.PNEUMATICS_HUB_ID,Constants.PNEUMATICS_HUB_TYPE);
    public void init() {
        
    }

    public void putStats(){
        SmartDashboard.putBoolean("Compressor: Enabled", compressor.enabled());
        SmartDashboard.putBoolean("Compressor: Pressure Switch", compressor.getPressureSwitchValue());
        SmartDashboard.putNumber("Compressor: Pressure", compressor.getPressure());
    }
    public void periodic() {
     putStats();  
    }
}
