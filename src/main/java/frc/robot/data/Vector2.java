package frc.robot.data;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vector2
{
    public double X;

    public double Y;

    public Vector2(double x, double y)
    {
        X = x;
        Y = y;
    }

    public void SmartDashboardLog(String identifier, Boolean multiple)
    {
        if (multiple)
        {
            SmartDashboard.putNumber(identifier + ".X", X);
            SmartDashboard.putNumber(identifier + ".Y", Y);
        }
        else
        {
            SmartDashboard.putString(identifier, "{" + X + ", " + Y + "}");
        }
    }

    public static void SmartDashboardLog(Vector2 value, String identifier, Boolean multiple)
    {
        value.SmartDashboardLog(identifier, multiple);
    }
}
