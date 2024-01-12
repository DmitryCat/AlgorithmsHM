package test;
import IntegerList.IntegerList;
import IntegerList.IntegerListImpl;
import IntegerList.Exception.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerListImplTest {

    @Test
    public void shouldAddItem() {
        IntegerList integerList = new IntegerListImpl();
        Integer item = 42;
        integerList.add(item);
        Assertions.assertTrue(integerList.contains(item));
    }

    @Test
    public void shouldAddItemAtSpecifiedIndex() {
        IntegerList integerList = new IntegerListImpl();
        Integer item1 = 42;
        Integer item2 = 99;
        integerList.add(item1);
        integerList.add(0, item2);
        Assertions.assertEquals(item2, integerList.get(0));
        Assertions.assertEquals(item1, integerList.get(1));
    }

    @Test
    public void shouldSetItemAtSpecifiedIndex() {
        IntegerList integerList = new IntegerListImpl();
        Integer item1 = 42;
        Integer item2 = 99;
        integerList.add(item1);
        integerList.set(0, item2);
        Assertions.assertEquals(item2, integerList.get(0));
    }

    @Test
    public void shouldRemoveItem() {
        IntegerList integerList = new IntegerListImpl();
        Integer item = 42;
        integerList.add(item);
        integerList.remove(item);
        Assertions.assertFalse(integerList.contains(item));
    }

    @Test
    public void shouldRemoveItemAtSpecifiedIndex() {
        IntegerList integerList = new IntegerListImpl();
        Integer item1 = 42;
        Integer item2 = 99;
        integerList.add(item1);
        integerList.add(item2);
        integerList.remove(0);
        Assertions.assertEquals(item2, integerList.get(0));
        Assertions.assertEquals(1, integerList.size());
    }

    @Test
    public void shouldReturnIndexOfItem() {
        IntegerList integerList = new IntegerListImpl();
        Integer item = 42;
        integerList.add(7);
        integerList.add(item);
        Assertions.assertEquals(1, integerList.indexOf(item));
    }

    @Test
    public void shouldReturnLastIndexOfItem() {
        IntegerList integerList = new IntegerListImpl();
        Integer item = 42;
        integerList.add(item);
        integerList.add(99);
        integerList.add(item);
        Assertions.assertEquals(2, integerList.lastIndexOf(item));
    }

    @Test
    public void shouldReturnSize() {
        IntegerList integerList = new IntegerListImpl();
        integerList.add(42);
        integerList.add(99);
        Assertions.assertEquals(2, integerList.size());
    }

    @Test
    public void shouldReturnTrueIfEmpty() {
        IntegerList integerList = new IntegerListImpl();
        Assertions.assertTrue(integerList.isEmpty());
    }

    @Test
    public void shouldReturnFalseIfNotEmpty() {
        IntegerList integerList = new IntegerListImpl();
        integerList.add(42);
        Assertions.assertFalse(integerList.isEmpty());
    }

    @Test
    public void shouldClearList() {
        IntegerList integerList = new IntegerListImpl();
        integerList.add(42);
        integerList.add(99);
        integerList.clear();
        Assertions.assertTrue(integerList.isEmpty());
    }

    @Test
    public void shouldConvertToList() {
        IntegerList integerList = new IntegerListImpl();
        integerList.add(42);
        integerList.add(99);
        Integer[] array = integerList.toArray();
        Assertions.assertArrayEquals(new Integer[]{42, 99}, array);
    }

    @Test
    public void shouldThrowNullItemException() {
        IntegerList integerList = new IntegerListImpl();
        Assertions.assertThrows(NullItemException.class, () -> integerList.add(null));
    }

    @Test
    public void shouldThrowStorageIsFullException() {
        IntegerList integerList = new IntegerListImpl(2);
        integerList.add(42);
        integerList.add(99);
        Assertions.assertThrows(StorageIsFullException.class, () -> integerList.add(100));
    }

    @Test
    public void shouldThrowInvalidIndexException() {
        IntegerList integerList = new IntegerListImpl();
        Assertions.assertThrows(InvalidIndexException.class, () -> integerList.add(-1, 42));
    }

    @Test
    public void shouldThrowElementNotFoundException() {
        IntegerList integerList = new IntegerListImpl();
        Assertions.assertThrows(ElementNotFoundException.class, () -> integerList.remove(42));
    }
}