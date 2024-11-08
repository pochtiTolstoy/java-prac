import java.io.*;

public class string_builder_binary {
  private static String add_binary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int sum = 0;
    int rem = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    for (; i >= 0 || j >= 0 || rem != 0; --i, --j) {
      sum = 0;
      if (i >= 0) sum += a.charAt(i) - '0';
      if (j >= 0) sum += b.charAt(j) - '0';
      sum += rem;
      rem = sum / 2;
      sum %= 2;
      result.append(sum);
    }
    return result.reverse().toString();
  }
  public static void main(String[] args) {
    String a =  "011011";
    String b = "1010111";
    //          1110010
    // String a =  "11";
    // String b = "111";
    //         1010
    System.out.println(add_binary(a, b));
  }
}
