//Author: Alexander Sutter
//Date: March 20, 2022
//Last Modified: March 20, 2022

//imports
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String fileName = "defaultFile.txt";
        
        createFile(fileName);
        
        write(fileName, "Hello World!", 'w');   // overwrite file
        
        System.out.println(read(fileName));
        
        write(fileName, "Hello World 2!", 'a'); // append to file

        System.out.println(read(fileName));

        // deleteFile(fileName);
    }// end main method

    public static File createFile(String fileName) {
        File file = new File(fileName);
        
        // create file
        try {
            // File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File has been created");
            } // end if statement
            else {
                System.out.println("File already exists");
            } // end else statement
        } // end try
        catch (IOException error) {
            System.out.println("An error has occured creating or finding file");
        } // end catch

        return file;
    }//end createFile(fileName)

    public static String read(String fileName) {
        // read file and put in String to command line
        String data = "";

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                data += reader.nextLine() + "\n";
            } // end while loop
            reader.close();
        } // end try
        catch (FileNotFoundException error) {
            System.out.println("An error has occured reading data!");
        } // end catch

        return data;
    }//end read(fileName)

    public static void write(String fileName, String data, char type) {
        // write to file (append to file)
        // read file and save to string
        String existing = "";
        
        if(type == 'a') { //if write type is append=>'a' else overwrite=>'w'
            existing = read(fileName);
        }//end if statement

        // write file writing existing data and appending data
        try {
            FileWriter addData = new FileWriter(fileName);
            addData.write(existing);
            addData.write(data);
            addData.close();
            System.out.println("Successfully written to file!");
        }//end try
        catch (IOException error) {
            System.out.println("An error has occured writing to file!");
        } // end catch
    }//end write(fileName, data, type)

    public static void deleteFile(String fileName) {
        File file = new File(fileName);

        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        }//end if statement
        
        else {
            System.out.println("Failed to delete the file.");
        }//end else statement
    }//end deleteFile(fileName)

}// end class Main