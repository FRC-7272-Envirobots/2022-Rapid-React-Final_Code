package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorHandler;

public class UpdateMotorMaxSpeed extends CommandBase 
{
    public double SpeedChange;

    public UpdateMotorMaxSpeed(double speedChange) 
    {
        SpeedChange = speedChange;
    }

    @Override
    public void initialize()
    {
        MotorHandler.UpdateMaxSpeed(SpeedChange);
    }

    @Override
    public boolean isFinished() 
    {
      return true;
    }
}