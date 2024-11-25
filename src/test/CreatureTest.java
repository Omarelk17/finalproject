package test;

import org.junit.Test;

import models.Dragon;
import models.Phoenix;
import models.Unicorn;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CreatureTest {

    @Test
    public void testDragonCreation() {
        // Arrange
        Dragon dragon = new Dragon("Smaug", 300, 100);

        // Act & Assert
        assertEquals("Smaug", dragon.getName());
        assertEquals(300, dragon.getAge());
        assertEquals("Dragon", dragon.getType());
        assertEquals(100, dragon.getFirePower());
    }

    @Test
    public void testUnicornCreation() {
        // Arrange
        Unicorn unicorn = new Unicorn("Uni", 2, "Purple");

        // Act & Assert
        assertEquals("Uni", unicorn.getName());
        assertEquals(2, unicorn.getAge());
        assertEquals("Unicorn", unicorn.getType());
        assertEquals("Purple", unicorn.getHornColor());

        // Test the executeAbility() method and capture output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos)); // Redirect System.out
        unicorn.executeAbility(); // Should print a message like: "Uni heals with its Purple horn!"
        String output = baos.toString().trim(); // Capture the printed output
        assertTrue(output.contains("Uni heals with its Purple horn!"));
    }

    @Test
    public void testPhoenixCreation() {
        // Arrange
        Phoenix phoenix = new Phoenix("Phoeny", 5, 3);

        // Act & Assert
        assertEquals("Phoeny", phoenix.getName());
        assertEquals(5, phoenix.getAge());
        assertEquals("Phoenix", phoenix.getType());
        assertEquals(3, phoenix.getRebirths());

        // Test the executeAbility() method and capture output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos)); // Redirect System.out
        phoenix.executeAbility(); // Should print a message like: "Phoeny is rebirthing for the 3 time!"
        String output = baos.toString().trim(); // Capture the printed output
        assertTrue(output.contains("Phoeny is rebirthing for the 3 time!"));
    }

    @Test
    public void testToString() {
        // Arrange
        Dragon dragon = new Dragon("Smaug", 300, 100);
        Unicorn unicorn = new Unicorn("Uni", 2, "Purple");
        Phoenix phoenix = new Phoenix("Phoeny", 5, 3);

        // Act & Assert
        assertTrue(dragon.toString().contains("Type: Dragon"));
        assertTrue(unicorn.toString().contains("Type: Unicorn"));
        assertTrue(phoenix.toString().contains("Type: Phoenix"));
    }

    @Test
    public void testDisplayDetails() {
        // Arrange
        Dragon dragon = new Dragon("Smaug", 300, 100);
        Unicorn unicorn = new Unicorn("Uni", 2, "Purple");
        Phoenix phoenix = new Phoenix("Phoeny", 5, 3);

        // Capture the output of the displayDetails method
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos)); // Redirect System.out

        // Act & Assert
        dragon.displayDetails();
        String dragonOutput = baos.toString().trim();
        assertTrue(dragonOutput.contains("Dragon [Name: Smaug, Age: 300, Fire Power: 100]"));

        baos.reset(); // Clear the output buffer for the next test
        unicorn.displayDetails();
        String unicornOutput = baos.toString().trim();
        assertTrue(unicornOutput.contains("Unicorn [Name: Uni, Age: 2, Horn Color: Purple]"));

        baos.reset(); // Clear the output buffer for the next test
        phoenix.displayDetails();
        String phoenixOutput = baos.toString().trim();
        assertTrue(phoenixOutput.contains("Phoenix [Name: Phoeny, Age: 5, Rebirths: 3]"));
    }
}
