package com.javarush.island.bekkiv;

import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.area.Constant;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.capabilities.Moveable;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Motion implements Runnable, Moveable {
    @Override
    public void run() {

        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                List<Organisms> organismsList = Area.arrayArea[i][j];
                for (int k = 0; k < organismsList.size(); k++) {
                    Organisms animal = organismsList.get(k);
                    move(animal, organismsList, k);
                }
            }
        }

    }

    @Override
    public void move(Organisms organismsFirst, List<Organisms> listOrganisms, int index) {
        FactoryOrganisms.getParameterArgumentsSpeed(organismsFirst);
        if (RandomFood.getProbability() > Constant.PROBABILITY_MOTION) {
            int i = ThreadLocalRandom.current().nextInt(FactoryOrganisms.getParameterArgumentsSpeed(organismsFirst));
            int j = ThreadLocalRandom.current().nextInt(FactoryOrganisms.getParameterArgumentsSpeed(organismsFirst));
            if (i + j <= FactoryOrganisms.getParameterArgumentsSpeed(organismsFirst)) {
                Area.arrayArea[i][i].add(organismsFirst);
                listOrganisms.remove(index);
                System.out.println("Переместился--------------------------->");
            }
        }
    }
}





