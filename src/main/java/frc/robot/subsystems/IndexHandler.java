package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class IndexHandler extends MotorHandler
{
    public TalonFX Index;
    
    public IndexHandler(int indexID) 
    {
        super();
        Index = new TalonFX(indexID);
    }

    @Override
    protected void InternalRotate(double speed)
    {
        Index.set(TalonFXControlMode.PercentOutput, CurrentSpeed);
    }
}