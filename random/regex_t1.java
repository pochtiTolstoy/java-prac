import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex_t1 {
  public static void main(String[] args) {
    final String regex = "^(-|\\+)?\\d+((,\\d+)*)?(.\\d+e?\\d*)?$";
    final String string = "-123,123,123,2,50.9e10\n"
 + "+123\n"
 + "3.14529\n"
 + "-255.34\n"
 + "128\n"
 + "1.9e10\n"
 + "123,340.00\n"
 + "720p";
      
    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    final Matcher matcher = pattern.matcher(string);
    
    while (matcher.find()) {
      System.out.println("Full match: " + matcher.group(0));
      
      for (int i = 1; i <= matcher.groupCount(); i++) {
          System.out.println("Group " + i + ": " + matcher.group(i));
      }
      System.out.println();
    }
  }
}
