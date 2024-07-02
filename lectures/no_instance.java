
class Pair<T> {
  T value;
  Pair(T value) {
    this.value = value;
  }
  T newValue() {
    return new T();
  }
  void print() {
    System.out.println(value);
  }
}

public class no_instance {
  static public void main(String[] args) {
    Pair<Integer> p = new Pair<>(10);
  }
}
