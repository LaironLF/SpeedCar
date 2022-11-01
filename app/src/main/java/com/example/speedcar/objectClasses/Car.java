package com.example.speedcar.objectClasses;
import com.example.speedcar.objectClasses.Point;
import android.graphics.Bitmap;

public class Car {
    Bitmap imageCar;
    Point carCoordinates;

    public Car(Bitmap imageCar, Point carCoordinates){
        this.imageCar = imageCar;
        this.carCoordinates = carCoordinates;
    }

    public void CarMoveX(int x){
        this.carCoordinates.setX(x);
    }


}
