package example.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Delete {

    private static Scanner x;

    public static void main(String[] args) {

        String filepath="Zoo.csv";
        String removeTerm="Fish";

        removeRecord(filepath,removeTerm);
    }

    public static void removeRecord( String filepath,String removeTerm){

        String tempFile="temp.csv";
        File oldFile=new File(filepath);
        File newFile=new File(tempFile);
        String animal="";
        String name="";

        try{
            FileWriter fw=new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()){
                animal=x.next();
                name=x.next();
                if (!animal.equals(removeTerm)){
                    pw.println(animal+","+name);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump=new File(filepath);
            newFile.renameTo(dump);
            System.out.println("Record was deleted");
        }
        catch(Exception e){
            System.out.println("There was an error");
        }
    }
}
