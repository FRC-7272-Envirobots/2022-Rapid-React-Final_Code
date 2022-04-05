package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorHandler;

public class MotorPowerDown extends CommandBase 
{
    public MotorHandler MotorHandler;

    public double DecelRate;

    public double MinSpeedContinualSpeed;

    public MotorPowerDown(MotorHandler motorHandler, double decel, double minContinualSpeed) 
    {
        MotorHandler = motorHandler;
        DecelRate = decel;
        MinSpeedContinualSpeed = minContinualSpeed;
        addRequirements(MotorHandler);
    }

    @Override
    public void execute()
    {
        MotorHandler.Decel(DecelRate);
    }

    @Override
    public void end(boolean interrupted)
    {
        MotorHandler.Rotate(0);
    }

    @Override
    public boolean isFinished() 
    {
      return MotorHandler.CurrentSpeed <= MinSpeedContinualSpeed;
    }
}