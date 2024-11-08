import java.util.Scanner;

public class convert_binary {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter integral number: ");
    int input = 0;
    try {
      input = in.nextInt();
    } catch (Exception err) {
      System.out.println("Error: " + err);
      System.exit(-1);
    }
    int num = input;
    long binary_res = 0;
    boolean overflow_error = false;
    for (long shift = 1; num != 0 && !overflow_error; shift *= 10) {
      if (shift > 1e15) {
        overflow_error = true;
      } else {
        binary_res = binary_res + (num & 0x01) * shift;
        num >>= 1;
      }
    }
    if (!overflow_error) {
      System.out.println(input + " : " + binary_res);
    } else {
      System.out.println("Error. Hit overflow after 16 digits.");
    }
  }
}
