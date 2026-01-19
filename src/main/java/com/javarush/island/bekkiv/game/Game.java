package com.javarush.island.bekkiv.game;
import com.javarush.island.bekkiv.FactoryOrganisms;
import com.javarush.island.bekkiv.RandomFood;
import com.javarush.island.bekkiv.area.Constant;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Herbivores;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Predators;

import java.util.List;

public class Game implements Runnable {


    @Override
    public void run() {
        int n = 0;

        while (n < Constant.GAME_CYCLE) {

            try {
                FactoryOrganisms.weightLossAnimals();
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }

            int numberArea;
            int j;

            for (numberArea = 0; numberArea < FactoryOrganisms.mapAnimals.size(); numberArea++) {
                List<Organisms> listOrganisms = FactoryOrganisms.mapAnimals.get(numberArea);
                for (j = 0; j < listOrganisms.size(); j++) {
                    Organisms organismsFirst = listOrganisms.get(j);

                    if (organismsFirst instanceof Predators) {
                        float parameterArgumentsWeightKg = FactoryOrganisms.getParameterArgumentsWeightKg(organismsFirst);
                        //System.out.println("Вес животного параметр " + parameterArgumentsWeightKg);
                        if (((Predators) organismsFirst).getWeightKg() <= parameterArgumentsWeightKg * Constant.ANIMAL_HUNGRY) {
                            Predators predator = ((Predators) organismsFirst);
                            predator.eat(predator, listOrganisms);
                        }
                        //System.out.println("а теперь вес животного " + ((Predators) organismsFirst).getWeightKg());
                    }

                    if (organismsFirst instanceof Herbivores) {
                        float parameterArgumentsWeightKg = FactoryOrganisms.getParameterArgumentsWeightKg(organismsFirst);
                        if (((Herbivores) organismsFirst).getWeightKg() <= parameterArgumentsWeightKg * Constant.ANIMAL_HUNGRY) {
                            Herbivores herbivore = (Herbivores) organismsFirst;
                            herbivore.eat(herbivore, listOrganisms);
                        }

                    }
                    if (organismsFirst instanceof Predators || organismsFirst instanceof Herbivores) {
                        if (RandomFood.getProbability() >= Constant.PROBABILITY_REPRODUCTION) {
                            Animal animal = (Animal) organismsFirst;
                            animal.reproduce(animal, listOrganisms);
                        }
                    }
                }

                //System.out.println("Размер ареала 1: " + Area.arrayArea[0][0].size());
                //System.out.println("Размер ареала 2: " + Area.arrayArea[0][1].size());

                //System.out.println(numberArea);
            }

            n++;
        }
    }
}



