package com.javarush.island.bekkiv.game;

import com.javarush.island.bekkiv.FactoryOrganisms;
import com.javarush.island.bekkiv.ParamConstInstanceOrganisms;
import com.javarush.island.bekkiv.RandomFood;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Herbivores;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Wolf;
import com.javarush.island.bekkiv.organisms.plants.Plants;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Predators;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    public final float ANIMAL_HUNGRY = 0.85F;
    public final float ANIMAL_FULL = 1.15F;

    @Override
    public void run() {
        ParamConstInstanceOrganisms paramConstInstanceOrganisms = new ParamConstInstanceOrganisms();
        FactoryOrganisms factoryOrganisms = new FactoryOrganisms();
        factoryOrganisms.makeAnimals();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(factoryOrganisms, 0, 3, TimeUnit.SECONDS);
        boolean n = true;


        while (n) {

            int numberArea = 0;
            int j = 0;
            System.out.println("размер острова" + " " + factoryOrganisms.mapAnimals.size());
            for (numberArea = 0; numberArea < factoryOrganisms.mapAnimals.size(); numberArea++) {
                List<Organisms> listOrganisms = factoryOrganisms.mapAnimals.get(numberArea);
                for (j = 0; j < listOrganisms.size(); j++) {
                    Organisms organismsFirst = listOrganisms.get(j);

                    if (organismsFirst instanceof Predators) {
                        if (((Predators) organismsFirst).getWeightKg() <= ((Predators) organismsFirst).getWeightKg() * ANIMAL_HUNGRY
                                && ((Predators) organismsFirst).getWeightKg() <= ((Predators) organismsFirst).getWeightKg() * ANIMAL_FULL) {
                            Predators predator = ((Predators) organismsFirst);
                            predator.eat(predator, listOrganisms);
                        }
                    }

                    if (organismsFirst instanceof Herbivores) {
                        if (((Herbivores) organismsFirst).getAmountEat() >= ((Herbivores) organismsFirst).getAmountEat() * ANIMAL_HUNGRY
                                && ((Herbivores) organismsFirst).getAmountEat() <= ((Herbivores) organismsFirst).getAmountEat() * ANIMAL_FULL) {
                            Herbivores herbivore = (Herbivores) organismsFirst;
                            herbivore.eat(herbivore, listOrganisms);
                        }

                    }
                }

                System.out.println(Area.arrayArea[0][0].size());
                System.out.println(Area.arrayArea[0][1].size());
                //System.out.println(Area.arrayArea[1][0].size());
                //System.out.println(Area.arrayArea[1][1].size());

                n = false;
                //System.out.println(FactoryOrganisms.organisms);
            }
        }

    }
}

/*for ( i = 0; i < Area.arrayArea.length; i++) {
        for ( j = 0; j < Area.arrayArea[i].length; j++) {
            List<Organisms> tempListOrganisms = Area.arrayArea[i][j];
            for ( k = 0; k < tempListOrganisms.size(); k++) {
                Organisms organismsFirst = tempListOrganisms.get(k);
                for ( m = 0; m < tempListOrganisms.size(); m++) {
                    Organisms organismsSecond = tempListOrganisms.get(m);

                    if (organismsFirst instanceof Predators) {
                        if (((Predators) organismsFirst).getWeightKg() <= paramConstInstanceOrganisms.getWeight(organismsFirst)) {
                            if (organismsSecond instanceof Herbivores) {
                                if (RandomFood.getProbabilityFood() <= RandomFood.getValueTableProbability(organismsFirst, organismsSecond)) {
                                    tempListOrganisms.remove(m);
                                    System.out.println("Волк выгнал кабана из игры");
                                    m = tempListOrganisms.size() - 1;
                                }
                            }
                        }
                    }

                    if (organismsFirst instanceof Herbivores) {
                        if (organismsSecond instanceof Plants) {
                            System.out.println("Кабан выгнал растение из игры");
                            tempListOrganisms.remove(m);
                            m = tempListOrganisms.size() - 1;
                        }
                    }

                }
            }
        }
    }*/



