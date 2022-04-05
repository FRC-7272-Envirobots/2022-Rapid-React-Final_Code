package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends CommandBase 
{
  public final Drivetrain Drivetrain;

  public AutoDrive(Drivetrain drivetrain) 
  {
    Drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize()
  {
    Drivetrain.ResetEncoders();
  }

  @Override
  public void execute() 
  {
    Drivetrain.ArcadeDrive(-0.5f, 0);
  }

  @Override
  public void end(boolean interrupted)
  {
    Drivetrain.ArcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() 
  {
    return Drivetrain.Encoders[0].getDistance() < 3f;
  }
}