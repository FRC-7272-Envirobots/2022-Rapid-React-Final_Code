package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorHandler;

public class UpdateMotorMaxSpeed extends CommandBase 
{
    public MotorHandler MotorHandler;

    public double SpeedChange;

    public String SmartDashboardKey;

    public UpdateMotorMaxSpeed(MotorHandler motorHandler, double speedChange, String smartDashboardKey) 
    {
        SpeedChange = speedChange;
        MotorHandler = motorHandler;
        SmartDashboardKey = smartDashboardKey;
    }

    @Override
    public void initialize()
    {
        MotorHandler.UpdateMaxSpeed(SpeedChange);
        SmartDashboard.putNumber(SmartDashboardKey, MotorHandler.MaximumSpeed);
    }

    @Override
    public boolean isFinished() 
    {
      return true;
    }
}