package com.gmail.sunychsun;

public class ArrayList implements List
{

    private Object[] dataArray;

    private int size = 0;
    private final int DEFAULT_SIZE = 10;
    private final Object[] EMPTY_ARRAY = {};

    public ArrayList(int initSize) {
        if(initSize >= 0) {
            dataArray = new Object[initSize];
        } else {
            throw new IllegalArgumentException("Bad size: "+ initSize);
        }
    }

    public ArrayList() {
        dataArray = new Object[DEFAULT_SIZE];
    }

    public void add(Object value) {
        checkArraySize(size + 1);
        dataArray[size++] = value;
//        System.out.println(dataArray.length);
    }

    public void add(Object value, int index) {
        checkRang(index);

        checkArraySize(size + 1);

        System.arraycopy(dataArray, index, dataArray, index + 1, size - index);
        dataArray[index] = value;

        size++;
    }

    public Object remove(int index) {
        checkRang(index);

        Object removedValue = dataArray[index];

        int valueForMove = size - index - 1;
        if(valueForMove >= 0)
            System.arraycopy(dataArray, index + 1, dataArray, index, valueForMove);
        dataArray[--size] = null;

        return removedValue;
    }

    public Object get(int index) {
        checkRang(index);

        return dataArray[index];
    }

    public Object set(Object value, int index) {
        checkRang(index);

        Object oldValue = dataArray[index];
        dataArray[index] = value;

        return oldValue;
    }

    public void clear() {
        dataArray = EMPTY_ARRAY;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    public int indexOf(Object value) {
        if (value != null) {
            for (int i = 0; i < size; i++) {
                if(value.equals(dataArray[i]))
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (dataArray[i] == null)
                    return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object value) {
        if (value != null) {
            for (int i = size - 1; i >= 0; i--) {
                if(value.equals(dataArray[i]))
                    return i;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (dataArray[i] == null)
                    return i;
            }
        }

        return -1;
    }

    public String toString() {
        StringBuffer arrayString = new StringBuffer();

        arrayString.append("[" + dataArray[0]);

        for (int i = 1; i < size; i++) {
            arrayString.append(", " + dataArray[i]);
        }

        arrayString.append("]");

        return arrayString.toString();
    }

    private void checkArraySize(int actualSize) {
        if (actualSize - dataArray.length > 0) {
            grow(actualSize);
        }
    }

    private void grow(int actualSize) {
        int oldSize = dataArray.length;
        int newSize = oldSize + ((oldSize / 2 ) + 1);
        if (newSize - actualSize < 0) {
            newSize = actualSize;
        }

        dataArray = newArray(dataArray, newSize);
    }

    private Object[] newArray(Object[] o, int size) {
        Object[] array = new Object[size];
        for (int i = 0; i < o.length; i++) {
            array[i] = o[i];
        }

        return array;
    }

    private void checkRang(int index) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException("Wrong index. Array size: " + size + ", and your index: " + index);
        }
    }
}
