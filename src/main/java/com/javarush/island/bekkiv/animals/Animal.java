package com.javarush.island.bekkiv.animals;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Animal extends Organisms implements AnimalBehavior{
    protected float weightKg; //
    protected int amountAnimalCell;
    protected float amountEat;
    protected int speed;

    public Animal(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        this.weightKg = weightKg;
        this.amountAnimalCell = amountAnimalCell;
        this.amountEat = amountEat;
        this.speed = speed;
    }

    @Override
    public void eat(Organisms organismsFirst, Organisms organismsSecond, List<Organisms> list) {

    }

    @Override
    public void reproduce(Organisms organisms,  List<Organisms> listOrganisms) {
        Organisms clone = organisms.clone();
        listOrganisms.add(clone);
    }

    @Override
    public int[][] move(int xCell, int yCell) {
        int x = ThreadLocalRandom.current().nextInt(xCell);
        int y = ThreadLocalRandom.current().nextInt(yCell);
        return new int[x][y];
    }

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
