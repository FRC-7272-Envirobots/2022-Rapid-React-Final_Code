package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorHandler;

public class MotorPowerUp extends CommandBase 
{
    public MotorHandler MotorHandler;

    public double MinSpeed;

    public double AccelRate;

    public boolean SafeEnd;

    public MotorPowerUp(MotorHandler motorHandler, double minSpeed, double accel, boolean safeEnd) 
    {
        MotorHandler = motorHandler;
        MinSpeed = minSpeed;
        AccelRate = accel;
        SafeEnd = safeEnd;
        addRequirements(MotorHandler);
    }
  
    @Override
    public void initialize()
    {
        MotorHandler.CurrentSpeed = 0;
    }

    @Override
    public void execute()
    {
        MotorHandler.Accel(MinSpeed, AccelRate);
    }

    @Override
    public void end(boolean interrupted)
    {
        if (SafeEnd || interrupted)
        {
            MotorHandler.Rotate(0);
        }
    }

    @Override
    public boolean isFinished() 
    {
      return false;
    }
}