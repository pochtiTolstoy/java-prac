import java.io.Console;

public class password_input {
  public static void main(String[] args) {
    Console cons = System.console();
    String username = cons.readLine("User name: ");
    char[] passwd = cons.readPassword("Password: ");
    for (int i = 0; i < passwd.length; ++i) {
      System.out.print(passwd[i] + "_");
    }
  }
}
