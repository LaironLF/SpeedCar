package com.example.speedcar;

public class ControlMath {
    private final double maxVelocity = 20;
    private final double VelPer = 20/1000;
    public static double CalculateVelocity(double touchPos, double carPos){
        double velocity = Math.pow((touchPos-carPos) * 20/1000, 2);
        if (touchPos < carPos)
            return -velocity;
        else if(touchPos > carPos)
            return velocity;
        return 0;
    }
}
