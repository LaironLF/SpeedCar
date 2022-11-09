package com.example.speedcar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.speedcar.gameLevels.level_1_bridge.Background;

/**
 * Игровой мэнеджер, все объекты в игре, ответственен за обновление и прорисовку всех объектов на экране
 */


public class Game extends SurfaceView implements SurfaceHolder.Callback {
    private final Player player;
    private GameLoop gameLoop;
    private Background background;
    private Background borderFront;


    public Game(Context context) {
        super(context);
        getContext();



        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        gameLoop = new GameLoop(this, surfaceHolder);

        background = new Background(getContext(), size.x, 0, 50,
                AssetGetter.getBitmapFromAsset(getContext(), "game-res/road.png"));
        borderFront = new Background(getContext(), size.x, 0, 900,
                AssetGetter.getBitmapFromAsset(getContext(), "game-res/border.png"));



        player = new Player(getContext(), 500, 500,
                AssetGetter.getBitmapFromAsset(getContext(), "game-res/car.png"));




        setFocusable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                player.setTouchPos((double) event.getY());
                return true;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        if(gameLoop.getState().equals(Thread.State.TERMINATED)){
            gameLoop = new GameLoop(this, surfaceHolder);
        }
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        background.draw(canvas);
        player.draw(canvas);
        borderFront.draw(canvas);
    }

    public void update() {
        background.move(-20,0);
        borderFront.move(-22, 0);
        player.update();
    }
}
