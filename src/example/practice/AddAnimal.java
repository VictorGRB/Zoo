package example.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

//THIS METHOD IS FOR ADDING ONLY ANIMAL FIRST
public class AddAnimal {
    public static void main(String[] args) {

        String animal = "Fish";
        String filepath="Zoo.csv";

        saveRecord(animal,filepath);
    }

    public static void saveRecord(String animal, String filepath){
        try{
            FileWriter fw =new FileWriter(filepath,true);
            BufferedWriter bw =new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);

            pw.println(animal);
            pw.flush();
            pw.close();

            System.out.println("Your Record was saved");
        }
        catch(Exception E){
            System.out.println("Your Record was not saved");
        }
    }
}
