package com.javarush.island.bekkiv.organisms.plants;

import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;
import com.javarush.island.bekkiv.organisms.Organisms;

@OrganismsAnnotation(weightKg = 1, amountAnimalCell = 1000, speed = 0, amountEat = 0)
public class Plants extends Organisms implements ParamPlants {
   //public int amountGrass = 4;
    int millis = 20;
    public float weightKg; //
    public int amountAnimalCell;
    public float amountEat;
    public int speed;


    public Plants(float weight, int amountInCell, float amountEat, int speed) {
        this.weightKg = weight;
        this.amountAnimalCell = amountInCell;
        this.amountEat = amountEat;
        this.speed = speed;
    }

    public Plants(float weight, int amountInCell) {
        this.weightKg = weight;
        this.amountAnimalCell = amountInCell;
    }




}
