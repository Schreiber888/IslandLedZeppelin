package com.javarush.island.bekkiv;

import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.area.Constant;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.capabilities.Moveable;
import com.javarush.island.bekkiv.organismsBuilder.Plants;

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
                    if (RandomFood.getProbability() > Constant.PROBABILITY_MOTION) {
                        if (animal instanceof Animal) {
                            int nextRow = ThreadLocalRandom.current().nextInt(Math.abs(FactoryOrganisms.getParameterArgumentsSpeed(animal)));
                            int nextColon = ThreadLocalRandom.current().nextInt(Math.abs(FactoryOrganisms.getParameterArgumentsSpeed(animal)));
                            if (nextRow + nextColon <= FactoryOrganisms.getParameterArgumentsSpeed(animal)) {
                                if (nextRow >= row) {
                                    nextRow = row;
                                }
                                if (nextColon >= colon) {
                                    nextColon = colon;
                                }
                                Area.arrayArea[nextRow][nextColon].add(animal);
                                organismsList.remove(animalMove);
                                if (animalMove != 0) {
                                    animalMove = animalMove - 1;
                                }
                                System.out.println("Переместился--------------------------->");
                            }
                        }

                    }
                }
            }
        }


    }
}





