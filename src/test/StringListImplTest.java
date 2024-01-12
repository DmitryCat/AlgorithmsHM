package test;
import StringList.StringList;
import StringList.StringListImpl;
import StringList.Exception.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringListImplTest {

    @Test
    public void shouldAddItem() {
        StringList stringList = new StringListImpl();
        String item = "TestItem";
        stringList.add(item);
        Assertions.assertTrue(stringList.contains(item));
    }

    @Test
    public void shouldAddItemAtSpecifiedIndex() {
        StringList stringList = new StringListImpl();
        String item1 = "Item1";
        String item2 = "Item2";
        stringList.add(item1);
        stringList.add(0, item2);
        Assertions.assertEquals(item2, stringList.get(0));
        Assertions.assertEquals(item1, stringList.get(1));
    }

    @Test
    public void shouldSetItemAtSpecifiedIndex() {
        StringList stringList = new StringListImpl();
        String item1 = "Item1";
        String item2 = "Item2";
        stringList.add(item1);
        stringList.set(0, item2);
        Assertions.assertEquals(item2, stringList.get(0));
    }

    @Test
    public void shouldRemoveItem() {
        StringList stringList = new StringListImpl();
        String item = "TestItem";
        stringList.add(item);
        stringList.remove(item);
        Assertions.assertFalse(stringList.contains(item));
    }

    @Test
    public void shouldRemoveItemAtSpecifiedIndex() {
        StringList stringList = new StringListImpl();
        String item1 = "Item1";
        String item2 = "Item2";
        stringList.add(item1);
        stringList.add(item2);
        stringList.remove(0);
        Assertions.assertEquals(item2, stringList.get(0));
        Assertions.assertEquals(1, stringList.size());
    }

    @Test
    public void shouldReturnIndexOfItem() {
        StringList stringList = new StringListImpl();
        String item = "TestItem";
        stringList.add("AnotherItem");
        stringList.add(item);
        Assertions.assertEquals(1, stringList.indexOf(item));
    }

    @Test
    public void shouldReturnLastIndexOfItem() {
        StringList stringList = new StringListImpl();
        String item = "TestItem";
        stringList.add(item);
        stringList.add("AnotherItem");
        stringList.add(item);
        Assertions.assertEquals(2, stringList.lastIndexOf(item));
    }

    @Test
    public void shouldReturnSize() {
        StringList stringList = new StringListImpl();
        stringList.add("Item1");
        stringList.add("Item2");
        Assertions.assertEquals(2, stringList.size());
    }

    @Test
    public void shouldReturnTrueIfEmpty() {
        StringList stringList = new StringListImpl();
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    public void shouldReturnFalseIfNotEmpty() {
        StringList stringList = new StringListImpl();
        stringList.add("TestItem");
        Assertions.assertFalse(stringList.isEmpty());
    }

    @Test
    public void shouldClearList() {
        StringList stringList = new StringListImpl();
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.clear();
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    public void shouldConvertToList() {
        StringList stringList = new StringListImpl();
        stringList.add("Item1");
        stringList.add("Item2");
        String[] array = stringList.toArray();
        Assertions.assertArrayEquals(new String[]{"Item1", "Item2"}, array);
    }

    @Test
    public void shouldThrowNullItemException() {
        StringList stringList = new StringListImpl();
        Assertions.assertThrows(NullItemException.class, () -> stringList.add(null));
    }

    @Test
    public void shouldThrowStorageIsFullException() {
        StringList stringList = new StringListImpl(2);
        stringList.add("Item1");
        stringList.add("Item2");
        Assertions.assertThrows(StorageIsFullException.class, () -> stringList.add("Item3"));
    }

    @Test
    public void shouldThrowInvalidIndexException() {
        StringList stringList = new StringListImpl();
        Assertions.assertThrows(InvalidIndexException.class, () -> stringList.add(-1, "Item"));
    }

    @Test
    public void shouldThrowElementNotFoundException() {
        StringList stringList = new StringListImpl();
        Assertions.assertThrows(ElementNotFoundException.class, () -> stringList.remove("NonexistentItem"));
    }
}