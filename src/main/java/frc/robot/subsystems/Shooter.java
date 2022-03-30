package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase 
{ 
  public Talon Motor;

  public TalonSRX TalonMotor;

  public double MaximumSpeed;

  public double CurrentSpeed;

  public Shooter(double maximumSpeed, int motorID)
  {
    Motor = new Talon(motorID);
    TalonMotor = new TalonSRX(5);
    MaximumSpeed = maximumSpeed;
    CurrentSpeed = 0;
  }

  public void Rotate(double speed)
  {
    CurrentSpeed = speed;
    if (CurrentSpeed > MaximumSpeed)
    {
        CurrentSpeed = MaximumSpeed;
    }

    if (CurrentSpeed < 0)
    {
        CurrentSpeed = 0;
    }
    Motor.set(CurrentSpeed);
  }

  public void Accel(double minSpeed, double accel)
  {
      if (CurrentSpeed >= MaximumSpeed)
      {
        CurrentSpeed = MaximumSpeed;
        return;
      }

      var currentSpeed = CurrentSpeed;
      if (currentSpeed < minSpeed)
      {
        currentSpeed = minSpeed;
      }

      currentSpeed *= accel;
      if (currentSpeed > MaximumSpeed)
      {
        currentSpeed = MaximumSpeed;
      }
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
}
