package com.javarush.island.bekkiv;



import com.javarush.island.bekkiv.animals.Organisms;
import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.herbivoresAnimals.Herbivores;

import com.javarush.island.bekkiv.plants.Plants;
import com.javarush.island.bekkiv.predatoryAnimals.Predators;

import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Runner {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        Area area = new Area();
        area.go();
        //System.out.println(FactoryOrganisms.organisms);

        ParamConstInstanceOrganisms paramConstInstanceOrganisms = new ParamConstInstanceOrganisms();
        boolean n = true;
        while (n) {
            for (int i = 0; i < FactoryOrganisms.organisms.size(); i++) {
                Organisms organismsFirst = FactoryOrganisms.organisms.get(i);
                for (int j = 0; j < FactoryOrganisms.organisms.size(); j++) {
                    Organisms organismsSecond = FactoryOrganisms.organisms.get(j);
                    if (organismsFirst instanceof Predators) {
                        if (((Predators) organismsFirst).getWeightKg() <= paramConstInstanceOrganisms.getWeight(organismsFirst)) {
                            if (organismsSecond instanceof Herbivores) {
                                if (RandomFood.getProbabilityFood(organismsFirst, organismsSecond) <= RandomFood.getValueTableProbability(organismsFirst, organismsSecond)) {
                                    FactoryOrganisms.organisms.remove(j);
                                    System.out.println("Волк выгнал кабана из игры");
                                    j = 0;
                                }
                            }
                        }
                    }
                    if (organismsFirst instanceof Herbivores) {
                        if (organismsSecond instanceof Plants) {
                            System.out.println("Кабан выгнал растение из игры");
                            FactoryOrganisms.organisms.remove(j);
                            j = FactoryOrganisms.organisms.size();
                        }
                    }
                }
            }
            n = false;
            System.out.println(FactoryOrganisms.organisms);
        }
    }
}