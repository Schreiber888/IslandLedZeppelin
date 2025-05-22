package com.javarush.island.bekkiv.animals;

import com.javarush.island.bekkiv.herbivoresAnimals.Boar;
import com.javarush.island.bekkiv.herbivoresAnimals.ParamBoar;

import com.javarush.island.bekkiv.plants.ParamPlants;
import com.javarush.island.bekkiv.plants.Plants;
import com.javarush.island.bekkiv.predatoryAnimals.ParamWolf;
import com.javarush.island.bekkiv.predatoryAnimals.Wolf;

public class ObjectOrganisms {
    public static Wolf wolf = new Wolf(ParamWolf.WEIGHT, ParamWolf.AMOUNT_IN_CELL, ParamWolf.AMOUNT_EAT, ParamWolf.SPEED);
    public static Boar boar = new Boar(ParamBoar.WEIGHT, ParamBoar.AMOUNT_IN_CELL, ParamBoar.AMOUNT_EAT, ParamBoar.SPEED);
    public static Plants plants = new Plants(ParamPlants.WEIGHT, ParamPlants.AMOUNT_IN_CELL);
}
