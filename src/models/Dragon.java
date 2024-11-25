package models;

public class Dragon extends Creature {
    private static final long serialVersionUID = 1L;
    private int firePower;

    public Dragon(String name, int age, int firePower) {
        super(name, age);
        this.type = "Dragon"; // Explicitly set the type
        this.firePower = firePower;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fire Power: " + firePower;
    }

    public int getFirePower() { 
        return firePower; 
    }

    public void setFirePower(int firePower) { 
        this.firePower = firePower; 
    }

    @Override
    public void executeAbility() {
        System.out.println(getName() + " breathes fire with power " + firePower + "!");
    }

    @Override
    public void displayDetails() {
        System.out.println(this); // Call toString() for formatted details
    }
}
