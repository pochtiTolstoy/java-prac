import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class change_file {
  public static void main(String[] args) throws IOException {
    FileWriter wr = new FileWriter("in1.txt");
    for (int i = 100; i < 10000; i += 100) {
      wr.write(Integer.valueOf(i).toString() + "\n");
    }
    wr.close();
  }
}
