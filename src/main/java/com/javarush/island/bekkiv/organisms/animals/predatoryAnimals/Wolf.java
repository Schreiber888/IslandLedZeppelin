package com.javarush.island.bekkiv.organisms.animals.predatoryAnimals;


import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;

@OrganismsAnnotation(weightKg = 50, amountCell = 2, amountEat = 8, speed = 3)
public class Wolf extends Predators implements ParamWolf {


    public Wolf(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }



}
