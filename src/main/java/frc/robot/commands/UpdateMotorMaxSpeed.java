package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class UpdateMotorMaxSpeed extends CommandBase 
{
    public RobotContainer RobotContainer;

    public Joystick Joystick;

    public UpdateMotorMaxSpeed(RobotContainer robotContainer, Joystick joystick) 
    {
        RobotContainer = robotContainer;
        Joystick = joystick;
    }

    @Override
    public void initialize()
    {
        switch (RobotContainer.ActiveSystem)
        {
            case IntakeLift:
                RobotContainer.IntakeLiftHandler.UpdateMaxSpeed(Joystick.getThrottle());
                break;

            case Loading:
                RobotContainer.LoadingHandler.UpdateMaxSpeed(Joystick.getThrottle());
                break;

            case Index:
                RobotContainer.IndexHandler.UpdateMaxSpeed(Joystick.getThrottle());
                break;

            case Shooter:
                RobotContainer.ShooterHandler.UpdateMaxSpeed(Joystick.getThrottle());
                break;
        }
    }

    @Override
    public boolean isFinished() 
    {
      return true;
    }
}