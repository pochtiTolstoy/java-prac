package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
  private LinkedList<Integer> list;
  private LinkedList<String> stringList;

  @BeforeEach
  void init() {
    list = new LinkedList<>();
    stringList = new LinkedList<>();
  }

  @Test
  void testInitState() {
    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
  }

  @Test
  void testAddEnd() {
    list.add(10);
    list.add(20);

    assertEquals(2, list.size());
    assertEquals(10, list.get(0));
    assertEquals(20, list.get(1));
  }

  @Test
  void testAdd() {
    list.add(0, 1);
    list.add(1, 3);
    list.add(1, 2);
    list.add(3, 10);

    assertEquals(4, list.size());
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
    assertEquals(10, list.get(3));
  }

  @Test
  void testRemoveByIndex() {
    list.add(1);
    list.add(2);
    list.add(3);

    assertEquals(2, list.remove(1));
    assertEquals(2, list.size());
    assertEquals(1, list.get(0));
    assertEquals(3, list.get(1));
  }

  @Test
  void testAddAtInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 10));
    assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 10));
  }


  @Test
  void testRemoveFirstElement() {
    list.add(1);
    list.add(2);

    assertEquals(1, list.remove(0));
    assertEquals(1, list.size());
    assertEquals(2, list.get(0));
  }

  @Test
  void testRemoveLastElement() {
    list.add(1);
    list.add(2);

    assertEquals(2, list.remove());
    assertEquals(1, list.size());
    assertEquals(1, list.get(0));
  }

  @Test
  void testRemoveFromEmptyList() {
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove());
  }

  @Test
  void testGetMethods() {
    list.add(1);
    list.add(2);

    assertEquals(1, list.get(0));
    assertEquals(2, list.get());
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
  }

  @Test
  void testIndexOf() {
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(2);

    assertEquals(1, list.indexOf(2));
    assertEquals(-1, list.indexOf(4));
    assertEquals(0, list.indexOf(1));
  }

  @Test
  void testIndexOfNull() {
    stringList.add("hello");
    assertThrows(NullPointerException.class, () -> stringList.indexOf(null));
  }

  @Test
  void testMixedOperations() {
    assertTrue(list.isEmpty());

    list.add(10);
    list.add(0, 5);
    list.add(20);
    list.remove(1);
    list.add(1, 15);

    assertEquals(3, list.size());
    assertEquals(5, list.get(0));
    assertEquals(15, list.get(1));
    assertEquals(20, list.get(2));
  }

  @Test
  void testStringListOperations() {
    stringList.add("1");
    stringList.add("2");
    stringList.add(1, "3");

    assertEquals(3, stringList.size());
    assertEquals("1", stringList.get(0));
    assertEquals("3", stringList.get(1));
    assertEquals("2", stringList.get(2));
  }

  @Test
  void testSingleElementList() {
    list.add(1000);

    assertEquals(1, list.size());
    assertEquals(1000, list.remove());
    assertTrue(list.isEmpty());
  }

  @Test
  void testLargeNumberOfElements() {
    for (int i = 0; i < 1000; ++i) {
      list.add(i);
    }

    assertEquals(1000, list.size());
    for (int i = 0; i < 1000; ++i) {
      assertEquals(i, list.get(i));
    }
    for (int i = 999; i >= 0; --i) {
      assertEquals(i, list.remove());
    }
    assertTrue(list.isEmpty());
  }
}