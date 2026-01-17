package com.javarush.island.bekkiv;

import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.capabilities.Moveable;

import java.util.List;

public class Motion implements Runnable, Moveable {
    @Override
    public void run() {

        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                List<Organisms> organismsList = Area.arrayArea[i][j];
                //Organisms organismsFirst = listOrganisms.get(j);

            }
        }


    }

    @Override
    public List<Organisms> move(Animal organismsFirst, List<Organisms> listOrganisms) {
        return List.of();
    }
}





