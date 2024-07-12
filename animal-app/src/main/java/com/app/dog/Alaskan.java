package com.app.dog;

public class Alaskan extends Dog {
    public Alaskan(String name, String age) {
        super(name, age);
    }
    
    @Override
    public void animalSound() {
        System.out.println("Alaskan " + _name + " has a special bark!");
    }
}
