package com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals;


import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;
import com.javarush.island.bekkiv.organisms.animals.Animal;

@OrganismsAnnotation(weightKg = 60, amountAnimalCell = 150, speed = 3, amountEat = 10)
public class Goat extends Herbivores {


    public Goat(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }
}
