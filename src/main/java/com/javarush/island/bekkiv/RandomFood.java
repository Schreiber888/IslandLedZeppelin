package com.javarush.island.bekkiv;

import com.javarush.island.bekkiv.organisms.Organisms;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomFood {

    public static int[][] arrayProbabilities = {
            {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
            {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},
            {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
            {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100}
    };
    public static Map<Integer, String> map = new HashMap<>();

    static  {
        map.put(0, "Wolf");
        map.put(1, "Boa");
        map.put(2, "Fox");
        map.put(3, "Bear");
        map.put(4, "Eagle");
        map.put(5, "Horse");
        map.put(6, "Deer");
        map.put(7, "Rabbit");
        map.put(8, "Mouse");
        map.put(9, "Goat");
        map.put(10, "Sheep");
        map.put(11, "Boar");
        map.put(12, "Buffalo");
        map.put(13, "Duck");
        map.put(14, "Caterpillar");
        map.put(15, "Plants");
    }

    public static int getProbability() {
        final int MAX_PERCENT = 100;
        int probabilityFood;
        probabilityFood = ThreadLocalRandom.current().nextInt(MAX_PERCENT);
        return probabilityFood;
    }

    public static int getValueTableProbability(Organisms firstOrganism, Organisms secondOrganism) {
        int valueTableProbability;
        int row = 0;
        int colon = 0;
        for (int i = 0; i < map.size(); i++) {
            if (firstOrganism.getClass().getSimpleName().equals(map.get(i)))
                row = i;
            if (secondOrganism.getClass().getSimpleName().equals(map.get(i))) {
                colon = i;
            }
        }
        valueTableProbability = arrayProbabilities[row][colon];
        return valueTableProbability;
    }

    public int sizeMapAnimals() {
        return map.size();
    }
}
