package com.javarush.island.bekkiv.organisms.animals.capabilities;

import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.Animal;

import java.util.List;
@FunctionalInterface
public interface Eatable {
    void eat(Animal organismsFirst, List<Organisms> listOrganisms);
}
