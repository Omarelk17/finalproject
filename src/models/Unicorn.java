package models;

public class Unicorn extends Creature {
    private static final long serialVersionUID = 1L;
    private String hornColor;

    // Constructor to initialize name, age, and hornColor
    public Unicorn(String name, int age, String hornColor) {
        super(name, age);
        this.type = "Unicorn";  // Explicitly set the type to "Unicorn"
        this.hornColor = hornColor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Unicorn, Horn Color: " + hornColor;
    }

    public String getHornColor() {
        return hornColor;
    }

    public void setHornColor(String hornColor) {
        this.hornColor = hornColor;
    }

    @Override
    public void executeAbility() {
        System.out.println(getName() + " heals with its " + hornColor + " horn!");
    }

    @Override
    public void displayDetails() {
        System.out.println("Unicorn [Name: " + getName() + ", Age: " + getAge() + ", Horn Color: " + hornColor + "]");
    }
}
