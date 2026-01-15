package com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals;


import com.javarush.island.bekkiv.RandomFood;
import com.javarush.island.bekkiv.area.Constant;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.capabilities.Eatable;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Predators;
import com.javarush.island.bekkiv.organisms.plants.Plants;

import java.util.List;

public abstract class Herbivores extends Animal implements Eatable {

    public Herbivores(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        super(weightKg, amountAnimalCell, amountEat, speed);
    }

    @Override
    public void eat(Animal organismsFirst, List<Organisms> listOrganisms) {
        for (int i = 0; i < listOrganisms.size(); i++) {
            Organisms organismsSecond = listOrganisms.get(i);
            if (organismsSecond instanceof Plants) {
                if (RandomFood.getProbabilityFood() <= RandomFood.getValueTableProbability(organismsFirst, organismsSecond)) { //тут может ошибка
                    System.out.println("Кабан вес: " + " " + organismsFirst.getWeightKg());
                    if ((organismsFirst.getWeightKg() * Constant.COEFFICIENT_GAIN_WEIGHT) >= Plants.WEIGHT) {
                        organismsFirst.setWeightKg(organismsFirst.getWeightKg() + Plants.WEIGHT);
                    } else {
                        organismsFirst.setWeightKg(organismsFirst.getWeightKg() + (organismsFirst.getWeightKg() * Constant.COEFFICIENT_GAIN_WEIGHT));
                    }
                    System.out.println("Кабан выгнал растение из игры");
                    System.out.println("Кабан вес: " + " " + organismsFirst.getWeightKg());
                    listOrganisms.remove(i);
                    i = listOrganisms.size() - 1;
                }
            }
        }
    }


}
