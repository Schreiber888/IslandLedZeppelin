package com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals;


import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;
import com.javarush.island.bekkiv.organisms.animals.Animal;

@OrganismsAnnotation(weightKg = 2, amountAnimalCell = 150, speed = 2, amountEat = 0.45F)
public class Rabbit extends Herbivores {


    public Rabbit(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }
}
