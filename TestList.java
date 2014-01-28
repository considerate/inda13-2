

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.junit.rules.ExpectedException;

@RunWith(JUnit4.class)
public class TestList {
  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void testEmptyList() {
    LinkedList<String> list = new LinkedList<String>();
    assertEquals(true, list.isEmpty());
  }

  @Test
  public void testSize() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("asd");
    list.addLast("hahah");
    list.addLast("hahah123");
    list.addLast("hahaha");
    list.addLast("hahahs");
    assertEquals(5, list.size());

    LinkedList<String> list2 = new LinkedList<String>();
    assertEquals(0, list2.size());

    LinkedList<String> list3 = new LinkedList<String>();
    list3.addLast("Test");
    list3.addLast("Hello");
    list3.addLast("Asd"); 
    assertEquals(3, list3.size()); 

  }

  @Test
  public void testSizeWithNullElement() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("asd");
    list.addLast(null);
    list.addLast("This is a text string\'");
    list.addLast("");
    assertEquals(4, list.size());
  }

  @Test
  public void testToString() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("Hej");
    list.addLast("Test$,data");
    list.addLast("Hallå");
    list.addFirst(null);
    assertEquals("[null, Hej, Test$,data, Hallå]" ,list.toString());   
  }
  @Test
  public void testIsHealthy() {
    LinkedList<String> list1 = new LinkedList<String>();
    assertEquals(true, list1.isHealthy());

    LinkedList<String> list2 = new LinkedList<String>();
    list2.addFirst("Hello");
    assertEquals(true, list2.isHealthy());

    LinkedList<String> list3 = new LinkedList<String>();
    list3.addLast("Hello");
    assertEquals(true, list3.isHealthy());

    LinkedList<String> list4 = new LinkedList<String>();
    list4.addLast("World!");
    list4.addFirst("Hello, ");
    assertEquals(true, list4.isHealthy());

    LinkedList<String> list5 = new LinkedList<String>();
    list5.addFirst("World!");
    list5.addFirst("Hello, ");
    assertEquals(true, list5.isHealthy());
  }

  @Test
  public void testAddFirst() {
    LinkedList<String> list = new LinkedList<String>();
    list.addFirst("Test");
    assertEquals(true, list.isHealthy());
  }

  @Test
  public void testAddLast() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("Test");
    assertEquals(true, list.isHealthy());
  }

  @Test
  public void testGetFirst() {
    LinkedList<String> list1 = new LinkedList<String>();
    list1.addLast("Test");
    list1.addLast("Hello");
    list1.addLast("Asd");
    assertEquals("Test", list1.getFirst());

    LinkedList<String> list2 = new LinkedList<String>();
    list2.addFirst("Test");
    list2.addLast("Hello");
    list2.addFirst("Asd");
    assertEquals("Asd", list2.getFirst());
  }

  @Test
  public void testGetLast() {
    LinkedList<String> list1 = new LinkedList<String>();
    list1.addLast("Test");
    list1.addLast("Hello");
    list1.addLast("Asd");
    assertEquals("Asd", list1.getLast());

    LinkedList<String> list2 = new LinkedList<String>();
    list2.addFirst("Test");
    list2.addLast("Hello");
    list2.addFirst("Asd");
    assertEquals("Hello", list2.getLast());
  }

  @Test
  public void testGetIndex() {
    LinkedList<String> list1 = new LinkedList<String>();
    list1.addLast("Test");
    list1.addLast("Hello");
    list1.addLast("Asd");
    assertEquals("Asd", list1.get(2));
    assertEquals("Test", list1.get(0));
    assertEquals("Hello", list1.get(1));

    exception.expect(IndexOutOfBoundsException.class);
    assertEquals("Hello", list1.get(8));

    LinkedList<String> list2 = new LinkedList<String>();
    list2.addFirst("Test");
    list2.addLast("Hello");
    list2.addFirst("Asd");

    exception = ExpectedException.none();
    assertEquals("Test", list2.get(1));
  }

  @Test
  public void testRemoveFirst() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("Test");
    list.addLast("Hello");
    list.addLast("Asd");   
    String first = list.removeFirst();
    assertEquals(2, list.size());

    assertEquals("Test", first);
    assertEquals("Hello", list.getFirst());
    assertEquals(true, list.isHealthy());

    LinkedList<String> list2 = new LinkedList<String>();
    first = list2.removeFirst();
    assertEquals(0, list2.size());
    assertEquals(null, first);
    assertEquals(true, list2.isHealthy());
  }

  @Test
  public void testClear() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("Test");
    list.addLast("Hello");
    list.addLast("Asd"); 
    list.clear();
    assertEquals(0, list.size());
    assertEquals(true, list.isHealthy());
    assertEquals(true, list.isEmpty());
    assertEquals(null, list.getFirst());
    assertEquals(null, list.getLast());     
  }

  @Test
  public void testIsEmpty() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("Test");
    list.addLast("Hello");
    list.addLast("Asd"); 
    assertEquals(false, list.isEmpty());

    LinkedList<String> list2 = new LinkedList<String>();  
    assertEquals(true, list2.isHealthy());
    assertEquals(true, list2.isEmpty());

    LinkedList<String> list3 = new LinkedList<String>();
    list3.addLast("Test");
    list3.addLast("Hello");
    list3.addLast("Asd"); 
    list3.clear();
    assertEquals(true, list3.isEmpty());
  }
}