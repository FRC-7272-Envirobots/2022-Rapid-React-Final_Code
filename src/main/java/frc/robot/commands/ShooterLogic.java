package frc.robot.commands;

import java.time.Duration;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorHandler;
import frc.robot.subsystems.ShooterHandler;

public class ShooterLogic extends CommandBase 
{
    public ShooterHandler ShooterHandler;

    public int ActiveDuration;

    public int DurationCriteria;

    public ShooterLogic(ShooterHandler shooterHandler, int durationCriteria) 
    {
        ShooterHandler = shooterHandler;
        ActiveDuration = 0;
        DurationCriteria = durationCriteria;
        addRequirements(ShooterHandler);
    }
  
    @Override
    public void initialize()
    {
        ActiveDuration = 0;
        ShooterHandler.CurrentSpeed = 0;
    }

    @Override
    public void execute()
    {
        if (++ActiveDuration < DurationCriteria)
        {
            ShooterHandler.Accel(1.05f, 0.05f);
        }
        else
        {
            ShooterHandler.Decel(0.92f);
        }
    }

    @Override
    public void end(boolean interrupted)
    {
        ShooterHandler.Rotate(0);
    }

    @Override
    public boolean isFinished() 
    {
      return false;
    }
}