package com.example.speedcar.objectClasses;

public class Point {
    private int x = 0;
    private int y = 0;

    // Конструктор класса точки
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /*
    Задание координат точки
     */
    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void  setY(int y){
        this.y = y;
    }

    /*
    Получение координат экземпляра точки
     */
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
