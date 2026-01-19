package com.javarush.island.bekkiv;


import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;
import com.javarush.island.bekkiv.area.Constant;
import com.javarush.island.bekkiv.counter.Counter;
import com.javarush.island.bekkiv.game.Game;
import com.javarush.island.bekkiv.organisms.Organisms;
import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.organisms.animals.Animal;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Boar;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Buffalo;
import com.javarush.island.bekkiv.organisms.animals.herbivoresAnimals.Herbivores;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Predators;
import com.javarush.island.bekkiv.organisms.plants.Plants;
import com.javarush.island.bekkiv.organisms.animals.predatoryAnimals.Wolf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class FactoryOrganisms implements Runnable {
    private List<Organisms> organisms = new ArrayList<>();
    public Map<String, Organisms> organismsMap = new HashMap<>();
    //Plants plants = new Plants(ParamPlants.WEIGHT, ParamPlants.AMOUNT_IN_CELL);
    public List<? super Animal> animals = new ArrayList<>();
    public static Map<Integer, List<Organisms>> mapAnimals = new HashMap<>();
    public static final Class<?>[] TYPES = {Wolf.class, Boar.class, Buffalo.class, Plants.class};


    public ArrayList<Organisms> getListOrganisms() {
        return new ArrayList<>(organisms);
    }

    @Override
    public void run() {

        try {
            growPlants();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.deepToString(Area.arrayArea));
        //---------тут продолжить--------//

        Game game = new Game();
        Thread threadGame = new Thread(game);
        threadGame.start();
        try {
            threadGame.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Motion motion = new Motion();
        Thread threadMotion = new Thread(motion);
        threadMotion.start();
        try {
            threadMotion.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Counter counter = new Counter();
        Thread threadCounter = new Thread(counter);
        threadCounter.start();
        try {
            threadCounter.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void makeAnimals() throws NoSuchFieldException, IllegalAccessException {
        final Organisms[] PROTOTYPES = createObject(TYPES);
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                List<Organisms> listOrganisms = getListOrganisms();
                for (Organisms prototype : PROTOTYPES) {
                    Field amountAnimalCellField = prototype.getClass().getField("amountAnimalCell");
                    int amountAnimalCell = (int) amountAnimalCellField.get(prototype);
                    for (int k = 0; k < amountAnimalCell; k++) {
                        listOrganisms.add(prototype.clone());
                    }
                }
                Area.arrayArea[i][j] = listOrganisms;
            }
        }

        int numberArea = 0;
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                mapAnimals.put(numberArea, Area.arrayArea[i][j]);
                numberArea++;
            }
        }
    }

    public static int getParameterArgumentsAmountCell(Organisms organismsFirst) {
        Class<? extends Organisms> organismsClass = organismsFirst.getClass();
        int ParameterArgumentsWeightKg = 0;
        if (organismsClass.isAnnotationPresent(OrganismsAnnotation.class)) {
            ParameterArgumentsWeightKg = organismsClass.getAnnotation(OrganismsAnnotation.class).amountAnimalCell();
        }
        return ParameterArgumentsWeightKg;
    }

    public static float getParameterArgumentsWeightKg(Organisms organismsFirst) {
        Class<? extends Organisms> organismsClass = organismsFirst.getClass();

        //Field nameField = organismsClass.getField("weightKg");
        float ParameterArgumentsWeightKg = 0;
        if (organismsClass.isAnnotationPresent(OrganismsAnnotation.class)) {
            ParameterArgumentsWeightKg = organismsClass.getAnnotation(OrganismsAnnotation.class).weightKg();
            //nameField.setAccessible(true); это если хотим редактированть наверно
            //Object weightKg = nameField.get(organismsFirst);
            //return ParameterArgumentsWeightKg;
        }
        return ParameterArgumentsWeightKg;
    }

    public static int getParameterArgumentsSpeed(Organisms organismsFirst) {
        Class<? extends Organisms> organismsClass = organismsFirst.getClass();
        int ParameterArgumentsSpeed = 0;
        if (organismsClass.isAnnotationPresent(OrganismsAnnotation.class)) {
            ParameterArgumentsSpeed = organismsClass.getAnnotation(OrganismsAnnotation.class).speed();
        }
        return ParameterArgumentsSpeed;
    }

    public static float getParameterArgumentsAmountEat(Organisms organismsFirst) {
        Class<? extends Organisms> organismsClass = organismsFirst.getClass();
        float ParameterArgumentsAmounteat = 0;
        if (organismsClass.isAnnotationPresent(OrganismsAnnotation.class)) {
            ParameterArgumentsAmounteat = organismsClass.getAnnotation(OrganismsAnnotation.class).amountEat();
        }
        return ParameterArgumentsAmounteat;
    }

    private Organisms[] createObject(Class<?>[] TYPES) {
        Organisms[] organisms = new Organisms[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {
            if (type.isAnnotationPresent(OrganismsAnnotation.class)) {
                OrganismsAnnotation annotation = type.getAnnotation(OrganismsAnnotation.class);
                float weightKg = annotation.weightKg();
                int amountCell = annotation.amountAnimalCell();
                float amountEat = annotation.amountEat();
                int speed = annotation.speed();
                organisms[index++] = generateObject(type, weightKg, amountCell, amountEat, speed);
            }
        }
        return organisms;
    }

    private Organisms generateObject(Class<?> type, float weightKg, int amountCell, float amountEat, int speed) {
        try {
            Constructor<?> constructor = type.getConstructor(float.class, int.class, float.class, int.class);
            return (Organisms) constructor.newInstance(weightKg, amountCell, amountEat, speed);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e); //доработать Exception
        }
    }

    public static void weightLossAnimals() throws NoSuchFieldException {
        for (int numberArea = 0; numberArea < mapAnimals.size(); numberArea++) {
            List<Organisms> organismsList = mapAnimals.get(numberArea);
            for (int i = 0; i < organismsList.size(); i++) {
                Organisms organisms = organismsList.get(i);
                if (organisms instanceof Predators) {
                    System.out.println("Вес " + organisms.getClass().getSimpleName() + " был: " + ((Predators) organisms).getWeightKg());
                    ((Predators) organisms).setWeightKg(((Predators) organisms).getWeightKg() * Constant.WEIGHT_LOSS);
                    if (((Predators) organisms).getWeightKg() < FactoryOrganisms.getParameterArgumentsWeightKg(organisms) * Constant.MIN_WEIGHT_REMOVAL_GAME) {
                        organismsList.remove(i);
                        System.out.println("Из за веса удален " + organisms.getClass().getSimpleName());
                        i = i - 1;
                    }
                    System.out.println("Вес " + organisms.getClass().getSimpleName() + " стал: " + ((Predators) organisms).getWeightKg());
                } else if (organisms instanceof Herbivores) {
                    System.out.println("Вес " + organisms.getClass().getSimpleName() + " был: " + ((Herbivores) organisms).getWeightKg());
                    ((Herbivores) organisms).setWeightKg(((Herbivores) organisms).getWeightKg() * Constant.WEIGHT_LOSS);
                    if (((Herbivores) organisms).getWeightKg() < ((Herbivores) organisms).getWeightKg() * Constant.MIN_WEIGHT_REMOVAL_GAME) {
                        organismsList.remove(i);
                        System.out.println("Из за веса удален " + organisms.getClass().getSimpleName());
                        i = i - 1;
                    }
                    System.out.println("Вес " + organisms.getClass().getSimpleName() + " стал: " + ((Herbivores) organisms).getWeightKg());
                } //else throw new IllegalArgumentException("При уменьшении веса животного возникло исключение - такого вида животного не существует");

            }
        }
    }

    public void growPlants() throws NoSuchFieldException, IllegalAccessException {
        final Organisms[] PROTOTYPES = createObject(TYPES);
        for (int i = 0; i < Area.arrayArea.length; i++) {
            for (int j = 0; j < Area.arrayArea[i].length; j++) {
                for (Organisms prototype : PROTOTYPES) {
                    if (prototype instanceof Plants) {
                        int parameterArgumentsAmountCellPlants = getParameterArgumentsAmountCell(prototype);
                        int amountPlantsInListOrganisms = getAmountPlantsInListOrganisms(prototype, Area.arrayArea[i][j]);
                        int amountPlantsToList = parameterArgumentsAmountCellPlants - amountPlantsInListOrganisms;
                        if (amountPlantsToList >= 0) {
                            for (int k = 0; k < amountPlantsToList; k++) {
                                Area.arrayArea[i][j].add(prototype.clone());
                            }
                        }
                    }
                }
            }
        }
    }

    private int getAmountPlantsInListOrganisms(Organisms organismsFirst, List<Organisms> listOrganisms){
        int amountPlants = 0;
        for (Organisms organism : listOrganisms) {
            if (organism.getClass().getSimpleName().equals(organismsFirst.getClass().getSimpleName())) {
                amountPlants++;
            }
        }
        return amountPlants;
    }

}

