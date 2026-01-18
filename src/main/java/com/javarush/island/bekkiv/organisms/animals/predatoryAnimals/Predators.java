package com.javarush.island.bekkiv.organisms.animals.predatoryAnimals;


import com.javarush.island.bekkiv.FactoryOrganisms;
import com.javarush.island.bekkiv.RandomFood;
import com.javarush.island.bekkiv.area.Constant;
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
    public synchronized void eat(Animal organismsFirst, List<Organisms> listOrganisms) {// тип Animal может помешать
        for (int i = 0; i < listOrganisms.size(); i++) {
            Organisms organismsSecond =  listOrganisms.get(i);
            float parameterArgumentsWeightKg = FactoryOrganisms.getParameterArgumentsWeightKg(organismsFirst);
            if (organismsSecond instanceof Herbivores
                    && organismsFirst.getWeightKg() <= parameterArgumentsWeightKg) {
                if (RandomFood.getProbability() <= RandomFood.getValueTableProbability(organismsFirst, organismsSecond)) {
                    //System.out.println("Волк вес: " + " " + organismsFirst.getWeightKg());
                    if ((organismsFirst.getWeightKg() * Constant.COEFFICIENT_GAIN_WEIGHT) >= ((Herbivores) organismsSecond).getWeightKg()) {
                        organismsFirst.setWeightKg(organismsFirst.getWeightKg() + ((Herbivores) organismsSecond).getWeightKg());
                        listOrganisms.remove(i);
                    } else {
                        organismsFirst.setWeightKg(organismsFirst.getWeightKg() + (organismsFirst.getWeightKg() * Constant.COEFFICIENT_GAIN_WEIGHT));
                        listOrganisms.remove(i);
                        i = listOrganisms.size() - 1;
                    }
                    System.out.println("Волк выгнал кабана из игры");
                    //System.out.println("Волк вес: " + " " + organismsFirst.getWeightKg());
                    //listOrganisms.remove(i);
                   //i = listOrganisms.size() - 1;
                }
            }
        }
    }
}
