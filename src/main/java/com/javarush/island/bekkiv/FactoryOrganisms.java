package com.javarush.island.bekkiv;



import com.javarush.island.bekkiv.animals.Organisms;
import com.javarush.island.bekkiv.area.ParamArea;
import com.javarush.island.bekkiv.herbivoresAnimals.Boar;
import com.javarush.island.bekkiv.herbivoresAnimals.ParamBoar;
import com.javarush.island.bekkiv.plants.ParamPlants;
import com.javarush.island.bekkiv.plants.Plants;
import com.javarush.island.bekkiv.predatoryAnimals.ParamWolf;
import com.javarush.island.bekkiv.predatoryAnimals.Wolf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactoryOrganisms implements Runnable {
    public static List<Organisms> organisms = new ArrayList<>();
    public Map<String, Organisms> organismsMap = new HashMap<>();
    Wolf wolf = new Wolf(ParamWolf.WEIGHT, ParamWolf.AMOUNT_IN_CELL, ParamWolf.AMOUNT_EAT, ParamWolf.SPEED);
    Boar boar = new Boar(ParamBoar.WEIGHT, ParamBoar.AMOUNT_IN_CELL, ParamBoar.AMOUNT_EAT, ParamBoar.SPEED);
    Plants plants = new Plants(ParamPlants.WEIGHT, ParamPlants.AMOUNT_IN_CELL);



    @Override
    public void run() {
        for (int i = 0; i < ParamPlants.AMOUNT_IN_CELL / ParamArea.K_DIVISION; i++) {
            organisms.add(i, plants.clone());
        }
        //System.out.println(organisms.size());
    }

    public void makeAnimals (){
        for (int i = 0; i < ParamWolf.AMOUNT_IN_CELL; i++) {
            organisms.add(i, wolf.clone());
        }
        for (int i = 0; i < ParamBoar.AMOUNT_IN_CELL; i++) {
            organisms.add(i, boar.clone());
        }
        System.out.println(organisms);
    }
}
