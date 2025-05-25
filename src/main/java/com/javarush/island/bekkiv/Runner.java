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
        FactoryOrganisms factoryOrganisms = new FactoryOrganisms();
        factoryOrganisms.makeAnimals();
        //System.out.println(FactoryOrganisms.organisms);

        ParamConstInstanceOrganisms paramConstInstanceOrganisms = new ParamConstInstanceOrganisms();
        boolean n = true;
        while (n) {
            for (int i = 0; i < Area.arrayArea.length; i++) {
                for (int j = 0; j < Area.arrayArea[i].length; j++) {
                    for (int k = 0; k < Area.arrayArea[i][j].size(); k++) {
                        Organisms organismsFirst = Area.arrayArea[i][j].get(k);
                        for (int m = 0; m < Area.arrayArea[i][j].size(); m++) {
                            Organisms organismsSecond = Area.arrayArea[i][j].get(m);
                            if (organismsFirst instanceof Predators) {
                                if (((Predators) organismsFirst).getWeightKg() <= paramConstInstanceOrganisms.getWeight(organismsFirst)) {
                                    if (organismsSecond instanceof Herbivores) {
                                        if (RandomFood.getProbabilityFood(organismsFirst, organismsSecond) <= RandomFood.getValueTableProbability(organismsFirst, organismsSecond)) {
                                            Area.arrayArea[i][j].remove(m);
                                            System.out.println("Волк выгнал кабана из игры");
                                            System.out.println(Area.arrayArea.hashCode());
                                            m = 0;
                                        }
                                    }
                                }
                            }
                            if (organismsFirst instanceof Herbivores) {
                                if (organismsSecond instanceof Plants) {
                                    System.out.println("Кабан выгнал растение из игры");
                                    Area.arrayArea[i][j].remove(m);
                                    m = Area.arrayArea[i][j].size();
                                }
                            }
                        }
                    }
                }
            }

            n = false;
            //System.out.println(FactoryOrganisms.organisms);
        }
    }
}