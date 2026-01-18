package com.javarush.island.bekkiv.counter;

import com.javarush.island.bekkiv.FactoryOrganisms;
import com.javarush.island.bekkiv.organisms.Organisms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Counter implements Runnable {

    Map<String, Integer> mapOrganisms = new HashMap<>();

    @Override
    public void run() {

        count();

    }

    public void count() {

        for (int i = 0; i < FactoryOrganisms.TYPES.length; i++) {
            mapOrganisms.put(FactoryOrganisms.TYPES[i].getSimpleName(), 0);
        }

        for (int numberArea = 0; numberArea < FactoryOrganisms.mapAnimals.size(); numberArea++) {
            List<Organisms> listOrganisms = FactoryOrganisms.mapAnimals.get(numberArea);
            for (int organism = 0; organism < listOrganisms.size(); organism++) {
                int counter = 0;
                Organisms organismsFirst = listOrganisms.get(organism);
                String organismString = organismsFirst.getClass().getSimpleName();
                for (int organismsClass = 0; organismsClass < FactoryOrganisms.TYPES.length; organismsClass++) {
                    String simpleName = FactoryOrganisms.TYPES[organismsClass].getSimpleName();
                    if (organismString.equals(simpleName)) {
                        counter++;
                    }
                }

                Integer amountOrganisms =  mapOrganisms.get(organismString);
                if (amountOrganisms != null) {  // без этого условия возникало NullPointerException, т.к. amountOrganisms = null. Пока не знаю попчему
                    amountOrganisms = amountOrganisms + counter;
                    mapOrganisms.put(organismString, amountOrganisms);
                }
            }
        }

        for (int i = 0; i <FactoryOrganisms.TYPES.length; i++) {
            System.out.print("Количество " + FactoryOrganisms.TYPES[i].getSimpleName() + " " + mapOrganisms.get(FactoryOrganisms.TYPES[i].getSimpleName()) + " | ");
        }
        System.out.println();

    }
}


