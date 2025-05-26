package com.javarush.island.bekkiv.game;

import com.javarush.island.bekkiv.ParamConstInstanceOrganisms;
import com.javarush.island.bekkiv.RandomFood;
import com.javarush.island.bekkiv.animals.Organisms;
import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.herbivoresAnimals.Herbivores;
import com.javarush.island.bekkiv.plants.Plants;
import com.javarush.island.bekkiv.predatoryAnimals.Predators;

import java.util.List;

public class Game implements Runnable{

    @Override
    public void run() {
        ParamConstInstanceOrganisms paramConstInstanceOrganisms = new ParamConstInstanceOrganisms();
        boolean n = true;
        while (n) {
            for (int i = 0; i < Area.arrayArea.length; i++) {
                for (int j = 0; j < Area.arrayArea[i].length; j++) {
                    List<Organisms> tempListOrganisms = Area.arrayArea[i][j];
                    for (int k = 0; k < tempListOrganisms.size(); k++) {
                        Organisms organismsFirst = tempListOrganisms.get(k);
                        for (int m = 0; m < tempListOrganisms.size(); m++) {
                            Organisms organismsSecond = tempListOrganisms.get(m);

                            if (organismsFirst instanceof Predators) {
                                if (((Predators) organismsFirst).getWeightKg() <= paramConstInstanceOrganisms.getWeight(organismsFirst)) {
                                    if (organismsSecond instanceof Herbivores) {
                                        if (RandomFood.getProbabilityFood(organismsFirst, organismsSecond) <= RandomFood.getValueTableProbability(organismsFirst, organismsSecond)) {
                                            tempListOrganisms.remove(m);
                                            System.out.println("Волк выгнал кабана из игры");
                                            m = tempListOrganisms.size() - 1;
                                        }
                                    }
                                }
                            }

                            if (organismsFirst instanceof Herbivores) {
                                if (organismsSecond instanceof Plants) {
                                    System.out.println("Кабан выгнал растение из игры");
                                    tempListOrganisms.remove(m);
                                    m = tempListOrganisms.size() - 1;
                                }
                            }

                        }
                    }
                }
            }
            System.out.println(Area.arrayArea[0][0].size());
            System.out.println(Area.arrayArea[0][1].size());
            System.out.println(Area.arrayArea[1][0].size());
            System.out.println(Area.arrayArea[1][1].size());
            n = false;
            //System.out.println(FactoryOrganisms.organisms);
        }
    }
}
