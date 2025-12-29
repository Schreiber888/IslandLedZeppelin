package com.javarush.island.bekkiv;



import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Boar;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.ParamBoar;
import com.javarush.island.bekkiv.organisms.plants.ParamPlants;
import com.javarush.island.bekkiv.organisms.plants.Plants;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.ParamWolf;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Wolf;

import java.util.*;

public class FactoryOrganisms implements Runnable {
    RandomFood randomFood = new RandomFood();
    private List<Organisms> organisms = new ArrayList<>();
    public Map<String, Organisms> organismsMap = new HashMap<>();
    Wolf wolf = new Wolf();
    //Wolf wolf = new Wolf(ParamWolf.WEIGHT, ParamWolf.AMOUNT_IN_CELL, ParamWolf.AMOUNT_EAT, ParamWolf.SPEED);
    //Boar boar = new Boar(ParamBoar.WEIGHT, ParamBoar.AMOUNT_IN_CELL, ParamBoar.AMOUNT_EAT, ParamBoar.SPEED);
    Plants plants = new Plants(ParamPlants.WEIGHT, ParamPlants.AMOUNT_IN_CELL);
    Boar boar = new Boar();
    public  List<? super Animal> animals = new ArrayList<>();
    public Map<Integer, List<Organisms>> mapAnimals = new HashMap<>();


    public ArrayList<Organisms> getListOrganisms(){
        return new ArrayList<>(organisms);
    }

    @Override
    public void run() {

        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                for (int k = 0; k < ParamPlants.AMOUNT_IN_CELL; k++) {
                    Area.arrayArea[i][j].add(i, plants.clone());
                }
            }
        }
        System.out.println(Arrays.deepToString(Area.arrayArea));
    }

    public void makeAnimals () {

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

        int numberArea = 0;
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                    mapAnimals.put(numberArea, Area.arrayArea[i][j]);
                    numberArea ++;
            }
        }
    }

}


/*
public void makeAnimals (Organisms organism) {

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
                    }*/
