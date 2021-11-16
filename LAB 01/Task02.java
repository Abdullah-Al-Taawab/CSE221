package lab01;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author 17101177
 */
public class Task02 {

    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File ("input.txt");
        try{
            Scanner sc = new Scanner(file);
            System.out.println("Printing file");
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch(IOException e){
            System.out.println("File not found");
        }
    }
}
