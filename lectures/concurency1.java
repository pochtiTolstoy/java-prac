class CalcSquare extends Thread {
  final int arg;
  int res;
  CalcSquare(int arg) {
    this.arg = arg;
  }
  @Override
  public void run() {
    res = arg * arg;
  }
}

public class concurency1 {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    CalcSquare t1 = new CalcSquare(2);
    CalcSquare t2 = new CalcSquare(3);
    try {
      t1.start();
      t2.start();
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      System.out.println("Got ya");
    }
    System.out.printf("%d, %d\n", t1.res, t2.res);
  }
}
