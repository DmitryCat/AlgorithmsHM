package StringList;

import StringList.Exception.ElementNotFoundException;
import StringList.Exception.InvalidIndexException;
import StringList.Exception.NullItemException;
import StringList.Exception.StorageIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] strorage;
    private int size;

    public StringListImpl() {
        strorage = new String[10];

    }

    public StringListImpl(int initSize) {
        strorage = new String[initSize];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        strorage[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            strorage[size++] = item;
            return item;
        }
        System.arraycopy(strorage, index, strorage, index + 1, size - index);
        strorage[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        strorage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index != size) {
            System.arraycopy(strorage, index + 1, strorage, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = strorage[index];
        if (index != size) {
            System.arraycopy(strorage, index + 1, strorage, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            String s = strorage[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            String s = strorage[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return strorage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(strorage, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == strorage.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }
}
