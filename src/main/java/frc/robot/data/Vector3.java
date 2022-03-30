package frc.robot.data;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vector3 
{
    public double X;

    public double Y;

    public double Z;

    public Vector3(double x, double y, double z)
    {
        X = x;
        Y = y;
        Z = y;
    }

    public void SmartDashboardLog(String identifier, Boolean multiple)
    {
        if (multiple)
        {
            SmartDashboard.putNumber(identifier + ".X", X);
            SmartDashboard.putNumber(identifier + ".Y", Y);
            SmartDashboard.putNumber(identifier + ".Z", Z);
        }
        else
        {
            SmartDashboard.putString(identifier, "{" + X + ", " + Y + ", " + Z + "}");
        }
    }

    public static void SmartDashboardLog(Vector3 value, String identifier, Boolean multiple)
    {
        value.SmartDashboardLog(identifier, multiple);
    }
}
