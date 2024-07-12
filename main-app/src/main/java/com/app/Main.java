package com.app;

// import from animal.jar
import com.app.dog.Dog;
import com.app.dog.Alaskan;
import com.app.lion.Lion;

import java.util.*;
import com.app.file.HandleFile;
import com.app.database.Mysql;

// handle thread
class DogMain implements Runnable {
    public void run() {
        try {
            // Dogs
            List<Animal> dogs = new ArrayList<>();
            // Read names from file
            HandleFile file = new HandleFile("./file/name.txt");
            List<String> names = file.readFile();

            for (String name : names) {
                dogs.add(new Dog(name, "3"));
            }

            for (Animal dog : dogs) {
                System.out.println(dog.toString());
                Thread.sleep(2000);
            }

            dogs.add(new Alaskan("dog alaskan", "10 years old"));
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class LionMain implements Runnable {
    public void run() {
        List<Animal> lions = new ArrayList<>();
        try {
            Mysql db = Mysql.getInstance();
            ArrayList<ArrayList<String>> namelions = db.getLion();
            
            for (ArrayList<String> namelion : namelions) {
                lions.add(new Lion(namelion.get(1)));
            }
            for (Animal lion : lions) {
                lion.animalSound();
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Thread lionThread = new Thread(new LionMain());
        // Thread dogThread = new Thread(new DogMain());

        // // finished lion and start dog

        // lionThread.start();
        // try {
        //     lionThread.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // dogThread.start();
        // try {
        //     dogThread.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        Dog dog = new Dog("Alaska", "2");
        System.out.println(dog.toString());
    }
}
