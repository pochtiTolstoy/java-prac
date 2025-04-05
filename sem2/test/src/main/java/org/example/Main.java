package org.example;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    ArrayList<String> cars = new ArrayList<>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    for (int i = 0; i < cars.size(); ++i) {
      System.out.println(cars.get(i));
    }
    System.out.println();
    cars.remove();
    for (int i = 0; i < cars.size(); ++i) {
      System.out.println(cars.get(i));
    }
    System.out.println();

    cars.remove(0);
    for (int i = 0; i < cars.size(); ++i) {
      System.out.println(cars.get(i));
    }
    System.out.println();

    LinkedList<String> list = new LinkedList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    for (int i = 0; i < list.size(); ++i) {
      System.out.println(list.get(i));
    }
    System.out.println();

    list.add(1, "X");
    for (int i = 0; i < list.size(); ++i) {
      System.out.println(list.get(i));
    }
    System.out.println();

    list.remove(2);
    for (int i = 0; i < list.size(); ++i) {
      System.out.println(list.get(i));
    }
    System.out.println();

    System.out.println(list.get(1));
    System.out.println();

    for (int i = 0; i < list.size(); ++i) {
      System.out.println(list.get(i));
    }
    System.out.println();

    System.out.println("get() : " + list.get());
    for (int i = 0; i < list.size(); ++i) {
      System.out.println(list.get(i));
    }
    System.out.println();

    list.remove();
    System.out.println("get() : " + list.get());
    for (int i = 0; i < list.size(); ++i) {
      System.out.println(list.get(i));
    }
    System.out.println();

    list.remove();
    System.out.println("get() : " + list.get());
    for (int i = 0; i < list.size(); ++i) {
      System.out.println(list.get(i));
    }
    System.out.println();

    list.remove();
    if (list.isEmpty()) {
      System.out.println("empty");
    }
  }
}
