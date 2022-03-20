//Author: Alexander Sutter
//Date: March 20, 2022
//Last Modified: March 20, 2022

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // create file
        try {
            File file = new File("data.txt");
            if (file.createNewFile()) {
                System.out.println("File has been created");
            } // end if statement
            else {
                System.out.println("File already exists");
            } // end else statement
        } // end try
        catch (IOException error) {
            System.out.println("An error has occured");
        } // end catch

        // write data to file (overwriting file)
        try {
            FileWriter addData = new FileWriter("data.txt");
            addData.write("Hello World! \n");
            addData.close();
            System.out.println("Successfully written to file!");
        } //end try
        catch (IOException error) {
            System.out.println("An error has occured!");
        } // end catch

        // read file and print to command line
        try {
            File file = new File("data.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            } // end while loop
            reader.close();
        } // end try
        catch (FileNotFoundException error) {
            System.out.println("An error has occured!");
        } // end catch

        // write to file (append to file)
        // read file and save to string
        String existing = "";
        try {
            File file = new File("data.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                existing += data + "\n";
            } // end while loop
            reader.close();
        } // end try
        catch (FileNotFoundException error) {
            System.out.println("An error has occured!");
        } // end catch

        // write file writing existing data and appending data
        String appendingData = "Hi There";
        try {
            FileWriter addData = new FileWriter("data.txt");
            addData.write(existing);
            addData.write(appendingData);
            addData.close();
            System.out.println("Successfully written to file!");
        }//end try
        catch (IOException error) {
            System.out.println("An error has occured!");
        } // end catch
    }// end main method

}// end class Main