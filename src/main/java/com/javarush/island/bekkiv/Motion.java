package com.javarush.island.bekkiv;

import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.area.Constant;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.capabilities.Moveable;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Motion implements Runnable, Moveable {
    @Override
    public void run() {

        move();

    }

    @Override
    public synchronized void move() {
        for (int row = 0; row < Area.arrayArea.length; row++) {
            for (int colon = 0; colon < Area.arrayArea[row].length; colon++) {
                List<Organisms> organismsList = Area.arrayArea[row][colon];
                for (int animalMove = 0; animalMove < organismsList.size(); animalMove++) {
                    Organisms animal = organismsList.get(animalMove);
                    int parameterArgumentsSpeed = FactoryOrganisms.getParameterArgumentsSpeed(animal);
                    if (parameterArgumentsSpeed > 0) {
                        if (RandomFood.getProbability() > Constant.PROBABILITY_MOTION) {
                            if (animal instanceof Animal) {
                                int nextRow = ThreadLocalRandom.current().nextInt(parameterArgumentsSpeed);
                                int nextColon = ThreadLocalRandom.current().nextInt(parameterArgumentsSpeed);
                                if (nextRow + nextColon <= parameterArgumentsSpeed) {
                                    if (nextRow >= row) {
                                        nextRow = row;
                                    }
                                    if (nextColon >= colon) {
                                        nextColon = colon;
                                    }

                                    if (getAmountAnimalsInListOrganisms(animal, Area.arrayArea[nextRow][nextColon]) < FactoryOrganisms.getParameterArgumentsAmountCell(animal)) {
                                        Area.arrayArea[nextRow][nextColon].add(animal);
                                        organismsList.remove(animalMove);
                                        //System.out.println("Переместился--------------------------->");
                                        if (animalMove != 0) {
                                            animalMove = animalMove - 1;
                                        }
                                    }
                                }

                            }

                        }
                    }
                }
            }
        }


    }

    private int getAmountAnimalsInListOrganisms(Organisms organismsFirst, List<Organisms> listOrganisms) {
        int amountAnimal = 0;
        for (Organisms organism : listOrganisms) {
            if (organism.getClass().getSimpleName().equals(organismsFirst.getClass().getSimpleName())) {
                amountAnimal++;
            }
        }
        return amountAnimal;
    }
}





