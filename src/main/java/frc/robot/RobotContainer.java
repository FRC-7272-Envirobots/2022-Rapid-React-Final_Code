// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.TwistDrive;
import frc.robot.commands.UpdateMotorMaxSpeed;
import frc.robot.commands.MotorPowerDown;
import frc.robot.commands.MotorPowerUp;
import frc.robot.commands.TestEncoder;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LoadingHandler;
import frc.robot.subsystems.IntakeLiftHandler;
import frc.robot.subsystems.ShooterHandler;
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

  public ShooterHandler ShooterHandler;

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
    ShooterHandler = new ShooterHandler(6, 7);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void ConfigureButtonBindings()
  {
    new JoystickButton(Joystick, 5)
      .whenPressed(new UpdateMotorMaxSpeed(-0.1f));

    new JoystickButton(Joystick, 6)
      .whenPressed(new UpdateMotorMaxSpeed(0.1f));

    new JoystickButton(Joystick, 3)
      .whenHeld(new MotorPowerUp(LoadingHandler, 1.05, 0.05f, false))
      .whenReleased(new MotorPowerDown(LoadingHandler, 0.92f, 0.01f));

    new JoystickButton(Joystick, 4)
      .whenHeld(new MotorPowerUp(ShooterHandler, 1.05f, 0.05f, false))
      .whenReleased(new MotorPowerDown(ShooterHandler, 0.92f, 0.01f));

    new JoystickButton(Joystick, 7)
      .whenHeld(new MotorPowerUp(IntakeLiftHandler, 1.05f, 0.05f, false))
      .whenReleased(new MotorPowerDown(IntakeLiftHandler, 0.92f, 0.01f));

    new JoystickButton(Joystick, 8)
      .whenHeld(new TestEncoder(Drivetrain));
  }

  public void Finalise()
  {
    Drivetrain.setDefaultCommand(new TwistDrive(Drivetrain, Joystick));
    //Shooter.setDefaultCommand(new TriggerShooter(Shooter, Joystick, 1.05f, 1.05f, 0.92f, 0.01f));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() 
  {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
