package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class LoadingHandler extends MotorHandler
{
    public TalonFX Column;

    public TalonFX Intake;
    
    public LoadingHandler(int columnID, int intakeID) 
    {
        super();
        Column = new TalonFX(columnID);
        Intake = new TalonFX(intakeID);
    }

    @Override
    protected void InternalRotate(double speed)
    {
        Column.set(TalonFXControlMode.PercentOutput, -CurrentSpeed);
        Intake.set(TalonFXControlMode.PercentOutput, CurrentSpeed);
    }
}