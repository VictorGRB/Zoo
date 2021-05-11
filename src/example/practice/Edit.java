package example.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Edit {

    private static Scanner x;

    public static void main(String[] args) {

        String filepath="Zoo.csv";
        String editTerm="Fish";
        String newName="Maximus";

        editRecord(filepath,editTerm,newName);
    }
    public static void editRecord(String filepath,String editTerm,String newName){

        String tempFile="temp.csv";
        File oldFile=new File(filepath);
        File newFile=new File(tempFile);
        String animal="";
        String name="";

        try{
            FileWriter fw=new FileWriter(tempFile,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()){
                animal=x.next();
                name=x.next();
                if (animal.equals(editTerm)){
                    pw.println(editTerm+","+newName);
                }
                else {
                    pw.println(editTerm+","+name);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump=new File(filepath);
            newFile.renameTo(dump);
            System.out.println("Changes were saved");
        }
        catch(Exception e){
            System.out.println("There was an error");
        }
    }
}
