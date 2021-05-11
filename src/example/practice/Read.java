package example.practice;

import java.io.File;
import java.util.Scanner;

public class Read {

    private static Scanner x;

    public static void main(String[] args) {

        String filepath="Zoo.csv";
        String searchTerm="Fish";

        readRecord(searchTerm,filepath);
    }

    public static void readRecord(String searchTerm,String filepath){

        boolean found=false;
        String animal="";
        String name="";
        try{
            x=new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found){
                animal=x.next();
                name=x.next();
                if (animal.equals(searchTerm)){
                    found=true;
                }
            }
            if (found){

                System.out.println("The name of the "+animal+" is "+name);
            }
            else{
                System.out.println("No such animal was found");
            }
        }
        catch(Exception e){
            System.out.println("There was an error");
        }
    }
}
