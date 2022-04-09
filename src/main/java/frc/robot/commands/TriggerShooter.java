package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterHandler;

public class TriggerShooter extends CommandBase 
{
    public Joystick Joystick;

    public ShooterHandler Shooter;

    public double MinSpeed;

    public double AccelRate;

    public double DecelRate;

    public double MinSpeedContinualSpeed;

    public TriggerShooter(ShooterHandler shooter, Joystick joystick, double minSpeed, double accel, double decel, double minContinualSpeed) 
    {
        Shooter = shooter;
        Joystick = joystick;
        MinSpeed = minSpeed;
        AccelRate = accel;
        DecelRate = decel;
        MinSpeedContinualSpeed = minContinualSpeed;
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
        if (Joystick.getTriggerPressed())
        {
            Shooter.CurrentSpeed = 0;
        }

        if (Joystick.getTrigger())
        {
            Shooter.Accel(MinSpeed, AccelRate);
        }
        else
        {
            if (Shooter.CurrentSpeed <= MinSpeedContinualSpeed)
            {
                Shooter.Rotate(0);
            }
            else
            {
                Shooter.Decel(DecelRate);
            }
        }

        SmartDashboard.putString("Shooter Speed", Shooter.CurrentSpeed + "%");
    }

    @Override
    public void end(boolean interrupted)
    {
        if (interrupted)
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