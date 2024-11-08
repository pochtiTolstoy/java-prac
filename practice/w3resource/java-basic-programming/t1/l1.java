import java.util.Scanner;

public class l1 {
  public static void main(String[] args) {
    // You need to create Scanner object, and take System.in
    Scanner input = new Scanner(System.in);
    System.out.print("Input your first name: ");
    // You should call next method on your Scanner object to read one word before space
    String fname = input.next();
    System.out.print("Input your last name: ");
    String lname = input.next();
    System.out.println("Hello, " + fname + " " + lname);
  }
}
