package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.data.MotorSystems;

public class CycleMotor extends CommandBase 
{
    public RobotContainer RobotContainer;

    public boolean CycleDirection;

    public CycleMotor(RobotContainer container, boolean forward) 
    {
        RobotContainer = container;
        CycleDirection = forward;
    }

    @Override
    public void initialize()
    {
        if (CycleDirection)
        {
            switch (RobotContainer.ActiveSystem)
            {
                case Index:
                    RobotContainer.ActiveSystem = MotorSystems.Shooter;
                    SmartDashboard.putString("Active Motor System", "Shooter");
                    break;

                case Shooter:
                    RobotContainer.ActiveSystem = MotorSystems.IntakeLift;
                    SmartDashboard.putString("Active Motor System", "Intake Lift");
                    break;

                case IntakeLift:
                    RobotContainer.ActiveSystem = MotorSystems.Loading;
                    SmartDashboard.putString("Active Motor System", "Loading");
                    break;
                
                case Loading:
                    RobotContainer.ActiveSystem = MotorSystems.Index;
                    SmartDashboard.putString("Active Motor System", "Index");
                    break;
            }
        }
        else
        {
            switch (RobotContainer.ActiveSystem)
            {
                case Index:
                    RobotContainer.ActiveSystem = MotorSystems.Loading;
                    SmartDashboard.putString("Active Motor System", "Loading");
                    break;

                case Shooter:
                    RobotContainer.ActiveSystem = MotorSystems.Index;
                    SmartDashboard.putString("Active Motor System", "Index");
                    break;

                case IntakeLift:
                    RobotContainer.ActiveSystem = MotorSystems.Shooter;
                    SmartDashboard.putString("Active Motor System", "Shooter");
                    break;
                
                case Loading:
                    RobotContainer.ActiveSystem = MotorSystems.IntakeLift;
                    SmartDashboard.putString("Active Motor System", "Intake Lift");
                    break;
            }
        }
    }

    @Override
    public boolean isFinished() 
    {
      return true;
    }
}