package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeLiftHandler;

public class AutoIntakeLift extends CommandBase 
{
  public final IntakeLiftHandler IntakeLiftHandler;

  public static double RotationCriteria;

  public AutoIntakeLift(IntakeLiftHandler intakeLiftHandler) 
  {
    IntakeLiftHandler = intakeLiftHandler;
    addRequirements(intakeLiftHandler);
    SmartDashboard.putNumber("Rot Crit", 180);
  }

  @Override
  public void initialize()
  {
    RotationCriteria = SmartDashboard.getNumber("Rot Crit", 180);
    IntakeLiftHandler.IntakeArm.setSelectedSensorPosition(0);
  }

  @Override
  public void execute() 
  {
    IntakeLiftHandler.IntakeArm.set(TalonSRXControlMode.PercentOutput, 0.4f);
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
    return (IntakeLiftHandler.IntakeArm.getSelectedSensorPosition() / 10f) > RotationCriteria;
  }
}