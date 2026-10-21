import java.io.File;   
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;  

public class Log {


      String toWrite = "";

      public Log(String write,String[] args) {
	      this.toWrite = write;
      

	    try {
        Files.createDirectories(Paths.get("./logs"));
        printif("folder created successfully", args);
      }
      catch (IOException e) {
        System.err.println("Failed to create folder: " + e.getMessage());
      }

      int i = 0;
      boolean isInLoop = true;
      while (isInLoop) {
        try {
          File myObj = new File("./logs/log" + i + ".txt"); 
          if (myObj.createNewFile()) { 
            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(toWrite);
            myWriter.close();
            printif("File created: " + myObj.getName(), args);
            isInLoop = false;
          } else {
            printif("File already exists.", args);
            i++;
          }
        } catch (IOException e) {
          printif("An error occurred.",args);
          e.printStackTrace();
        }
      }
    }

    public static void printif(String message, String[] args) {
      if (args != null && args.length > 0 && "--debug".equals(args[0])) {
        System.out.println(message);
      }
    }
  }