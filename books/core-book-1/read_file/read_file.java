import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class read_file {
  public static void main(String[] args) {
    File file = new File("in1.txt");
    try {
      Scanner sc = new Scanner(file);
      while (sc.hasNextInt()) {
        int num = sc.nextInt();
        System.out.println("\"" + num + "\"");
      }
      sc.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
