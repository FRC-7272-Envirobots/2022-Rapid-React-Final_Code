package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterPowerDown extends CommandBase 
{
    public Shooter Shooter;

    public double DecelRate;

    public double MinSpeedContinualSpeed;

    public ShooterPowerDown(Shooter shooter, double decel, double minContinualSpeed) 
    {
        Shooter = shooter;
        DecelRate = decel;
        MinSpeedContinualSpeed = minContinualSpeed;
        addRequirements(Shooter);
    }

    @Override
    public void execute()
    {
        Shooter.Decel(DecelRate);
    }

    @Override
    public void end(boolean interrupted)
    {
        Shooter.Rotate(0);
    }

    @Override
    public boolean isFinished() 
    {
      return Shooter.CurrentSpeed <= MinSpeedContinualSpeed;
    }
}