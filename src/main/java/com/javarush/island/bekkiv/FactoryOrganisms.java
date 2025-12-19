package com.javarush.island.bekkiv;



import com.javarush.island.bekkiv.organisms.animals.Organisms;
import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Boar;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.ParamBoar;
import com.javarush.island.bekkiv.organisms.plants.ParamPlants;
import com.javarush.island.bekkiv.organisms.plants.Plants;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.ParamWolf;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Wolf;

import java.util.*;

public class FactoryOrganisms implements Runnable {
    private List<Organisms> organisms = new ArrayList<>();
    public Map<String, Organisms> organismsMap = new HashMap<>();
    Wolf wolf = new Wolf(ParamWolf.WEIGHT, ParamWolf.AMOUNT_IN_CELL, ParamWolf.AMOUNT_EAT, ParamWolf.SPEED);
    Boar boar = new Boar(ParamBoar.WEIGHT, ParamBoar.AMOUNT_IN_CELL, ParamBoar.AMOUNT_EAT, ParamBoar.SPEED);
    Plants plants = new Plants(ParamPlants.WEIGHT, ParamPlants.AMOUNT_IN_CELL);


    public ArrayList<Organisms> getListOrganisms(){
        return new ArrayList<>(organisms);
    }

    @Override
    public void run() {
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                Area.arrayArea[i][j].add(i, plants.clone());
            }
        }
        //System.out.println(Arrays.deepToString(Area.arrayArea));
    }

    public void makeAnimals (){

        //System.out.println(organisms);
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                List<Organisms> listOrganisms = getListOrganisms();
                for (int m = 0; m < ParamWolf.AMOUNT_IN_CELL; m++) {
                    listOrganisms.add(m, wolf.clone());
                }
                for (int k = 0; k < ParamBoar.AMOUNT_IN_CELL; k++) {
                    listOrganisms.add(k, boar.clone());
                }
                Area.arrayArea[i][j] = listOrganisms;
            }
        }
        System.out.println(Arrays.deepToString(Area.arrayArea));
    }
}
