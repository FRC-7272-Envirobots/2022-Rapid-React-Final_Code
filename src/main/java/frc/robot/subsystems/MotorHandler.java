package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.MathUtils;

public abstract class MotorHandler extends SubsystemBase
{
    public double CurrentSpeed;
    
    public double MaximumSpeed;

    public MotorHandler()
    {
        MaximumSpeed = 0.5f;
    }

    protected abstract void InternalRotate(double speed);
    
    public void Rotate(double speed)
    {
        CurrentSpeed = MathUtils.Clamp(speed, 0, MaximumSpeed);
        InternalRotate(speed * MathUtils.Sign(MaximumSpeed));
        SmartDashboard.putNumber("Current Motor Speed", speed * MathUtils.Sign(MaximumSpeed));
    }

    public void Accel(double minSpeed, double accel)
    {
        if (CurrentSpeed >= MaximumSpeed)
        {
            CurrentSpeed = MaximumSpeed;
            return;
        }

        var currentSpeed = Math.max(CurrentSpeed, minSpeed);
        currentSpeed *= accel;
        currentSpeed = MathUtils.Clamp(currentSpeed, minSpeed, MaximumSpeed);
        Rotate(currentSpeed);
    }

    public void Decel(double decel)
    {
      if (decel >= 1)
      {
        decel = 0.99f;
      }
  
      Rotate(CurrentSpeed * decel);
    }

    public void UpdateMaxSpeed(double speedIncrement)
    {
        MaximumSpeed = MathUtils.Clamp(MaximumSpeed + speedIncrement, -1, 1);
        SmartDashboard.putString("Motor Speed", MaximumSpeed + "%");
    }
}