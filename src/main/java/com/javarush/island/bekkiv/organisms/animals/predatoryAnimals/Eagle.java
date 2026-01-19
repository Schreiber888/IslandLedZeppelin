package com.javarush.island.bekkiv.organisms.animals.predatoryAnimals;

import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;

@OrganismsAnnotation(weightKg = 6, amountAnimalCell = 20, speed = 3, amountEat = 1)
public class Eagle extends Predators {

    public Eagle(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }

}
