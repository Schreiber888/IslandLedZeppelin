package com.javarush.island.bekkiv.organisms.animals.capabilities;

import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.T;

import java.util.List;
@FunctionalInterface
public interface ReproducibleAnimals {
    void reproduce(T organismsFirst, List<Organisms> listOrganisms);
}
