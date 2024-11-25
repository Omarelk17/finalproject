package models;

import java.io.Serializable;

public abstract class Creature implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String name;
    protected int age;
    protected String type; // Declare the 'type' field

    // Constructor
    public Creature(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract method for subclasses to implement
    public abstract void executeAbility();

    // Abstract method for displaying details
    public abstract void displayDetails();

    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for 'age'
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for 'type'
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Override toString to provide a meaningful output
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Type: " + type;
    }
}
