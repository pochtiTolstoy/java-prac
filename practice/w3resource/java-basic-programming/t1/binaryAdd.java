import java.util.Scanner;

public class binaryAdd {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter two binary numbers: ");
    long t1 = 0;
    long t2 = 0;
    try {
      t1 = in.nextLong();
      t2 = in.nextLong();
    } catch (Exception err) {
      System.out.println("Error: " + err);
      System.exit(-1);
    }
    long b1 = t1;
    long b2 = t2;
    long res = 0;
    long rem = 0;
    long temp = 0;
    long shift = 1;
    boolean overflow_error = false;

    while ((b1 != 0 || b2 != 0) && !overflow_error) {
      if (shift > 10e14) {
        overflow_error = true;
        continue;
      }
      temp = (b1 % 10) + (b2 % 10) + rem;
      res = (temp % 2) * shift + res;
      rem = temp / 2;
      shift *= 10;
      b1 /= 10;
      b2 /= 10;
    }

    if (shift > 10e14 && rem != 0) {
      overflow_error = true;
    } else {
      res = rem * shift + res;
    }

    if (!overflow_error) {
      System.out.println("Binary addition: " + t1 + " + " + t2 + " = " + res);
    } else {
      System.out.println("Error. Hit overflow error after 16 digits.");
    }
  }
}
