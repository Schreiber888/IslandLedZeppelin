package com.javarush.island.bekkiv;


import com.javarush.island.bekkiv.organisms.animals.Organisms;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Boar;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Wolf;

public class ParamConstInstanceOrganisms {
    public float getAmountFood(Organisms organisms){
        float result = 0;
        if (organisms instanceof Wolf){
            result = Wolf.AMOUNT_EAT;
        }
        if (organisms instanceof Boar){
            result = Boar.AMOUNT_EAT;
        }
        return result;
    }

    public float getWeight(Organisms organisms){
        float result = 0;
        if (organisms instanceof Wolf){
            result = Wolf.WEIGHT;
        }
        if (organisms instanceof Boar){
            result = Boar.WEIGHT;
        }
        return result;
    }

    public int getAmountInCell(Organisms organisms){
        int result = 0;
        if (organisms instanceof Wolf){
            result = Wolf.AMOUNT_IN_CELL;
        }
        if (organisms instanceof Boar){
            result = Boar.AMOUNT_IN_CELL;
        }
        return result;
    }

    public float getAmountOfFood(Class<? extends Organisms> aClass){
        float result = 0;
        if (aClass.getSimpleName().equals("Boar")){
            result = 8;
        }
        return result;
    }
}
