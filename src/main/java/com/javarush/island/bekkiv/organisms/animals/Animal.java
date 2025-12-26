package com.javarush.island.bekkiv.organisms.animals;

import com.javarush.island.bekkiv.ParamConstInstanceOrganisms;
import com.javarush.island.bekkiv.RandomFood;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.capabilities.AnimalBehavior;
import com.javarush.island.bekkiv.organisms.animals.capabilities.Eatable;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Herbivores;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Predators;
import com.javarush.island.khmelov.entity.organizm.Organism;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Animal extends Organisms implements Eatable {
    protected float weightKg; //
    protected int amountAnimalCell;
    protected float amountEat;
    protected int speed;

    /*public Animal(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        this.weightKg = weightKg;
        this.amountAnimalCell = amountAnimalCell;
        this.amountEat = amountEat;
        this.speed = speed;
    }*/

    public Animal() {}

    @Override
    public void eat(Organism organismsFirst, Organism organismsSecond, List<Organisms> tempListOrganisms) {

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
