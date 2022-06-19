import java.io.*;
import java.util.*;

public class FileReplace {
    public void replace(String fileName, String toReplace, String replacement) throws IOException {
        // BufferedReader reader = new BufferedReader(new FileReader(fileName));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        // String line = ""; 
        
        // for(int i = 0; i < 10;){
        //     System.out.println("InLoop");
            
        //     line = reader.readLine();
        //     System.out.println(line);
        
        //     if(Objects.isNull(line)){
        //         break;
        //     } 
        //     // else 
        //     if (line.equals(toReplace)){
        //         writer.println();
        //     } else {
        //         writer.println(line);
        //     }
        // }

        // writer.println("SUDO");

        // writer.flush();
        writer.close();
        // reader.close();
    }

    public static void main(String args[]) {
        // FileReplace fr = new FileReplace();
        // try {
        //     fr.replace("mango.txt", "Java", " ");
        // } catch (IOException e) {
        //     System.out.println("IOException: Probably File not Found.");
        // }
    }
}