package example.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

//THIS METHOD IS FOR ADDING ANIMAL AND NAME AT THE SAME TIME
public class AddAnimalAndName {
    public static void main(String[] args) {

        String animal = "Fish";
        String name="Nemo";
        String filepath="Zoo.csv";

        saveRecord(animal,name,filepath);
    }

    public static void saveRecord(String animal, String name, String filepath){
        try{
            FileWriter fw =new FileWriter(filepath,true);
            BufferedWriter bw =new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);

            pw.println(animal+","+name);
            pw.flush();
            pw.close();

            System.out.println("Your Record was saved");
        }
        catch(Exception E){
            System.out.println("Your Record was not saved");
        }
    }
}
