package com.example.speedcar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.View;

public class HorseView extends View {
    int screenWidth, screenHeight, newWidth, newHeight;
    int cloudX = 0, mountainX = 0, grassX = 0;
    int horseX, horseY, horseFrame = 0;
    Bitmap cloud, mountain, grass;
    Bitmap horse[] = new Bitmap[3];
    Handler handler;
    Runnable runnable;
    final long UPDATE_MILLIS = 30;


    public HorseView(Context context) {
        super(context);
        mountain = BitmapFactory.decodeResource(getResources(), R.drawable.backbackcity);
        cloud = BitmapFactory.decodeResource(getResources(), R.drawable.backcity);
        grass = BitmapFactory.decodeResource(getResources(), R.drawable.neareststructure);
        horse[0] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_0001);
        horse[1] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_0002);
        horse[2] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_0003);
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        float height = cloud.getHeight();
        float width = cloud.getWidth();
        float ratio = width /height;
        newHeight = screenHeight;
        newWidth = (int) (ratio * screenHeight);
        cloud = Bitmap.createScaledBitmap(cloud, newWidth, newHeight, false);
        mountain = Bitmap.createScaledBitmap(mountain, newWidth, newHeight, false);
        grass = Bitmap.createScaledBitmap(grass, newWidth, newHeight, false);
        for (int i = 0; i < 3; i++){
            horse[i] = Bitmap.createScaledBitmap(horse[i], 782, 250, false);
        }

        horseX = screenWidth/ 2 - 200;
        horseY = screenHeight/2 - 300;

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        cloudX -=1;
        if(cloudX < -newWidth){
            cloudX = 0;
        }
        canvas.drawBitmap(cloud, cloudX, 0, null);
        if(cloudX < screenWidth - newWidth){
            canvas.drawBitmap(cloud, cloudX+newWidth, 0, null);
        }
        mountainX -=3;
        if(mountainX < -newWidth){
            mountainX = 0;
        }
        canvas.drawBitmap(mountain, mountainX, 0, null);
        if(mountainX < screenWidth - newWidth){
            canvas.drawBitmap(mountain, mountainX+newWidth, 0, null);
        }
        grassX -=10;
        if(grassX < -newWidth){
            grassX = 0;
        }
        canvas.drawBitmap(grass, grassX, 0, null);
        if(grassX < screenWidth - newWidth){
            canvas.drawBitmap(grass, grassX+newWidth, 0, null);
        }
        horseFrame++;
        if (horseFrame == 3){
            horseFrame = 0;
        }
        canvas.drawBitmap(horse[horseFrame], horseX, horseY, null);
        handler.postDelayed(runnable, UPDATE_MILLIS);
    }
}
