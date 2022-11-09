package com.example.speedcar;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import java.util.Observer;

public class GameLoop extends Thread{

    private static final double MAX_UPS = 25;
    private static final double UPS_PERIOD = 1E+3/MAX_UPS;

    private boolean isRunning = false;
    private SurfaceHolder surfaceHolder;
    private Game game;
    private Canvas canvas;
    private double averageUPS;
    private double averageFPS;
    private long prev;
    private int millis;

    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        this.game = game;
        this.millis = 0;
        this.prev = System.currentTimeMillis();
    }

    public double getAverageUPS() {
        return averageUPS;
    }

    public double getAverageFPS() {
        return averageFPS;
    }

    public void startLoop() {
        isRunning = true;
        start();
    }
    public void stopLoop() {
        isRunning = false;
    }

    @Override
    public void run() {
        super.run();
        while(isRunning) {
            canvas = null;
            try {
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    long now = System.currentTimeMillis();
                    while (now - millis < prev) {
                        Thread.sleep(1);
                        now = System.currentTimeMillis();
                    }

                    game.update();
                    game.draw(canvas);
                    prev = now;
                }

            } catch(Exception ex) {
                ex.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
