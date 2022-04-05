package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TestEncoder extends CommandBase 
{
  private final Drivetrain Drivetrain;

  public TestEncoder(Drivetrain drivetrain) 
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
    Drivetrain.GetEncoderDrive().SmartDashboardLog("Drive Distances", false);
  }

  @Override
  public boolean isFinished() 
  {
    return false;
  }
}