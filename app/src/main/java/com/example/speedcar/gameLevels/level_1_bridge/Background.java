package com.example.speedcar.gameLevels.level_1_bridge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.speedcar.Game;
import com.example.speedcar.R;
import com.example.speedcar.objectClasses.Object;

public class Background extends Object{
    private final Bitmap bitmap;
    private final double[] bitmaps;
    private final int bitmapWidth;

    private int scaleBitmap = 3;

    public Background(Context context, int ScreenWidth, double posX, double posY, Bitmap bitmap) {
        super(posX, posY);
        this.bitmap = Bitmap.createScaledBitmap(bitmap,
                bitmap.getWidth() * scaleBitmap,
                bitmap.getHeight() * scaleBitmap,
                false);
        bitmapWidth = this.bitmap.getWidth();
        bitmaps = new double[(int)ScreenWidth/bitmapWidth + 2];
        bitmaps[0] = this.posX;
        for (int i = 1; i < bitmaps.length; i++)
            bitmaps[i] = bitmaps[i-1] + bitmapWidth;

    }

    @Override
    public void draw(Canvas canvas) {
        for(double cords : bitmaps){
            canvas.drawBitmap(this.bitmap, (float) cords, (float) this.posY, null);
        }

    }

    @Override
    public void update() {


    }

    @Override
    public void move(double velX, double velY) {
        for(int i =0; i<bitmaps.length; i++){
            bitmaps[i] +=velX;
        }
        if(bitmaps[0] + bitmapWidth < velX){
            for (int j = 0; j < bitmaps.length - 1; j++)
                bitmaps[j] = bitmaps[j+1];
            bitmaps[bitmaps.length - 1] = bitmaps[bitmaps.length-2] + bitmapWidth;
        }
    }

}
