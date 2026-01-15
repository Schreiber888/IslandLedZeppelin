package com.javarush.island.bekkiv;



import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;
import com.javarush.island.bekkiv.area.Constant;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Boar;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Herbivores;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.ParamBoar;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Predators;
import com.javarush.island.bekkiv.organisms.plants.ParamPlants;
import com.javarush.island.bekkiv.organisms.plants.Plants;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.ParamWolf;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Wolf;
import com.javarush.island.khmelov.entity.organizm.animals.predators.Predator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class FactoryOrganisms implements Runnable {
    private List<Organisms> organisms = new ArrayList<>();
    public Map<String, Organisms> organismsMap = new HashMap<>();
    Plants plants = new Plants(ParamPlants.WEIGHT, ParamPlants.AMOUNT_IN_CELL);
    public  List<? super Animal> animals = new ArrayList<>();
    public static Map<Integer, List<Organisms>> mapAnimals = new HashMap<>();

    private static final Class<?>[] TYPES = {Wolf.class, Boar.class};


    public ArrayList<Organisms> getListOrganisms(){
        return new ArrayList<>(organisms);
    }

    @Override
    public void run() {

        growPlants();
        System.out.println(Arrays.deepToString(Area.arrayArea));
        //---------тут продолжить--------//
        //weightLossAnimals();
    }

    public void makeAnimals () throws NoSuchFieldException, IllegalAccessException {
        final Organisms[] PROTOTYPES = createObject(TYPES);

        //System.out.println(organisms);
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                List<Organisms> listOrganisms = getListOrganisms();
                for (Organisms prototype : PROTOTYPES) {    //надо клонировать столько раз, сколько животных положено
                    Field amountAnimalCellField = prototype.getClass().getField("amountAnimalCell");
                    int amountAnimalCell = (int) amountAnimalCellField.get(prototype);
                    for (int k = 0; k < amountAnimalCell; k++) {
                        listOrganisms.add(prototype.clone());
                    }
                }
                Area.arrayArea[i][j] = listOrganisms;
            }
        }
        //System.out.println(Arrays.deepToString(Area.arrayArea));

        int numberArea = 0;
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                    mapAnimals.put(numberArea, Area.arrayArea[i][j]);
                    numberArea ++;
            }
        }
    }

    public static float getParameterArgumentsWeightKg(Organisms organismsFirst){
        Class<? extends Organisms> organismsClass = organismsFirst.getClass();
        try {
            Field nameField = organismsClass.getField("weightKg");
            //nameField.setAccessible(true); это если хотим редактированть наверно
            Object weightKg = nameField.get(organismsFirst);
            return (float) weightKg;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);//доработать исключение
        }

    }

    private Organisms[] createObject(Class<?>[] TYPES) {
        Organisms[] organisms = new Organisms[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {
            if (type.isAnnotationPresent(OrganismsAnnotation.class)) {
                OrganismsAnnotation annotation = type.getAnnotation(OrganismsAnnotation.class);
                float weightKg = annotation.weightKg();
                int amountCell = annotation.amountCell();
                float amountEat = annotation.amountEat();
                int speed = annotation.speed();
                organisms[index++] = generateObject(type, weightKg, amountCell, amountEat, speed);
            }
        }
        return organisms;
    }

    private Organisms generateObject(Class<?> type,float weightKg, int amountCell, float amountEat, int speed) {
        try {
            Constructor<?> constructor = type.getConstructor(float.class, int.class, float.class, int.class);
            return (Organisms) constructor.newInstance(weightKg, amountCell, amountEat, speed);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e); //доработать Exception
        }
    }

    public static void weightLossAnimals(){
    for (int numberArea = 0; numberArea < mapAnimals.size(); numberArea++) {
        List<Organisms> organismsList = mapAnimals.get(numberArea);
        for (int i = 0; i < organismsList.size(); i++) {
            Organisms organisms = organismsList.get(i);
            if (organisms instanceof Predators) {
                System.out.println("Вес волка был: " + ((Predators) organisms).getWeightKg());
                ((Predators) organisms).setWeightKg(((Predators) organisms).getWeightKg() * Constant.WEIGHT_LOSS);
                System.out.println("Вес волка стал: " + ((Predators) organisms).getWeightKg());
            } else if (organisms instanceof Herbivores) {
                System.out.println("Вес кабана был: " + ((Herbivores) organisms).getWeightKg());
                ((Herbivores) organisms).setWeightKg(((Herbivores) organisms).getWeightKg() * Constant.WEIGHT_LOSS);
                System.out.println("Вес кабана стал: " + ((Herbivores) organisms).getWeightKg());
            } //else throw new IllegalArgumentException("При уменьшении веса животного возникло исключение - такого вида животного не существует");
        }
        //for (Organisms organisms : organismsList) {



        //}
    }
}

    private void growPlants(){
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                for (int k = 0; k < ParamPlants.AMOUNT_IN_CELL; k++) {
                    Area.arrayArea[i][j].add(i, plants.clone());
                }
            }
        }
    }

}

