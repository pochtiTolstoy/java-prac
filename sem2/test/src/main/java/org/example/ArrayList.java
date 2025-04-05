package org.example;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.util.Objects;

public class ArrayList<E> implements Collection<E> {
  public static final int CAPACITY = 16; // should be 16
  private E[] data;
  private int size = 0;
  public ArrayList() { this(CAPACITY); }

  @SuppressWarnings("unchecked")
  public ArrayList(int capacity) {
    data = (E[]) new Object[capacity];
  }

  @SuppressWarnings("unchecked")
  private void resize(int capacity) {
    E[] temp = (E[]) new Object[capacity];
    for (int k = 0; k < size; ++k) {
      temp[k] = data[k];
    }
    data = temp;
  }

  @Override
  public int size() { return size; }

  @Override
  public boolean isEmpty() { return size == 0; }

  @Override
  public E get(int i) throws IndexOutOfBoundsException {
    checkIndex(i, size);
    return data[i];
  }

  public E get() {
    return get(size - 1);
  }

  @Override
  public void add(int i, E e) throws IndexOutOfBoundsException {
    checkIndex(i, size + 1);
    if (size == data.length) {
      resize(2 * data.length);
    }
    for (int k = size - 1; k >= i; --k) {
      data[k + 1] = data[k];
    }
    data[i] = e;
    ++size;
  }

  @Override
  public void add(E e) {
    add(size, e);
  }

  @Override
  public E remove(int i) throws IndexOutOfBoundsException {
    checkIndex(i, size);
    E temp = data[i];
    for (int k = i; k < size - 1; ++k) {
      data[k] = data[k+1];
    }
    data[size-1] = null;
    --size;
    return temp;
  }

  @Override
  public E remove() {
    return remove(size - 1);
  }

  public int indexOf(Object o) throws NullPointerException {
    if (o == null) {
      throw new NullPointerException();
    }
    int res = -1;
    for (int i = 0; i < size && res == -1; i++) {
      if (Objects.equals(o, data[i])) {
        res = i;
      }
    }
    return res;
  }

  private void checkIndex(int i, int n) {
    if (i < 0 || i >= n) {
      throw new IndexOutOfBoundsException("Illegal index: " + i);
    }
  }
}
