package com.javarush.island.bekkiv.organisms.animals.predatoryAnimals;

import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;

@OrganismsAnnotation(weightKg = 15, amountAnimalCell = 30, speed = 1, amountEat = 3)
public class Boa extends Predators {

    public Boa(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }

}
