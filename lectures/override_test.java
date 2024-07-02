class A<T> {
  void say_hi(T a) {
    System.out.println("Hello from A class");
  }
}

class B extends A<Integer> {
  @Override
  void say_hi(Integer a) {
    System.out.println("Hello from B class");
  }
  void say_goodbye() {
    System.out.println("Goodbye from B class");
  }
}

public class override_test {
  static public void main(String[] args) {
    System.out.println("Hello world!");    
    A a = new A();
    a.say_hi(5);
    B b = new B();
    b.say_hi(5);
    a = b;
    a.say_hi(5);
    if (a instanceof B b2) {
      b2.say_goodbye();
    }
  }
}
