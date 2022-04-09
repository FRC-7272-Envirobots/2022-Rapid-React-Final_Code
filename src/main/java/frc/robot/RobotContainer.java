// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.TwistDrive;
import frc.robot.commands.UpdateMotorMaxSpeed;
import frc.robot.commands.AbortCommands;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.AutoIntakeDrop;
import frc.robot.commands.AutoIntakeLift;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.GhettoAutoIntakeDrop;
import frc.robot.commands.GhettoAutoIntakeLift;
import frc.robot.commands.MotorPowerDown;
import frc.robot.commands.MotorPowerUp;
import frc.robot.commands.TriggerShooter;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IndexHandler;
import frc.robot.subsystems.LoadingHandler;
import frc.robot.subsystems.IntakeLiftHandler;
import frc.robot.subsystems.ShooterHandler;
import frc.robot.utils.MathUtils;
import frc.robot.subsystems.LimeLight;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{
  // The robot's subsystems and commands are defined here...

  public Joystick Joystick;

  public Drivetrain Drivetrain;

  public LimeLight LimeLight;

  public LoadingHandler LoadingHandler;

  public IntakeLiftHandler IntakeLiftHandler;

  public IndexHandler IndexHandler;

  public ShooterHandler ShooterHandler;

  public List<CommandBase> Commands;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    InitialiseSystems();
    ConfigureButtonBindings();
    Finalise();
  }

  private void InitialiseSystems()
  {
    Joystick = new Joystick(0);
    Drivetrain = new Drivetrain();
    LimeLight = new LimeLight();
    LoadingHandler = new LoadingHandler(5, 9);
    IntakeLiftHandler = new IntakeLiftHandler(8);
    IndexHandler = new IndexHandler(6);
    ShooterHandler = new ShooterHandler(7);
    SmartDashboard.putNumber("Loading Speed", 0.5f);
    SmartDashboard.putNumber("Intake Lift Speed", 0.5f);
    SmartDashboard.putNumber("Index Speed", 0.5f);
    SmartDashboard.putNumber("Shooter Speed", 0.5f);
    Commands = new ArrayList<CommandBase>();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void ConfigureButtonBindings()
  {
    MotorPowerUp loadingPowerUp = new MotorPowerUp(LoadingHandler, 1.05, 0.05f, false, false);
    MotorPowerDown loadingPowerDown = new MotorPowerDown(LoadingHandler, 0.92f, 0.01f);
    new JoystickButton(Joystick, 4)
      .whenHeld(loadingPowerUp)
      .whenReleased(loadingPowerDown);
    Commands.add(loadingPowerUp);
    Commands.add(loadingPowerDown);

    MotorPowerUp inverseLoadingPowerUp = new MotorPowerUp(LoadingHandler, 1.05, 0.05f, false, true);
    MotorPowerDown inverseLoadingPowerDown = new MotorPowerDown(LoadingHandler, 0.92f, 0.01f);
    new JoystickButton(Joystick, 3)
      .whenHeld(inverseLoadingPowerUp)
      .whenReleased(inverseLoadingPowerDown);
    Commands.add(inverseLoadingPowerUp);
    Commands.add(inverseLoadingPowerDown);

    MotorPowerUp indexPowerUp = new MotorPowerUp(IndexHandler, 1.05f, 0.05f, false, false);
    MotorPowerDown indexPowerDown = new MotorPowerDown(IndexHandler, 0.92f, 0.01f);
    new JoystickButton(Joystick, 6)
      .whenHeld(indexPowerUp)
      .whenReleased(indexPowerDown);
    Commands.add(indexPowerUp);
    Commands.add(indexPowerDown);

    MotorPowerUp inverseIndexPowerUp = new MotorPowerUp(IndexHandler, 1.05f, 0.05f, false, true);
    MotorPowerDown inverseIndexPowerDown = new MotorPowerDown(IndexHandler, 0.92f, 0.01f);
    new JoystickButton(Joystick, 5)
      .whenHeld(inverseIndexPowerUp)
      .whenReleased(inverseIndexPowerDown);
    Commands.add(inverseIndexPowerUp);
    Commands.add(inverseIndexPowerDown);

    MotorPowerUp intakeLiftPowerUp = new MotorPowerUp(IntakeLiftHandler, 1.05f, 0.05f, false, false);
    MotorPowerDown intakeLiftPowerDown = new MotorPowerDown(IntakeLiftHandler, 0.92f, 0.01f);
    new JoystickButton(Joystick, 9)
      .whenHeld(intakeLiftPowerUp)
      .whenReleased(intakeLiftPowerDown);
    Commands.add(intakeLiftPowerUp);
    Commands.add(intakeLiftPowerDown);

    MotorPowerUp inverseIntakeLiftPowerUp = new MotorPowerUp(IntakeLiftHandler, 1.05f, 0.05f, false, true);
    MotorPowerDown inverseIntakeLiftPowerDown = new MotorPowerDown(IntakeLiftHandler, 0.92f, 0.01f);
    new JoystickButton(Joystick, 10)
      .whenHeld(inverseIntakeLiftPowerUp)
      .whenReleased(inverseIntakeLiftPowerDown);
    Commands.add(inverseIntakeLiftPowerUp);
    Commands.add(inverseIntakeLiftPowerDown);

    GhettoAutoIntakeLift autoIntakeLift = new GhettoAutoIntakeLift(IntakeLiftHandler);
    new JoystickButton(Joystick, 7)
      .whenPressed(autoIntakeLift);
    Commands.add(autoIntakeLift);

    GhettoAutoIntakeDrop autoIntakeDrop = new GhettoAutoIntakeDrop(IntakeLiftHandler);
    new JoystickButton(Joystick, 8)
      .whenPressed(autoIntakeDrop);
    Commands.add(autoIntakeDrop);

    new JoystickButton(Joystick, 11)
      .whenPressed(new UpdateMotorMaxSpeed(ShooterHandler, 0.1f, "Shooter Speed"));

    new JoystickButton(Joystick, 12)
      .whenPressed(new UpdateMotorMaxSpeed(ShooterHandler, -0.1f, "Shooter Speed"));

    new JoystickButton(Joystick, 2)
      .whenPressed(new AbortCommands(Commands));
  }

  public void Finalise()
  {
    Drivetrain.setDefaultCommand(new TwistDrive(Drivetrain, Joystick));
    ShooterHandler.setDefaultCommand(new TriggerShooter(ShooterHandler, Joystick, 1.05f, 0.05f, 0.92f, 0.01f));
  }

  public void TeleopPeriodic()
  {
    double loadingSpeed = SmartDashboard.getNumber("Loading Speed", 0.5f);
    LoadingHandler.MaximumSpeed = MathUtils.Clamp(loadingSpeed, 0, 1);
    
    double intakeLiftSpeed = SmartDashboard.getNumber("Intake Lift Speed", 0.5f);
    IntakeLiftHandler.MaximumSpeed = MathUtils.Clamp(intakeLiftSpeed, 0, 1);
    
    double indexSpeed = SmartDashboard.getNumber("Index Speed", 0.5f);
    IndexHandler.MaximumSpeed = MathUtils.Clamp(indexSpeed, 0, 1);
   
    double shooterSpeed = SmartDashboard.getNumber("Shooter Speed", 0.5f);
    ShooterHandler.MaximumSpeed = MathUtils.Clamp(shooterSpeed, 0, 1);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() 
  {
    return new SequentialCommandGroup(
      new AutoDrive(Drivetrain), 
      new AutoShoot(ShooterHandler, 1.05f, 0.1f),
      new MotorPowerDown(ShooterHandler, 0.92f, 0.01f));
  }
}
