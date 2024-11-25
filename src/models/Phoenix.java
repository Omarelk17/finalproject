package models;

public class Phoenix extends Creature {
    private static final long serialVersionUID = 1L;
    private int rebirths;

    // Constructor to initialize name, age, and rebirths
    public Phoenix(String name, int age, int rebirths) {
        super(name, age); // Calls the Creature constructor
        this.type = "Phoenix"; // Assuming the parent class has a 'type' field
        this.rebirths = rebirths;
    }

    // Getter for rebirths
    public int getRebirths() {
        return rebirths;
    }

    @Override
    public void executeAbility() {
        System.out.println("Phoenix " + getName() + " is rebirthing for the " + rebirths + " time!");
    }

    @Override
    public String toString() {
        return "Type: Phoenix, Name: " + getName() + ", Age: " + getAge() + ", Rebirths: " + rebirths;
    }

    @Override
    public void displayDetails() {
        System.out.println(this.toString());
    }
}
