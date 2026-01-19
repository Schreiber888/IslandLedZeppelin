package com.javarush.island.bekkiv.organisms.animals.predatoryAnimals;

import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;

@OrganismsAnnotation(weightKg = 500, amountAnimalCell = 5, speed = 2, amountEat = 80)
public class Bear extends Predators{

    public Bear(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }
}
