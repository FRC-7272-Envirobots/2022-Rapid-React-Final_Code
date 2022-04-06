package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.MotorHandler;
import frc.robot.utils.MathUtils;

public class TriggerShooter extends CommandBase 
{
    public Joystick Joystick;

    public MotorHandler Motor;

    public double MinSpeed;

    public double AccelRate;

    public double DecelRate;

    public double MinSpeedContinualSpeed;

    public TriggerShooter(RobotContainer container, Joystick joystick, double minSpeed, double accel, double decel, double minContinualSpeed) 
    {
        switch (container.ActiveSystem)
        {
            case IntakeLift:
                Motor = container.IntakeLiftHandler;
                break;

            case Loading:
                Motor = container.LoadingHandler;
                break;

            case Index:
                Motor = container.IndexHandler;
                break;

            case Shooter:
                Motor = container.ShooterHandler;
                break;
        }

        Joystick = joystick;
        MinSpeed = minSpeed;
        AccelRate = accel;
        DecelRate = decel;
        MinSpeedContinualSpeed = minContinualSpeed;
    }

    @Override
    public void initialize()
    {
        Motor.CurrentSpeed = 0;
    }

    @Override
    public void execute() 
    {
        if (Joystick.getTriggerPressed())
        {
            SmartDashboard.putString("TriggerState", "Pressed");
        }
        else if (Joystick.getTrigger())
        {
            SmartDashboard.putString("TriggerState", "Held");
        }
        else
        {
            SmartDashboard.putString("TriggerState", "Null");
        }

        if (Joystick.getTriggerPressed())
        {
            Motor.CurrentSpeed = 0;
        }

        if (Joystick.getTrigger())
        {
            Motor.Accel(MinSpeed, AccelRate * MathUtils.Sign(Motor.MaximumSpeed));
        }
        else
        {
            if (Motor.CurrentSpeed <= MinSpeedContinualSpeed)
            {
                Motor.Rotate(0);
            }
            else
            {
                Motor.Decel(DecelRate * MathUtils.Sign(Motor.MaximumSpeed));
            }
        }

        SmartDashboard.putString("Motor Speed", Motor.CurrentSpeed + "%");
    }

    @Override
    public void end(boolean interrupted)
    {
        if (interrupted)
        {
            Motor.Rotate(0);
        }
    }

    @Override
    public boolean isFinished() 
    {
      return false;
    }
}