package utilities;

import models.Creature;

import java.io.*;
import java.util.List;

public class FileHandler {

    public static void saveToFile(String filename, List<Creature> creatures) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(creatures);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Creature> loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Creature>) ois.readObject();
        }
    }
}
