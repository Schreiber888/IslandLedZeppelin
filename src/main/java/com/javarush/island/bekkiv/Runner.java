package com.javarush.island.bekkiv;


import com.javarush.island.bekkiv.area.Constant;
import java.util.concurrent.*;

public class Runner {

    public static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {

        FactoryOrganisms factoryOrganisms = new FactoryOrganisms();
        try {
            factoryOrganisms.makeAnimals();
            System.out.println("Размер острова клеток: " + " " + FactoryOrganisms.mapAnimals.size());
            System.out.println("На моем ПК, если 2000 клеток, необходимо было подождать 50 секунд для окончания первого цикла игры и вывода количества животных на всей карте");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        executorService.scheduleWithFixedDelay(factoryOrganisms, 0, Constant.TIME_CYCLE_GROW_PLANTS, TimeUnit.MILLISECONDS);
    }
}