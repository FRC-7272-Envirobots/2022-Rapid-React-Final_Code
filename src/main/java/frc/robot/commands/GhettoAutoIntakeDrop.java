package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeLiftHandler;

public class GhettoAutoIntakeDrop extends CommandBase 
{
  public final IntakeLiftHandler IntakeLiftHandler;

  public static boolean Resetted = false;

  public int Timer;

  public GhettoAutoIntakeDrop(IntakeLiftHandler intakeLiftHandler) 
  {
    IntakeLiftHandler = intakeLiftHandler;
    addRequirements(intakeLiftHandler);
  }

  @Override
  public void initialize()
  {
    GhettoAutoIntakeLift.Resetted = true;
    Timer = 0;
  }

  @Override
  public void execute() 
  {
    IntakeLiftHandler.IntakeArm.set(TalonSRXControlMode.PercentOutput, -0.4f);
  }

  @Override
  public void end(boolean interrupted)
  {
    IntakeLiftHandler.IntakeArm.set(TalonSRXControlMode.PercentOutput, 0);
  }

  @Override
  public boolean isFinished() 
  {
    return ++Timer > 10 || !Resetted;
  }
}