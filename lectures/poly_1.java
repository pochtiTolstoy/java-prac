class A {
  void test() {
    System.out.println("I am test func from A class"); 
  }
}

class B extends A {
  void say_hi() {
    System.out.println("Hello from B class");
  }
}

public class poly_1 {
  static public void main(String[] args) {
    A a = new A(); // A -> A
    B b = new B(); // B -> B
    A obj = new B(); // A -> B
    //B obj2 = new A(); // B -> A. CE.
    a.test();
    //a.say_hi(); // class A a don't know anything about methods of class B
    b.test(); // B contains A, hence it can use A methods.
    b.say_hi(); // this is method from B

    obj.test(); // This is method from A
    //obj.say_hi(); // There is no dynamic poly.
    if (obj instanceof A) {
      System.out.println("A obj is instance of A");
    }
    if (obj instanceof B) {
      System.out.println("A obj (without overriding) is instance of B by downcast");
      B b2 = (B) obj;
      b2.say_hi();
    } else {
      System.out.println("A obj = new B() -> (without overriding) is not an instance of B by downcast");
    }
  }
}
