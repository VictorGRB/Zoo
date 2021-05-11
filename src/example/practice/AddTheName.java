package example.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
//THIS METHOD IS FOR ADDING NAME SEPARATELY AFTER ANIMAL HAS BEEN PREVIOUSLY ADDED
public class AddTheName {

    public static void main(String[] args) {

        String animal = "Fish";

        Path path = Paths.get("Zoo.csv");
        try {
            List<String> allLines = Files.readAllLines(path);
            int counter = 0;
            for (String line : allLines) {
                if (line.equals(animal)) {
                    line += ",Nemo";
                    allLines.set(counter, line);
                }
                counter++;
            }
            Files.write(path, allLines);
            System.out.println("Your Record was saved");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Your Record was not saved");
        }

    }

}