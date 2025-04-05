package org.example;
import java.util.Objects;

public class LinkedList<E> implements Collection<E> {
  private Node<E> head;
  private int size;

  public LinkedList() {
    head = null;
    size = 0;
  }

  @Override
  public void add(E data) {
    Node<E> newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
    } else {
      Node<E> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
    ++size;
  }

  @Override
  public void add(int index, E data) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    Node<E> newNode = new Node<>(data);
    if (index == 0) {
      newNode.next = head;
      head = newNode;
    } else {
      Node<E> current = head;
      for (int i = 0; i < index - 1; i++) {
        current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
    }
    ++size;
  }

  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    E removedData;
    if (index == 0) {
      removedData = head.data;
      head = head.next;
    } else {
      Node<E> current = head;
      for (int i = 0; i < index - 1; i++) {
        current = current.next;
      }
      removedData = current.next.data;
      current.next = current.next.next;
    }
    --size;
    return removedData;
  }

  @Override
  public E remove() {
    return remove(size - 1);
  }

  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.data;
  }

  public E get() {
    return get(size - 1);
  }

  @Override
  public boolean isEmpty() {
      return size == 0;
  }

  @Override
  public int size() {
      return size;
  }

  public int indexOf(Object o) {
    if (o == null) {
      throw new NullPointerException();
    }
    Node<E> current = head;
    int index = 0;
    int res = -1;
    while (current != null) {
      if (Objects.equals(o, current.data)) {
        return index;
      }
      current = current.next;
      ++index;
    }
    return res;
  }
}
