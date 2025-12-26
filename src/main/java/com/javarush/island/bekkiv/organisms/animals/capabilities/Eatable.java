package com.javarush.island.bekkiv.organisms.animals.capabilities;

import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.khmelov.entity.organizm.Organism;

import java.util.List;

public interface Eatable {
    void eat(Organism organismsFirst, Organism organismsSecond, List<Organisms> tempListOrganisms);
}
