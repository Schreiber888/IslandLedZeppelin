package com.javarush.island.bekkiv.area;

import com.javarush.island.bekkiv.FactoryOrganisms;
import com.javarush.island.bekkiv.animals.Organisms;
import com.javarush.island.bekkiv.plants.ParamPlants;
import com.javarush.island.bekkiv.plants.Plants;

import java.util.Arrays;
import java.util.List;

public class Area {

    public static List<Organisms>[][] arrayArea = new List[ParamArea.ROWS_AREA][ParamArea.COLONS_AREA];
    FactoryOrganisms factoryOrganisms = new FactoryOrganisms();
    Plants plants = new Plants(ParamPlants.WEIGHT, ParamPlants.AMOUNT_IN_CELL);


    public void go() {
        for (int i = 0; i < ParamPlants.AMOUNT_IN_CELL; i++) {
            FactoryOrganisms.organisms.add(i, plants.clone());
        }
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                Area.arrayArea[i][j] = FactoryOrganisms.organisms;
                System.out.println(Arrays.deepToString(Area.arrayArea));
            }
        }
    }
}
