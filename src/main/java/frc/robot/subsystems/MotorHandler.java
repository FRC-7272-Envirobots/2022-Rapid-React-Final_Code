package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.MathUtils;

public abstract class MotorHandler extends SubsystemBase
{
    public double CurrentSpeed;
    
    public double MaximumSpeed;

    public boolean IsInversed;

    public MotorHandler()
    {
        MaximumSpeed = 0.5f;
        IsInversed = false;
    }

    protected abstract void InternalRotate(double speed);
    
    public void Rotate(double speed)
    {
        CurrentSpeed = MathUtils.Clamp(speed, 0, MaximumSpeed);
        InternalRotate(CurrentSpeed);
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
        MaximumSpeed = MathUtils.Clamp(MaximumSpeed + speedIncrement, 0, 1);
    }

    public void InverseSpeed(boolean isInversed)
    {
        IsInversed = isInversed;
    }
}
