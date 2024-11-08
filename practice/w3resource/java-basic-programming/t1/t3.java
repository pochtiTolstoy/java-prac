import java.util.Scanner;

public class t3 {
  public static void main(String[] args) {
    System.out.print("Enter binary expression: ");
    ErrorHandler e = new ErrorHandler();
    int n1 = 0;
    int n2 = 0;
    char op = ' ';
    int res = 0;
    try {
      Scanner in = new Scanner(System.in);
      n1 = in.nextInt();
      op = in.next().charAt(0);
      n2 = in.nextInt();
      res = calcExpression(n1, n2, op, e);
    } catch (Exception exp) {
      e.setIoError("Invalid input."); 
    }
    if (!e.isError()) {
      System.out.printf("%d %c %d = %d\n", n1, op, n2, res);
    } else {
      e.printMsg();
    }
  }

  public static int calcExpression(int n1, int n2, char op, ErrorHandler e) {
    int res = 0;
    if (e.isError()) return 0;
    switch (op) {
    case '+':
      res = n1 + n2;
      break;
    case '-':
      res = n1 - n2;
      break;
    case '*':
      res = n1 * n2;
      break;
    case '/':
      if (n2 == 0) e.setZeroDiv();
      else res = n1 / n2;
      break;
    case '%':
      if (n2 == 0) e.setZeroDiv();
      else res = n1 % n2;
      break;
    default:
      e.setWrongOp(op);
      break;
    }
    return res;
  }
}
