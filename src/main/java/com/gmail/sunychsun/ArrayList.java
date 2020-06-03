package com.gmail.sunychsun;

public class ArrayList implements List
{

    private Object[] dataArray;
    private final Object[] EMPTY_ARRAY = {};

    private int size = 0;
    private final int DEFAULT_SIZE = 10;

    public ArrayList(int initSize) {
        if(initSize > 0) {
            this.dataArray = new Object[initSize];
        } else if (initSize == 0){
            new ArrayList();
        } else {
            throw new IllegalArgumentException("Bad size: "+ initSize);
        }
    }

    public ArrayList() {
        dataArray = EMPTY_ARRAY;
    }

    private void getArraySize(int actualSize){
        checkArraySize(returnArraySize(actualSize));
    }

    private void checkArraySize(int actualSize) {
        if (actualSize - dataArray.length > 0) {
            grow(actualSize);
        }
    }

    private int returnArraySize(int actualSize) {
        if(dataArray == EMPTY_ARRAY) {
            return Math.max(DEFAULT_SIZE, actualSize);
        }
        return actualSize;
    }

    private void grow(int actualSize) {
        int oldSize = dataArray.length;
        int newSize = oldSize + (oldSize / 2);
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

    private Object[] newArray(Object[] o, int index, Object value) {
        Object[] array = new Object[size + 1];

        for (int i = 0; i < index; i ++) {
            array[i] = o[i];
        }

        array[index] = value;

        for (int i = index + 1; i < array.length; i++) {
            array[i] = o[i - 1];
        }

        return array;
    }

    private Object[] removedValueFromArray(Object[] o, int index) {
        Object[] array = new Object[size - 1];

        for (int i = 0; i < index; i ++) {
            array[i] = o[i];
        }


        for (int i = index; i < array.length; i++) {
            array[i] = o[i + 1];
        }

        return array;
    }

    public void checkRang(int index) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException("Wrong index. Array size: " + size + ", and your index: " + index);
        }

    }

    public void add(Object value) {
        getArraySize(size + 1);
        dataArray[size++] = value;
//        System.out.println(dataArray.length);
    }

    public void add(Object value, int index) {
        checkRang(index);

        getArraySize(size + 1);
        dataArray = newArray(dataArray, index, value);
        size++;
    }

    public Object remove(int index) {
        checkRang(index);

        Object removedValue = dataArray[index];

        dataArray = removedValueFromArray(dataArray, index);
        size--;

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
        for (int i = 0; i < dataArray.length; i++) {
            dataArray[i] = null;
        }

        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        if(indexOf(value) >= 0) {
            return true;
        }

        return false;
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
}
