package com.javarush.island.bekkiv.organisms.animals.capabilities;

import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.Animal;

import java.util.List;

@FunctionalInterface
public interface Moveable {
    List<Organisms> move(Animal organismsFirst, List<Organisms> listOrganisms);
}
