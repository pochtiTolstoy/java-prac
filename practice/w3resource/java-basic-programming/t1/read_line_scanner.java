import java.util.Scanner;
import java.io.IOException;

public class read_line_scanner {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    String line = reader.nextLine();
    System.out.println(line);
  }
}
