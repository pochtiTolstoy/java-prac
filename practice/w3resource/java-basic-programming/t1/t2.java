import java.util.Scanner;

public class t2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);              
    System.out.print("Enter two integral numbers: ");
    int n1 = input.nextInt();
    int n2 = input.nextInt();

    int sum = n1 + n2;
    System.out.printf("%d + %d = %d\n", n1, n2, sum);
  }
}
