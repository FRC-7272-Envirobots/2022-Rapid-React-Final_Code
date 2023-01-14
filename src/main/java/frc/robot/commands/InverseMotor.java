package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorHandler;

public class InverseMotor extends CommandBase 
{
    public MotorHandler MotorHandler;

    public InverseMotor(MotorHandler motorHandler) 
    {
        MotorHandler = motorHandler;
    }

    @Override
    public void initialize()
    {
        MotorHandler.InverseSpeed(!MotorHandler.IsInversed);
    }

    @Override
    public boolean isFinished() 
    {
      return true;
    }
}