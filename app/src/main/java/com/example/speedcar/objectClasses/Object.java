package com.example.speedcar.objectClasses;

import android.graphics.Canvas;

public abstract class Object {
    protected double posX;
    protected double posY;
    protected double velX;
    protected double velY;

    public Object(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
    }

    public abstract void draw(Canvas canvas);
    public abstract void update();
    public abstract void move(double velX, double velY);

    public double getX(){
        return this.posX;
    }
    public double getY() { return this.posY; }

}
