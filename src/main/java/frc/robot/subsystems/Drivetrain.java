package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase 
{
  public final WPI_VictorSPX[] Motors;
  public static final int LeftBack = 0;
  public static final int RightFront = 1;
  public static final int LeftFront = 2;
  public static final int RightBack = 3;

  public final MotorControllerGroup[] MotorControllers;
  public static final int Left = 0;
  public static final int Right = 1;

  public final DifferentialDrive Drive;

  public final DutyCycleEncoder Encoder;

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

    Encoder = new DutyCycleEncoder(GetMotorIDFromArrayID(LeftFront));
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
}
