class Main {
  public static void main(String[] args) {
    System.out.println("LinkedList:");
    var list1 = new LinkedList<Integer>();
    for (int i = 0; i < 5; ++i)
      list1.addFirst(i);
    for (int i = 5; i < 10; ++i)
      list1.addLast(i);
    list1.printList();
  }
}
