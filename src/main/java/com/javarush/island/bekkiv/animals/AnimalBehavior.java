package com.javarush.island.bekkiv.animals;

import java.util.List;

public interface AnimalBehavior {
    void eat(Organisms organismsFirst, Organisms organismsSecond, List<Organisms> list);
    int reproduce(int n);
    int[][] move(int xCell, int yCell);
}
