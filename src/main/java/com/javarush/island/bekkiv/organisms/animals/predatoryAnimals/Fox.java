package com.javarush.island.bekkiv.organisms.animals.predatoryAnimals;

import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;

@OrganismsAnnotation(weightKg = 8, amountAnimalCell = 30, speed = 2, amountEat = 2)
public class Fox extends Predators {


    public Fox(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }

}
