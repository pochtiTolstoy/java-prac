package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
  private ArrayList<Integer> list;
  private ArrayList<String> stringList;

  @BeforeEach
  void init() {
    list = new ArrayList<>();
    stringList = new ArrayList<>();
  }

  @Test
  void testInitState() {
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
  }

  @Test
  void testAddAndGet() {
    list.add(10);

    assertEquals(1, list.size());
    assertEquals(10, list.get(0));
  }

  @Test
  void testAddAtIndex() {
    list.add(0, 10);
    list.add(1, 30);
    list.add(1, 15);
    list.add(1, 1);
    list.add(4, 20);

    assertEquals(5, list.size());
    assertEquals(10, list.get(0));
    assertEquals(1, list.get(1));
    assertEquals(15, list.get(2));
    assertEquals(30, list.get(3));
    assertEquals(20, list.get(4));
  }

  @Test
  void testRemoveByIndex() {
    list.add(10);
    list.add(20);
    list.add(30);

    assertEquals(20, list.remove(1));
    assertEquals(2, list.size());
    assertEquals(10, list.get(0));
    assertEquals(30, list.get(1));
  }

  @Test
  void testRemoveLast() {
    list.add(10);
    list.add(20);

    assertEquals(20, list.remove());
    assertEquals(1, list.size());
    assertEquals(10, list.get());
  }

  @Test
  void testIndexOf() {
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(20);

    assertEquals(1, list.indexOf(20));
    assertEquals(-1, list.indexOf(40));
  }

  @Test
  void testResize() {
    for (int i = 0; i < 100; ++i) {
      list.add(i);
    }

    assertEquals(100, list.size());
    for (int i = 0; i < 100; ++i) {
      assertEquals(i, list.get(i));
    }
  }

  @Test
  void testEdgeCases() {
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove());
    assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 10));
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
  }

  @Test
  void testString() {
    stringList.add("1");
    stringList.add("2");
    stringList.add(1, "3");

    assertEquals(3, stringList.size());
    assertEquals("1", stringList.get(0));
    assertEquals("3", stringList.get(1));
    assertEquals("2", stringList.get(2));
  }


  @Test
  void testCapacityConstructor() {
    ArrayList<Integer> customList = new ArrayList<>(1);
    for (int i = 0; i < 10; ++i) {
      customList.add(i);
    }

    assertEquals(10, customList.size());
    assertEquals(9, customList.get(9));
  }

  @Test
  void testClearBehavior() {
    for (int i = 0; i < 10; ++i) {
      list.add(i);
    }
    while (!list.isEmpty()) {
      list.remove();
    }

    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
  }

  @Test
  void testConsecutiveOperations() {
    for (int i = 0; i < 50; ++i) {
      list.add(i);
    }
    for (int i = 49; i >= 0; --i) {
      assertEquals(i, list.remove());
    }
    assertTrue(list.isEmpty());
  }

  @Test
  void testNull() {
    stringList.add(null);
    stringList.add("null");

    assertEquals(2, stringList.size());
    assertNull(stringList.get(0));

    assertThrows(NullPointerException.class, () -> stringList.indexOf(null));
  }
}