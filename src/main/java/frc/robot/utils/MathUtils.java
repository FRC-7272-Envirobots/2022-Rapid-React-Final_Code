package frc.robot.utils;

public final class MathUtils 
{
    public static double Clamp(double value, double min, double max)
    {
        if (value < min)
        {
            return min;
        }

        if (value > max)
        {
            return max;
        }

        return value;
    }

    public static double Sign(double value)
    {
        return value == 0 ? 0 : (value > 0 ? 1 : -1);
    }

    public static double Abs(double value)
    {
        if (value < 0)
        {
            value *= -1f;
        }
        return value;
    }

    public static double Lerp(double currentValue, double targetValue, double lerpValue)
    {
        return currentValue + (targetValue - currentValue) * lerpValue;
    }
}
