package com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals;


import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;
import com.javarush.island.bekkiv.organisms.animals.Animal;

@OrganismsAnnotation(weightKg = 300, amountAnimalCell = 20, speed = 4, amountEat = 50)
public class Deer extends Herbivores {


    public Deer(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }
}
