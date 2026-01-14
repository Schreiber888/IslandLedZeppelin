package com.javarush.island.bekkiv.organisms.animals.predatoryAnimals;


import com.javarush.island.bekkiv.RandomFood;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.capabilities.Eatable;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Herbivores;

import java.util.List;

public abstract class Predators extends Animal implements Eatable {


    public Predators(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }

    @Override
    public void eat(Animal organismsFirst, List<Organisms> listOrganisms) {// тип Animal может помешать
        for (int i = 0; i < listOrganisms.size(); i++) {
            Organisms organismsSecond =  listOrganisms.get(i);
            if (organismsSecond instanceof Herbivores) {
                if (RandomFood.getProbabilityFood() <= RandomFood.getValueTableProbability(organismsFirst, organismsSecond)) {
                    System.out.println("Волк вес: " + " " + organismsFirst.getWeightKg());
                    if ((organismsFirst.getWeightKg() * 0.2) >= ((Herbivores) organismsSecond).getWeightKg()) {
                        organismsFirst.setWeightKg(organismsFirst.getWeightKg() + (organismsFirst.getWeightKg() * 0.2F));
                    } else {
                        organismsFirst.setWeightKg(organismsFirst.getWeightKg() + ((Herbivores) organismsSecond).getWeightKg());
                    }
                    System.out.println("Волк выгнал кабана из игры");
                    System.out.println("Волк вес: " + " " + organismsFirst.getWeightKg());
                    listOrganisms.remove(i);
                    i = listOrganisms.size() - 1;
                }
            }
        }
    }
}
