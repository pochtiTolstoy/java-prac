class Pair<T> {
  T value;
  Class<T> type;

  Pair(T value, Class<T> type) {
    this.value = value;
    this.type = type;
  }

  T newValue() {
    try {
      return type.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  void print() {
    System.out.println(value);
  }
}

public class yes_instance {
  public static void main(String[] args) {
    Pair<Integer> p = new Pair<>(10, Integer.class);
    p.print();
  }
}
