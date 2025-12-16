package com.javarush.island.bekkiv.organismsBuilder;

import com.javarush.island.bekkiv.animals.Organisms;

import java.util.List;

public interface AnimalPredatorBehavior {
    void eat(Organisms organismsFirst, Organisms organismsSecond, List<Organisms> list);
    void reproduce(Organisms organisms, List<Organisms> listOrganisms);
    int[][] move(int xCell, int yCell);

    Organisms build();
}
