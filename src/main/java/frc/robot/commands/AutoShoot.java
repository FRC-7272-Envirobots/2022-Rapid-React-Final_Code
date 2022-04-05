package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorHandler;
import frc.robot.subsystems.ShooterHandler;

public class AutoShoot extends CommandBase 
{
    public MotorHandler ShooterHandler;

    public double MinSpeed;

    public double AccelRate;

    public int Timer;

    public AutoShoot(ShooterHandler shooterHandler, double minSpeed, double accel) 
    {
        ShooterHandler = shooterHandler;
        MinSpeed = minSpeed;
        AccelRate = accel;
        addRequirements(ShooterHandler);
    }
  
    @Override
    public void initialize()
    {
        ShooterHandler.CurrentSpeed = 0;
    }

    @Override
    public void execute()
    {
        ShooterHandler.Accel(MinSpeed, AccelRate);
        Timer++;
    }

    @Override
    public void end(boolean interrupted)
    {
        if (interrupted)
        {
            ShooterHandler.Rotate(0);
        }
    }

    @Override
    public boolean isFinished() 
    {
      return Timer > 200;
    }
}