package org.example;

public interface Collection<E> {
  public void add(E data);
  public void add(int index, E data);
  public E remove(int index);
  public E remove();
  public E get(int index);
  public boolean isEmpty();
  public int size();
}
