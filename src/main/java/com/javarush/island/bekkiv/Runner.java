package com.javarush.island.bekkiv;


import com.javarush.island.bekkiv.area.Constant;
import com.javarush.island.bekkiv.game.Game;
import com.javarush.island.bekkiv.organisms.animals.Animal;

import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Runner {

    public static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        FactoryOrganisms factoryOrganisms = new FactoryOrganisms();
        try {
            factoryOrganisms.makeAnimals();
            System.out.println("размер острова" + " " + FactoryOrganisms.mapAnimals.size());
            System.out.println("На моем ПК необходимо было подождать 50 секунд для окончания одного первого цикла игры и вывода количества животных на всей карте");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        executorService.scheduleWithFixedDelay(factoryOrganisms, 0, Constant.TIME_CYCLE_GROW_PLANTS, TimeUnit.MILLISECONDS);
    }
}