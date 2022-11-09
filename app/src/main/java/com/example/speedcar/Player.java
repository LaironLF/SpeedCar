package com.example.speedcar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.speedcar.objectClasses.Car;

public class Player extends Car {
    private int bitmapScale;
    private final int height;
    private final int width;
    private double touchPos;

    public Player(Context context, double posX, double posY, Bitmap bitmap){
        super(context, posX, posY, bitmap);
        bitmapScale = 3;
        height = this.bitmap.getHeight();
        width = this.bitmap.getWidth();
        touchPos = posY;
        this.bitmap = Bitmap.createScaledBitmap(this.bitmap, width * bitmapScale, height * bitmapScale, false);
    }

    public void setTouchPos(double touchPos){
        this.touchPos = touchPos;
    }

    @Override
    public void update() {
        if((this.posY < 800 || touchPos < 800) && (this.posY > 380 || touchPos > 380))
            this.move(0, ControlMath.CalculateVelocity(touchPos, this.posY + this.bitmap.getHeight()/2));
    }

    @Override
    public void move(double velX, double velY) {
        this.posX += velX;
        this.posY += velY;
    }
}
