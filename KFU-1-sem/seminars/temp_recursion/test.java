public class test {
  public static void main(String[] args) {
    String str = "(aaaaaaaaaa";
    if (is_valid(str, 0) != -1) {
      System.out.println("Valid string");
    } else {
      System.out.println("invalid string");
    }
  }
  private static int is_valid(String str, int idx) {
    if (idx >= str.length()) return -1;
    if (str.charAt(idx) == ')' || str.charAt(idx) == '}' || str.charAt(idx) == ']') {
      return idx;
    }
    int code = idx + 1;
    if (str.charAt(idx) == '(' || str.charAt(idx) == '{' || str.charAt(idx) == '[') {
      code = is_valid(str, idx + 1);
      if (code == -1) return -1;
      if ((str.charAt(code) == ')' && str.charAt(idx) == '(') 
          || (str.charAt(code) == '}' && str.charAt(idx) == '{') 
          || (str.charAt(code) == ']' && str.charAt(idx) == '[')) {
      } else if (str.charAt(code) == ')' || str.charAt(code) == '}' || str.charAt(code) == ']') {
        return -1;
      }
    }
    return is_valid(str, idx + code + 1);
  }
}
