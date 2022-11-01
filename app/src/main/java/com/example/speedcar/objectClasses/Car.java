package com.example.speedcar.objectClasses;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class Car extends Object{
    protected Bitmap bitmap;

    public Car(Context context, double posX, double posY, Bitmap bitmap) {
        super(posX, posY);
        this.bitmap = bitmap;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap,(float)posX, (float)posY, null);
    }
}
