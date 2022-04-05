package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class ShooterHandler extends MotorHandler
{
    public TalonFX Index;

    public TalonFX Shooter;
    
    public ShooterHandler(int indexID, int shooterID) 
    {
        super();
        Index = new TalonFX(indexID);
        Shooter = new TalonFX(shooterID);
    }

    @Override
    protected void InternalRotate(double speed)
    {
        Index.set(TalonFXControlMode.PercentOutput, CurrentSpeed);
        Shooter.set(TalonFXControlMode.PercentOutput, CurrentSpeed);
    }
}