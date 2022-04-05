package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.data.Vector2;

public class Drivetrain extends SubsystemBase 
{
  // Corresponding ID as assigned on PhoenixTuner is ID value here + 1
  public final WPI_VictorSPX[] Motors;
  public static final int LeftBack = 0;
  public static final int RightFront = 1;
  public static final int LeftFront = 2;
  public static final int RightBack = 3;

  public final MotorControllerGroup[] MotorControllers;
  public final DutyCycleEncoder[] Encoders;
  public static final int Left = 0;
  public static final int Right = 1;

  public final DifferentialDrive Drive;

  public Drivetrain() 
  {
    Motors = new WPI_VictorSPX[4];
    for (int motorInit = 0; motorInit < Motors.length; motorInit++)
    {
      Motors[motorInit] = new WPI_VictorSPX(GetMotorIDFromArrayID(motorInit));
    }

    MotorControllers = new MotorControllerGroup[2];
    MotorControllers[Left] = new MotorControllerGroup(Motors[LeftFront], Motors[LeftBack]);
    MotorControllers[Right] = new MotorControllerGroup(Motors[RightFront], Motors[RightBack]);
    Drive = new DifferentialDrive(MotorControllers[Left], MotorControllers[Right]);

    Encoders = new DutyCycleEncoder[2];
    Encoders[Left] = new DutyCycleEncoder(0);
    Encoders[Right] = new DutyCycleEncoder(1);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }

  public int GetMotorIDFromArrayID(int id)
  {
    return ++id;
  }

  public void TankDrive(double leftSpeed, double rightSpeed) 
  {
    Drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void ArcadeDrive(double speed, double rotation)
  {
    Drive.arcadeDrive(speed, rotation);
  }

  public void ResetEncoders()
  {
    for (int i = 0; i < Encoders.length; i++)
    {
      Encoders[i].reset();
    }
  }

  public Vector2 GetEncoderDrive()
  {
    return new Vector2(Encoders[Left].getDistance(), Encoders[Right].getDistance());
  }
}
