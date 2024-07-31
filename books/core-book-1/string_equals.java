public class string_equals {
  public static void main(String[] args) {
    String say_hi = "Hello!";
    String str = "Hello";
    if (say_hi.substring(0, 5).equals(str)) {
      System.out.println("Equals!");
    } else {
      System.out.println("Not equals.");
    }
  }
}
