package com.javarush.island.bekkiv.organismsBuilder;

import com.javarush.island.bekkiv.organisms.Organisms;

import java.util.List;

public interface AnimalHerbivoresBehavior {

    void eat(Organisms organismsFirst, Organisms organismsSecond, List<Organisms> list);
    void reproduce(Organisms organisms, List<Organisms> listOrganisms);
    int[][] move(int xCell, int yCell);

    Organisms build();

}
