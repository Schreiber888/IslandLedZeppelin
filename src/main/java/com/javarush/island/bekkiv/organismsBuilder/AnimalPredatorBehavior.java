package com.javarush.island.bekkiv.organismsBuilder;

import com.javarush.island.bekkiv.organisms.Organisms;

import java.util.List;

public interface AnimalPredatorBehavior {
    void eat(AnimalsPredators animalsPredators, AnimalsHerbivores animalsHerbivores, List<AnimalsHerbivores> list);
    void reproduce(AnimalsPredators animalsPredators, List<Organisms> listOrganisms);
    int[][] move(int xCell, int yCell);

    Organisms build();
}
