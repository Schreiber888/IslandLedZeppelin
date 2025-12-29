package com.javarush.island.bekkiv.organisms.animals.predatoryAnimals;


import com.javarush.island.bekkiv.RandomFood;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.capabilities.Eatable;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Herbivores;

import java.util.List;

public class Predators extends Animal implements Eatable {

    @Override
    public void eat(Animal organismsFirst, List<Organisms> listOrganisms) {// тип Animal может помешать
        for (int i = 0; i < listOrganisms.size(); i++) {
            Organisms organismsSecond =  listOrganisms.get(i);
            if (organismsSecond instanceof Herbivores) {
                if (RandomFood.getProbabilityFood() <= RandomFood.getValueTableProbability(organismsFirst, organismsSecond)) {
                    listOrganisms.remove(i);
                    System.out.println("Волк выгнал кабана из игры");
                    i = listOrganisms.size() - 1;
                }
            }
        }
    }
}
