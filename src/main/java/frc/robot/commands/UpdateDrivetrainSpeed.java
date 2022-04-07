package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.utils.MathUtils;

public class UpdateDrivetrainSpeed extends CommandBase 
{
    public Drivetrain Drivetrain;

    public double SpeedChange;

    public UpdateDrivetrainSpeed(Drivetrain drivetrain, double speedChange) 
    {
        Drivetrain = drivetrain;
        SpeedChange = speedChange;
    }

    @Override
    public void initialize()
    {
        Drivetrain.DriveSpeed = MathUtils.Clamp(Drivetrain.DriveSpeed + SpeedChange, 0f, 1f);
    }

    @Override
    public boolean isFinished() 
    {
      return true;
    }
}