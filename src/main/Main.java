package main;

import manager.CreatureManager;
import models.Dragon;
import models.Phoenix;
import models.Unicorn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CreatureManager manager = new CreatureManager();
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("\n--- Creature Management ---");
			    System.out.println("1. Add Creature");
			    System.out.println("2. Remove Creature");
			    System.out.println("3. Display Creatures");
			    System.out.println("4. Filter by Type");
			    System.out.println("5. Show Statistics");
			    System.out.println("6. Save Data");
			    System.out.println("7. Load Data");
			    System.out.println("8. Exit");
			    System.out.print("Choose an option: ");

			    int choice = scanner.nextInt();
			    scanner.nextLine(); // consume newline

			    System.out.println(); // Blank line for better readability

			    switch (choice) {
			        case 1:
			            System.out.print("Enter type (Dragon/Unicorn/Phoenix): ");
			            String type = scanner.nextLine().trim().toLowerCase();

			            System.out.print("Enter name: ");
			            String name = scanner.nextLine();

			            System.out.print("Enter age: ");
			            int age = scanner.nextInt();
			            scanner.nextLine(); // consume newline

			            if (type.equals("dragon")) {
			                System.out.print("Enter fire power: ");
			                int firePower = scanner.nextInt();
			                scanner.nextLine();
			                manager.addCreature(new Dragon(name, age, firePower));
			            } else if (type.equals("unicorn")) {
			                System.out.print("Enter horn color: ");
			                String hornColor = scanner.nextLine();
			                manager.addCreature(new Unicorn(name, age, hornColor));
			            } else if (type.equals("phoenix")) {
			                System.out.print("Enter number of rebirths: ");
			                int rebirths = scanner.nextInt();
			                scanner.nextLine();
			                manager.addCreature(new Phoenix(name, age, rebirths));
			            } else {
			                System.out.println("Invalid type. Please try again.");
			                break;
			            }

			            System.out.println("\nCreature added successfully.");
			            break;

			        case 2:
			            System.out.print("Enter the name of the creature to remove: ");
			            String removeName = scanner.nextLine();
			            if (manager.removeCreature(removeName)) {
			                System.out.println("\nCreature removed successfully.");
			            } else {
			                System.out.println("\nCreature not found.");
			            }
			            break;

			        case 3:
			            System.out.println("--- Displaying All Creatures ---");
			            manager.displayCreatures();
			            break;

			        case 4:
			            System.out.print("Enter type to filter by (Dragon/Unicorn/Phoenix): ");
			            String filterType = scanner.nextLine().trim().toLowerCase();
			            System.out.println("\n--- Filtered Creatures ---");
			            manager.filterCreaturesByType(filterType);
			            break;

			        case 5:
			            System.out.println("--- Creature Statistics ---");
			            manager.showStatistics();
			            break;

			        case 6:
			            System.out.print("Enter filename to save data: ");
			            String saveFile = scanner.nextLine();
			            manager.saveData(saveFile);
			            System.out.println("\nData saved successfully.");
			            break;

			        case 7:
			            System.out.print("Enter filename to load data: ");
			            String loadFile = scanner.nextLine();
			            manager.loadData(loadFile);
			            System.out.println("\nData loaded successfully.");
			            break;

			        case 8:
			            System.out.println("Exiting program...");
			            return;

			        default:
			            System.out.println("Invalid choice. Please try again.");
			    }
			}
		}
    }
}
