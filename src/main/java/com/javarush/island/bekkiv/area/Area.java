package com.javarush.island.bekkiv.area;

import com.javarush.island.bekkiv.FactoryOrganisms;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.plants.ParamPlants;
import com.javarush.island.bekkiv.organisms.plants.Plants;

import java.util.List;

public class Area {

    public static List<Organisms>[][] arrayArea = new List[ParamArea.ROWS_AREA][ParamArea.COLONS_AREA];
    Plants plants = new Plants(ParamPlants.WEIGHT, ParamPlants.AMOUNT_IN_CELL);
    FactoryOrganisms factoryOrganisms = new FactoryOrganisms();

    public void go() {


        //System.out.println(Arrays.deepToString(Area.arrayArea));
    }
}
