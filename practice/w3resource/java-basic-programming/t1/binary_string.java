public class binary_string {
  private static String add_binary(String x, String y) {
    int n1 = Integer.parseInt(x, 2);
    System.out.println("int n1 = " + n1);
    int n2 = Integer.parseInt(y, 2);
    System.out.println("int n2 = " + n2);
    int sum = n1 + n2;
    System.out.println("int sum = " + sum);
    String res = Integer.toBinaryString(sum);
    return res;
  }
  public static void main(String[] args) {
    String x = "011011";
    String y = "1010111";
    System.out.println(add_binary(x, y));
  }
}
