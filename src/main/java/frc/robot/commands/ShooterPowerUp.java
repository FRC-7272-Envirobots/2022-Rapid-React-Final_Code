package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterPowerUp extends CommandBase 
{
    public Shooter Shooter;

    public double MinSpeed;

    public double AccelRate;

    public boolean SafeEnd;

    public ShooterPowerUp(Shooter shooter, double minSpeed, double accel, boolean safeEnd) 
    {
        Shooter = shooter;
        MinSpeed = minSpeed;
        AccelRate = accel;
        SafeEnd = safeEnd;
        addRequirements(Shooter);
    }
  
    @Override
    public void initialize()
    {
        Shooter.CurrentSpeed = 0;
    }

    @Override
    public void execute()
    {
        Shooter.Accel(MinSpeed, AccelRate);
    }

    @Override
    public void end(boolean interrupted)
    {
        if (SafeEnd || interrupted)
        {
            Shooter.Rotate(0);
        }
    }

    @Override
    public boolean isFinished() 
    {
      return false;
    }
}