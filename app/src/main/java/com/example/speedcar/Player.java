package com.example.speedcar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.speedcar.objectClasses.Car;

public class Player extends Car {

    public Player(Context context, double posX, double posY, Bitmap bitmap){
        super(context, posX, posY, bitmap);

    }


    public void setPosition(double x, double y) {
        this.posX = x;
        this.posY = y;
    }

    @Override
    public void update() {

    }
}
