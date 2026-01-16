package com.javarush.island.bekkiv.organisms.animals;

import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.capabilities.ReproducibleAnimals;

import java.util.List;

public abstract class T extends Organisms implements ReproducibleAnimals {
    public float weightKg; //
    public int amountAnimalCell;
    public float amountEat;
    public int speed;
    //ParamConstInstanceOrganisms paramConstInstanceOrganisms = new ParamConstInstanceOrganisms();
    /*public Animal(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        this.weightKg = weightKg;
        this.amountAnimalCell = amountAnimalCell;
        this.amountEat = amountEat;
        this.speed = speed;
    }*/

    //public Animal() {}

    public T(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        this.weightKg = weightKg;
        this.amountAnimalCell = amountAnimalCell;
        this.amountEat = amountEat;
        this.speed = speed;
    }

    @Override
    public void reproduce(T organismsFirst, List<Organisms> listOrganisms) {

    }

/*@Override
    public void reproduce(Organisms organisms,  List<Organisms> listOrganisms) {
        Organisms clone = organisms.clone();
        listOrganisms.add(clone);
    }

    @Override
    public int[][] move(int xCell, int yCell) {
        int x = ThreadLocalRandom.current().nextInt(xCell);
        int y = ThreadLocalRandom.current().nextInt(yCell);
        return new int[x][y];
    }*/

    public float getWeightKg() {
        return weightKg;
    }

    public int getAmountAnimalCell() {
        return amountAnimalCell;
    }

    public float getAmountEat() {
        return amountEat;
    }

    public int getSpeed() {
        return speed;
    }

    public void setWeightKg(float weightKg) {
        this.weightKg = weightKg;
    }

    public void setAmountAnimalCell(int amountAnimalCell) {
        this.amountAnimalCell = amountAnimalCell;
    }

    public void setAmountEat(float amountEat) {
        this.amountEat = amountEat;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
