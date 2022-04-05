package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TwistDrive extends CommandBase 
{
  private final Drivetrain Drivetrain;

  private final Joystick Joystick;

  public TwistDrive(Drivetrain drivetrain, Joystick joystick) 
  {
    Drivetrain = drivetrain;
    Joystick = joystick;
    addRequirements(drivetrain);
  }

  @Override
  public void execute() 
  {
    double rawThrottle = Joystick.getThrottle();
    double throttle = Math.abs((rawThrottle - 1) / 2);
    Drivetrain.ArcadeDrive(Joystick.getRawAxis(2) * throttle, -Joystick.getRawAxis(1) * throttle);
    SmartDashboard.putString("Drive Speed", throttle + "%"); 
  }

  @Override
  public boolean isFinished() 
  {
    return false;
  }
}