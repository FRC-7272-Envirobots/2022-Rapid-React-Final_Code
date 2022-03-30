package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class TalonTest extends CommandBase 
{
    public Shooter Shooter;

    public TalonTest(Shooter shooter) 
    {
        Shooter = shooter;
        addRequirements(Shooter);
    }

    @Override
    public void execute()
    {
        Shooter.TalonMotor.set(ControlMode.PercentOutput, 0.2f);
    }

    @Override
    public void end(boolean interrupted)
    {
        Shooter.TalonMotor.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public boolean isFinished() 
    {
      return false;
    }
}