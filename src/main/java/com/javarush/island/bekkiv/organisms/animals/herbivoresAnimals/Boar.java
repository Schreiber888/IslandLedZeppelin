package com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals;


import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;

@OrganismsAnnotation(weightKg = 400, amountCell = 1, speed = 2, amountEat = 50)
public class Boar extends Herbivores {

    public Boar(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }


}
