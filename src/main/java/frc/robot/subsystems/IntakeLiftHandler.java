package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class IntakeLiftHandler extends MotorHandler
{
    public TalonFX IntakeArm;

    public IntakeLiftHandler(int intakeArm) 
    {
        super();
        IntakeArm = new TalonFX(intakeArm);
    }

    @Override
    protected void InternalRotate(double speed)
    {
        IntakeArm.set(TalonFXControlMode.PercentOutput, CurrentSpeed);
    }
}