package com.javarush.island.bekkiv;



import com.javarush.island.bekkiv.animals.Organisms;
import com.javarush.island.bekkiv.area.Area;
import com.javarush.island.bekkiv.game.Game;
import com.javarush.island.bekkiv.herbivoresAnimals.Herbivores;

import com.javarush.island.bekkiv.plants.Plants;
import com.javarush.island.bekkiv.predatoryAnimals.Predators;

import java.util.Arrays;
import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Runner {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        FactoryOrganisms factoryOrganisms = new FactoryOrganisms();
        factoryOrganisms.makeAnimals();
        //System.out.println(FactoryOrganisms.organisms);
        Thread thread = new Thread(factoryOrganisms);
        thread.start();
        thread.join();

        Game game = new Game();
        Thread threadGame = new Thread(game);
        threadGame.start();
        threadGame.join();


    }
}