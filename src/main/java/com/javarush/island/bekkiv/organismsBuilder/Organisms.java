package com.javarush.island.bekkiv.organismsBuilder;

public class Organisms {
    private float weightKg; //
    private int amountAnimalCell;
    private float amountEat;
    private int speed;

    public Organisms(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        this.weightKg = weightKg;
        this.amountAnimalCell = amountAnimalCell;
        this.amountEat = amountEat;
        this.speed = speed;
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

   //сделать проверку правильности и целостности создания организма
}
