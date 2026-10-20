import java.io.File;   
import java.io.IOException;

public class Log {
    public static void main(String[] agrs) {

    int i = 0;
    while (true) {
    try {

      File myObj = new File("log" + i + ".txt"); 
      if (myObj.createNewFile()) {          

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