package com.javarush.island.bekkiv.organisms.animals.capabilities;

import com.javarush.island.bekkiv.organisms.Organisms;

import java.util.List;

public interface AnimalBehavior {
    void eat(Organisms organismsFirst, Organisms organismsSecond, List<Organisms> list);
    void reproduce(Organisms organisms,  List<Organisms> listOrganisms);
    int[][] move(int xCell, int yCell);
}
