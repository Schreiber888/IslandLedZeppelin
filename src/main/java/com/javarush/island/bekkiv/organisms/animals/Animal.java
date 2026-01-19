package com.javarush.island.bekkiv.organisms.animals;
import com.javarush.island.bekkiv.FactoryOrganisms;
import com.javarush.island.bekkiv.Runner;
import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.organisms.animals.capabilities.ReproducibleAnimals;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Predators;
import java.util.List;

public abstract class Animal extends Organisms implements ReproducibleAnimals {
    public float weightKg; //
    public int amountAnimalCell;
    public float amountEat;
    public int speed;

    public Animal(float weightKg, int amountAnimalCell, float amountEat, int speed) {
        this.weightKg = weightKg;
        this.amountAnimalCell = amountAnimalCell;
        this.amountEat = amountEat;
        this.speed = speed;
    }

    @Override
    public void reproduce(Animal organismsFirst, List<Organisms> listOrganisms) {
        //System.out.println("Размер до клона " + listOrganisms.size());
        int amountAnimalsInListOrganisms = getAmountAnimalsInListOrganisms(organismsFirst, listOrganisms);
        if (amountAnimalsInListOrganisms < FactoryOrganisms.getParameterArgumentsAmountCell(organismsFirst)) {
            listOrganisms.add(organismsFirst.clone());
            //System.out.println("кто-то размножился " + organismsFirst.getClass().getName());
        }
        //System.out.println("Размер после клона " + listOrganisms.size());
    }

    private int getAmountAnimalsInListOrganisms(Animal organismsFirst, List<Organisms> listOrganisms) {
        int amountAnimal = 0;
        for (Organisms organism : listOrganisms) {
            if (organism.getClass().getSimpleName().equals(organismsFirst.getClass().getSimpleName())) {
                amountAnimal++;
            }
        }
        return amountAnimal;
    }

    public static void gameOver() {
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                List<Organisms> organismsList = Area.arrayArea[i][j];
                int amountPredatorsGameOver = 0;
                for (Organisms organism : organismsList) {
                    if (organism instanceof Predators) {
                        amountPredatorsGameOver++;
                    } else if (amountPredatorsGameOver == 0) {
                        Runner.executorService.shutdown();
                        System.out.println("Конец игры. Хищников нету на одной из карт!");
                        return;
                    }
                }
            }
        }
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
