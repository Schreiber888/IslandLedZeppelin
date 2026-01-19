package com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals;


import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;
import com.javarush.island.bekkiv.organisms.animals.Animal;

@OrganismsAnnotation(weightKg = 400, amountAnimalCell = 20, speed = 4, amountEat = 60)
public class Horse extends Herbivores {


    public Horse(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }
}
