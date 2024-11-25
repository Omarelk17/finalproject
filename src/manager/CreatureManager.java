package manager;

import models.Creature;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreatureManager {
    private List<Creature> creatures;

    public CreatureManager() {
        this.creatures = new ArrayList<>();
    }

    // Add a creature to the list
    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    // Remove a creature by name
    public boolean removeCreature(String name) {
        return creatures.removeIf(creature -> creature.getName().equalsIgnoreCase(name));
    }

	 // Display all creatures
	    public void displayCreatures() {
	        if (creatures.isEmpty()) {
	            System.out.println("No creatures to display.");
	        } else {
	            System.out.println("--- Displaying All Creatures ---");
	            for (Creature creature : creatures) {
	                System.out.println(creature); 
	            }
	        }
	    }


    // Filter creatures by type (Dragon, Unicorn, Phoenix)
    public void filterCreaturesByType(String type) {
        boolean found = false;
        for (Creature creature : creatures) {
            if (creature.getClass().getSimpleName().equalsIgnoreCase(type)) {
                System.out.println(creature);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No creatures of type " + type + " found.");
        }
    }

    // Show statistics (total number of each type)
    public void showStatistics() {
        int dragonCount = 0, unicornCount = 0, phoenixCount = 0;

        for (Creature creature : creatures) {
            if (creature instanceof models.Dragon) {
                dragonCount++;
            } else if (creature instanceof models.Unicorn) {
                unicornCount++;
            } else if (creature instanceof models.Phoenix) {
                phoenixCount++;
            }
        }

        System.out.println("Creature Statistics:");
        System.out.println("Dragons: " + dragonCount);
        System.out.println("Unicorns: " + unicornCount);
        System.out.println("Phoenixes: " + phoenixCount);
    }

    // Save creatures to a file
    public void saveData(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(creatures);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    // Load creatures from a file
    public void loadData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            creatures = (List<Creature>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }
}
