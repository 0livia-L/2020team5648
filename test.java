//winch open 
//winch closed 
//driving 
//ball intke - motor 
//flap 
//control pannel motor  

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.cscore.VideoMode;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */

public class Robot extends TimedRobot {
    private DifferentialDrive m_myRobot;
    private DifferentialDrive m_myRobotTalon;
    private XboxController m_primaryController;
    private NetworkTableInstance ntInstance;
    NetworkTable motorTable;
    }
    // private Talon m_intakeMotor;

@Override
  public void robotInit() { //once the robot has turned on what will it do?
    // Setup XBox controller
    m_primaryController = new XboxController(0);

    // Setup drive motors
    m_myRobot = new DifferentialDrive(new Spark(0), new Spark(1));
    m_myRobotTalon = new DifferentialDrive(new PWMTalonSRX(8), new PWMTalonSRX(9));

    @Override
    public void teleopPeriodic() {
        arcadeDrive();
    }

public void arcadeDrive(){
    //Arcade drive motor control
    var forward = m_primaryController.getY(Hand.kLeft)*0.8;
    var spin = m_primaryController.getX(Hand.kRight)*0.45;
    m_myRobot.arcadeDrive(forward, spin, false);
    m_myRobotTalon.arcadeDrive(forward, spin, false);
}