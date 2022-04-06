package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class UpdateMotorMaxSpeed extends CommandBase 
{
    public RobotContainer RobotContainer;

    public double SpeedChange;

    public UpdateMotorMaxSpeed(RobotContainer robotContainer, double speedChange) 
    {
        RobotContainer = robotContainer;
        SpeedChange = speedChange;
    }

    @Override
    public void initialize()
    {
        switch (RobotContainer.ActiveSystem)
        {
            case IntakeLift:
                RobotContainer.IntakeLiftHandler.UpdateMaxSpeed(SpeedChange);
                break;

            case Loading:
                RobotContainer.LoadingHandler.UpdateMaxSpeed(SpeedChange);
                break;

            case Index:
                RobotContainer.IndexHandler.UpdateMaxSpeed(SpeedChange);
                break;

            case Shooter:
                RobotContainer.ShooterHandler.UpdateMaxSpeed(SpeedChange);
                break;
        }
    }

    @Override
    public boolean isFinished() 
    {
      return true;
    }
}