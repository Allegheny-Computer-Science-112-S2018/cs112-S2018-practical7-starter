package practicalseven;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import practicalseven.list.DoublyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A JUnit test suite for the DoublyLinkedList.
 *
 * @author Gregory M. Kapfhammer
 */

public class TestDoublyLinkedList {

  /** The size of the DoublyLinkedList with multiple values. */
  private static final int SIZE = 10;

  @Test
  public void testConstructDoublyLinkedListNotNull() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    assertTrue(list != null);
  }

  @Test
  public void testConstructDoublyLinkedListCorrectInitialState() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    assertEquals(list.getSize(), 0);
    assertTrue(list.isEmpty());
    assertEquals(list.getFirst(), null);
    assertEquals(list.getLast(), null);
  }

  @Test
  public void testDoublyLinkedListAfterAddFirst() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addFirst(new String("Data"));
    assertEquals(list.getSize(), 1);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("Data"));
    assertEquals(list.getLast(), new String("Data"));
  }

  @Test
  public void testDoublyLinkedListAfterAddFirstAndRemoveFirst() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addFirst(new String("Data"));
    assertEquals(list.getSize(), 1);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("Data"));
    assertEquals(list.getLast(), new String("Data"));
    list.removeFirst();
    assertEquals(list.getSize(), 0);
    assertTrue(list.isEmpty());
    assertEquals(list.getFirst(), null);
    assertEquals(list.getLast(), null);
  }

  @Test
  public void testDoublyLinkedListAfterAddLast() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addLast(new String("Data"));
    assertEquals(list.getSize(), 1);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("Data"));
    assertEquals(list.getLast(), new String("Data"));
  }

  @Test
  public void testDoublyLinkedListAfterAddLastAndRemoveFirst() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addLast(new String("Data"));
    assertEquals(list.getSize(), 1);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("Data"));
    assertEquals(list.getLast(), new String("Data"));
    list.removeFirst();
    assertEquals(list.getSize(), 0);
    assertTrue(list.isEmpty());
    assertEquals(list.getFirst(), null);
    assertEquals(list.getLast(), null);
  }

  @Test
  public void testDoublyLinkedListAfterAddFirstAddLast() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addFirst(new String("First"));
    assertEquals(list.getSize(), 1);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("First"));
    assertEquals(list.getLast(), new String("First"));
    list.addLast(new String("Last"));
    assertEquals(list.getSize(), 2);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("First"));
    assertEquals(list.getLast(), new String("Last"));
  }

  @Test
  public void testDoublyLinkedListAfterAddLastAddFirst() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addLast(new String("Last"));
    assertEquals(list.getSize(), 1);
    assertTrue(!list.isEmpty());
    assertEquals(list.getLast(), new String("Last"));
    assertEquals(list.getFirst(), new String("Last"));
    list.addFirst(new String("First"));
    assertEquals(list.getSize(), 2);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("First"));
    assertEquals(list.getLast(), new String("Last"));
  }

  @Test
  public void testDoublyLinkedListAfterAddFirstAddFirst() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addFirst(new String("First"));
    assertEquals(list.getSize(), 1);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("First"));
    assertEquals(list.getLast(), new String("First"));
    list.addFirst(new String("New First"));
    assertEquals(list.getSize(), 2);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("New First"));
    assertEquals(list.getLast(), new String("First"));
  }

  @Test
  public void testDoublyLinkedListAfterAddLastAddLast() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addLast(new String("First Last"));
    assertEquals(list.getSize(), 1);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("First Last"));
    assertEquals(list.getLast(), new String("First Last"));
    list.addLast(new String("Last Last"));
    assertEquals(list.getSize(), 2);
    assertTrue(!list.isEmpty());
    assertEquals(list.getFirst(), new String("First Last"));
    assertEquals(list.getLast(), new String("Last Last"));
  }

  @Test
  public void testToStringDoesNotReturnNull() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addLast(new String("First Last"));
    list.addLast(new String("Last Last"));
    String textualRepresentation = list.toString();
    assertTrue(textualRepresentation != null);
    assertTrue(textualRepresentation.contains(","));
    assertTrue(textualRepresentation.contains("("));
    assertTrue(textualRepresentation.contains(")"));
  }

  @Test
  public void testHashCodesNotSameForDifferentLists() {
    DoublyLinkedList<String> listOne = new DoublyLinkedList<String>();
    listOne.addLast(new String("Element One"));
    listOne.addLast(new String("Element Two"));
    DoublyLinkedList<String> listTwo = new DoublyLinkedList<String>();
    listTwo.addLast(new String("Data One"));
    listTwo.addLast(new String("Data Two"));
    int hashCodeListOne = listOne.hashCode();
    int hashCodeListTwo = listTwo.hashCode();
    assertTrue(hashCodeListOne != hashCodeListTwo);
  }

  @Test
  public void testNotEqualForDifferentLists() {
    DoublyLinkedList<String> listOne = new DoublyLinkedList<String>();
    listOne.addLast(new String("Element One"));
    listOne.addLast(new String("Element Two"));
    DoublyLinkedList<String> listTwo = new DoublyLinkedList<String>();
    listTwo.addLast(new String("Data One"));
    listTwo.addLast(new String("Data Two"));
    assertTrue(!listOne.equals(listTwo));
    assertTrue(!listTwo.equals(listOne));
  }

  @Test
  public void testNotEqualForDifferentSizes() {
    DoublyLinkedList<String> listOne = new DoublyLinkedList<String>();
    listOne.addLast(new String("Element One"));
    listOne.addLast(new String("Element Two"));
    DoublyLinkedList<String> listTwo = new DoublyLinkedList<String>();
    listTwo.addLast(new String("Element One"));
    assertTrue(!listOne.equals(listTwo));
    assertTrue(!listTwo.equals(listOne));
  }

  @Test
  public void testEqualForSameLists() {
    DoublyLinkedList<String> listOne = new DoublyLinkedList<String>();
    listOne.addLast(new String("Element One"));
    listOne.addLast(new String("Element Two"));
    DoublyLinkedList<String> listTwo = new DoublyLinkedList<String>();
    listTwo.addLast(new String("Element One"));
    listTwo.addLast(new String("Element Two"));
    assertTrue(listOne.equals(listTwo));
    assertTrue(listTwo.equals(listOne));
  }

  @Test
  public void testNotEqualsForNullValue() {
    DoublyLinkedList<String> listOne = new DoublyLinkedList<String>();
    listOne.addLast(new String("Element One"));
    listOne.addLast(new String("Element Two"));
    assertTrue(!listOne.equals(null));
  }

  @Test
  public void testNotEqualsForDifferentDataType() {
    DoublyLinkedList<String> listOne = new DoublyLinkedList<String>();
    listOne.addLast(new String("Element One"));
    listOne.addLast(new String("Element Two"));
    assertTrue(!listOne.equals(new ArrayList()));
  }

  @Test
  public void testAddManyStringsToLinkedListWithAddFirst() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    for (int i = 0; i < SIZE; i++) {
      list.addFirst(Integer.toString(i));
    }
    assertTrue(!list.isEmpty());
    assertEquals(list.getSize(), SIZE);
  }

  @Test
  public void testAddManyStringsToLinkedListWithAddLast() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    for (int i = 0; i < SIZE; i++) {
      list.addFirst(Integer.toString(i));
    }
    assertTrue(!list.isEmpty());
    assertEquals(list.getSize(), SIZE);
  }

  @Test
  public void testAddManyStringsToLinkedListWithAddFirstAndAddLast() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    for (int i = 0; i < SIZE; i++) {
      if (i % 2 == 0) {
        list.addFirst(Integer.toString(i));
      } else {
        list.addLast(Integer.toString(i));
      }
    }
    assertTrue(!list.isEmpty());
    assertEquals(list.getSize(), SIZE);
  }

  @Test
  public void testAddManyStringsToLinkedListWithAddLastAndThenRemove() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    for (int i = 0; i < SIZE; i++) {
      list.addFirst(Integer.toString(i));
    }
    assertTrue(!list.isEmpty());
    assertEquals(list.getSize(), SIZE);
    for (int i = 0; i < SIZE; i++) {
      list.removeFirst();
    }
    assertTrue(list.isEmpty());
    assertEquals(list.getSize(), 0);
  }

  @Test
  public void testAddManyStringsToLinkedListWithAddFirstAndThenRemove() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    for (int i = 0; i < SIZE; i++) {
      list.addLast(Integer.toString(i));
    }
    assertTrue(!list.isEmpty());
    assertEquals(list.getSize(), SIZE);
    for (int i = 0; i < SIZE; i++) {
      list.removeFirst();
    }
    assertTrue(list.isEmpty());
    assertEquals(list.getSize(), 0);
  }

}
