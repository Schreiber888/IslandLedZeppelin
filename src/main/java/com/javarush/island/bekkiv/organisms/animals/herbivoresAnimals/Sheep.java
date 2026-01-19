package com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals;


import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;
import com.javarush.island.bekkiv.organisms.animals.Animal;

@OrganismsAnnotation(weightKg = 70, amountAnimalCell = 140, speed = 3, amountEat = 15)
public class Sheep extends Herbivores {


    public Sheep(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }
}
