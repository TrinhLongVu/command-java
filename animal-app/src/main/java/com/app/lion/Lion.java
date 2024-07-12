package com.app.lion;
import com.app.Animal;

public class Lion implements Animal {
    private String _name;

    public Lion(String name) {
        this._name = name;
    }
    
    public void animalSound() {
        System.out.println("Lion " + this._name + " say: gru gru");
    }

    public String toString() {
        return "Name of lion is " + this._name;
    }
}