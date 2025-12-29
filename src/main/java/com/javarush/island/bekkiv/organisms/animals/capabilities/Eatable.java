package com.javarush.island.bekkiv.organisms.animals.capabilities;

import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Predators;
import com.javarush.island.khmelov.entity.organizm.Organism;

import java.util.List;

public interface Eatable {
    void eat(Animal organismsFirst, List<Organisms> listOrganisms);
}
