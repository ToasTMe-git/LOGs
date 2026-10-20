import java.io.File;   
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;  

public class Log {
    public static void main(String[] agrs) {

      String toWrite = "";

      try {
      Files.createDirectories(Paths.get("./logs"));
      System.out.println("folder created successfully");

      }
      catch (IOException e) {
            System.err.println("Failed to create folder: " + e.getMessage());
        }

    int i = 0;
    while (true) {
    try {

      File myObj = new File("./logs/log" + i + ".txt"); 
      if (myObj.createNewFile()) { 
        FileWriter myWriter = new FileWriter(myObj);
        myWriter.write(toWrite);
        myWriter.close();
        System.out.println("File created: " + myObj.getName());
        System.exit(0);
      } else {
        System.out.println("File already exists.");
        i++;
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace(); // Print error details
            }
        }
    }
}