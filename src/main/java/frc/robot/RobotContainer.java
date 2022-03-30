// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ShooterPowerDown;
import frc.robot.commands.ShooterPowerUp;
import frc.robot.commands.SimpleDrive;
import frc.robot.commands.TalonTest;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.Shooter;

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

  public Shooter Shooter;

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
    Shooter = new Shooter(0.5f, 7);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void ConfigureButtonBindings()
  {
    new JoystickButton(Joystick, 7)
      .whenPressed(new ShooterPowerUp(Shooter, 1.05f, 0.05f, false))
      .whenReleased(new ShooterPowerDown(Shooter, 0.92f, 0.01f));

    new JoystickButton(Joystick, 8)
      .whenHeld(new TalonTest(Shooter));
  }

  public void Finalise()
  {
    Drivetrain.setDefaultCommand(new SimpleDrive(Drivetrain, Joystick));
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
