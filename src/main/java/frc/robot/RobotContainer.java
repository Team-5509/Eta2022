// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.autons.DriveAndShoot;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final BallFeed m_ballFeed = new BallFeed();
    public final IntakeArm m_intakeArm = new IntakeArm();
    public final Lights m_lights = new Lights();
    public final Intake m_intake = new Intake();
    public final Drivetrain m_drivetrain = new Drivetrain();
    public final AirCompresser m_airCompresser = new AirCompresser();
    public final Shooter m_shooter = new Shooter();

// Joysticks
private final Joystick coPilotJoystick = new Joystick(1);
private final Joystick driverJoystick = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("HaloDrive", new HaloDrive( m_drivetrain ));
    SmartDashboard.putData("ClaytonDrive", new ClaytonDrive( m_drivetrain ));
    SmartDashboard.putData("ShootWithSlider", new ShootWithSlider( m_shooter ));
    SmartDashboard.putData("CompresserOn", new CompresserOn( m_airCompresser ));
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("DriveXFeet: SixFeet", new DriveXFeet(6, m_drivetrain));
    SmartDashboard.putData("DriveXFeet: NegativeSixFeet", new DriveXFeet(-6, m_drivetrain));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_drivetrain.setDefaultCommand(new ClaytonDrive( m_drivetrain ) );
    m_airCompresser.setDefaultCommand(new CompresserOn( m_airCompresser ) );


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("DriveXFeet", new DriveXFeet(-6, m_drivetrain));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    m_chooser.addOption("Nothing", new WaitCommand(2));
    m_chooser.addOption("DriveAndShoot", new DriveAndShoot(m_drivetrain, m_shooter, m_ballFeed));

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton feedbackShooter = new JoystickButton(coPilotJoystick, 3);        
feedbackShooter.whileHeld(new ShootAtPercentSpeed(-.1, m_shooter) ,true);
    SmartDashboard.putData("FeedbackShooter",new ShootAtPercentSpeed(-.1, m_shooter) );

final JoystickButton runBallFeedButton = new JoystickButton(coPilotJoystick, 2);        
runBallFeedButton.whileHeld(new RunBallFeed(0.5, m_ballFeed) ,true);
    SmartDashboard.putData("RunBallFeedButton",new RunBallFeed(0.5, m_ballFeed) );

final JoystickButton runIntakeArmDown = new JoystickButton(coPilotJoystick, 10);        
runIntakeArmDown.whenPressed(new RunIntakeArm(false, m_intakeArm) ,true);
    SmartDashboard.putData("RunIntakeArmDown",new RunIntakeArm(false, m_intakeArm) );

final JoystickButton runIntakeArmUp = new JoystickButton(coPilotJoystick, 12);        
runIntakeArmUp.whenPressed(new RunIntakeArm(true, m_intakeArm) ,true);
    SmartDashboard.putData("RunIntakeArmUp",new RunIntakeArm(true, m_intakeArm) );

final JoystickButton runOuttakeButton = new JoystickButton(coPilotJoystick, 11);        
runOuttakeButton.whileHeld(new RunIntake(-.5, m_intake) ,true);
    SmartDashboard.putData("RunOuttakeButton",new RunIntake(-.5, m_intake) );

final JoystickButton shootWithSliderButton = new JoystickButton(coPilotJoystick, 9);        
shootWithSliderButton.whileHeld(new ShootWithSlider( m_shooter ) ,true);
    SmartDashboard.putData("ShootWithSliderButton",new ShootWithSlider( m_shooter ) );

final JoystickButton shootAtGoodPresetButton = new JoystickButton(coPilotJoystick, 1);        
shootAtGoodPresetButton.whileHeld(new ShootAtPercentSpeed(1.0, m_shooter) ,true);
    SmartDashboard.putData("ShootAtGoodPresetButton",new ShootAtPercentSpeed(1.0, m_shooter) );

final JoystickButton runIntakeButton = new JoystickButton(coPilotJoystick, 7);        
runIntakeButton.whileHeld(new RunIntake(.5, m_intake) ,true);
    SmartDashboard.putData("RunIntakeButton",new RunIntake(.5, m_intake) );



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getdriverJoystick() {
        return driverJoystick;
    }

public Joystick getcoPilotJoystick() {
        return coPilotJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

