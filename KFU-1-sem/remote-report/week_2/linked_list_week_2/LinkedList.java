public class LinkedList<E> {
  private static class Node<E> {
    private E element;
    private Node<E> next;
    private Node(E element, Node<E> node) {
      this.element = element;
      this.next = node;
    }
    public E getElement() { return element; }
    public Node<E> getNext() { return next; }
    public void setNext(Node<E> node) { this.next = node; }
  }
  private Node<E> head = null;
  private Node<E> tail = null;
  private int size = 0;
  public LinkedList() {}
  public int size() { return size; }
  public boolean isEmpty() { return size == 0; }
  public E first() {
    if (isEmpty()) return null;
    return head.getElement();
  }
  public E last() {
    if (isEmpty()) return null;
    return tail.getElement();
  }
  public void addFirst(E element) {
    head = new Node<>(element, head);
    if (size == 0) tail = head;
    ++size;
  }
  public void addLast(E element) {
    Node<E> newNode = new Node<>(element, null);
    if (isEmpty()) 
      head = newNode;
    else 
      tail.setNext(newNode);
    tail = newNode;
    ++size;
  }
  public E removeFirst() {
    if (isEmpty()) return null;
    E element = head.getElement();
    head = head.getNext(); 
    --size;
    if (size == 0) tail = null;
    return element;
  }
  public void printList() {
    if (isEmpty()) return;
    Node<E> walkNode = head;
    while (walkNode != null) {
      System.out.print(walkNode.getElement() + " "); 
      walkNode = walkNode.getNext();
    }
    System.out.println();
  }
}
