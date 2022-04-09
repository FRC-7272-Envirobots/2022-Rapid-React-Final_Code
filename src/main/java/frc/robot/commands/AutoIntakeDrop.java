package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeLiftHandler;

public class AutoIntakeDrop extends CommandBase 
{
  public final IntakeLiftHandler IntakeLiftHandler;

  public int Timer;

  public AutoIntakeDrop(IntakeLiftHandler intakeLiftHandler) 
  {
    IntakeLiftHandler = intakeLiftHandler;
    addRequirements(intakeLiftHandler);
  }

  @Override
  public void initialize()
  {
    IntakeLiftHandler.IntakeArm.setSelectedSensorPosition(0);
  }

  @Override
  public void execute() 
  {
    IntakeLiftHandler.IntakeArm.set(TalonSRXControlMode.PercentOutput, -0.5f);
    SmartDashboard.putNumber("Current Intake Sensor Position", IntakeLiftHandler.IntakeArm.getSelectedSensorPosition() / 10f);
  }

  @Override
  public void end(boolean interrupted)
  {
    IntakeLiftHandler.IntakeArm.set(TalonSRXControlMode.PercentOutput, 0);
  }

  @Override
  public boolean isFinished() 
  {
    return (IntakeLiftHandler.IntakeArm.getSelectedSensorPosition() / 10f) > AutoIntakeLift.RotationCriteria;
  }
}