package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class IntakeLiftHandler extends MotorHandler
{
    public TalonSRX IntakeArm;

    public IntakeLiftHandler(int intakeArm) 
    {
        super();
        IntakeArm = new TalonSRX(intakeArm);
        IntakeArm.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    }

    @Override
    protected void InternalRotate(double speed)
    {
        IntakeArm.setSensorPhase(IsInversed);
        IntakeArm.set(TalonSRXControlMode.PercentOutput, IsInversed ? -speed * 0.75f : speed);
    }
}