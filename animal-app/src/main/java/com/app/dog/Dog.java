package com.app.dog;
import com.app.Animal;

public class Dog implements Animal {
    protected String _name;
    protected int _age;

    public Dog(String name, String age) {
        this._name = name;

        try {
            this._age = Integer.parseInt(age);
        } catch (Exception err) {
            System.out.println("Age have the format number");
        }
    }
    
    public void animalSound() {
        System.out.println("Dog " + this._name + " says: bark" );
    }

    public String toString() {
        return "Name of dog is " + this._name + " and age is " + this._age;
    }
}
