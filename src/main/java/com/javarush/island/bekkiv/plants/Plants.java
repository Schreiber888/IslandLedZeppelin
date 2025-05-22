package com.javarush.island.bekkiv.plants;

import com.javarush.island.bekkiv.animals.Organisms;

import java.util.concurrent.Callable;

public class Plants extends Organisms implements PlantsBehavior, Callable<Integer>, ParamPlants {
    public int amountGrass = 200;
    int millis = 20;
    float weight;
    int amountInCell;

    public Plants(float weight, int amountInCell) {
        this.weight = weight;
        this.amountInCell = amountInCell;
    }



    @Override
    public int grow() {
        return amountGrass;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(millis);
        return grow();
    }
}
