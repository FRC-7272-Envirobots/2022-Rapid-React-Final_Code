package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class ShooterHandler extends MotorHandler
{
    public TalonFX Shooter;
    
    public ShooterHandler(int shooterID) 
    {
        super();
        Shooter = new TalonFX(shooterID);
    }

    @Override
    protected void InternalRotate(double speed)
    {
        Shooter.set(TalonFXControlMode.PercentOutput, IsInversed ? -speed : speed);
    }
}