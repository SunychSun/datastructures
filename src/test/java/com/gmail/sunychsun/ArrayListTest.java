package com.gmail.sunychsun;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    ArrayList arrayList = new ArrayList();

    @Test
    public void sizeTest() {

        int expectedSize = 3;
        arrayList.add(12);
        arrayList.add(12);
        arrayList.add(12);

        int size = arrayList.size();
        Assertions.assertEquals(expectedSize, size);
    }

    @Test
    public void arrayIsEmpty() {
        Assertions.assertTrue(arrayList.isEmpty());
    }

    @Test
    public void arrayIsNotEmpty() {
        arrayList.add(new Object());
        Assertions.assertFalse(arrayList.isEmpty());
    }

    @Test
    public void addByIndex() {
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }

        int expected = 113;

        arrayList.add(113, 7);
        Object actual = arrayList.get(7);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setCheck() {
        for (int i = 0; i < 20; i++) {
            arrayList.add(i + 1);
        }

        int expected = 3;

        Object actual = arrayList.set(21, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getCheck() {
        for (int i = 0; i < 20; i++) {
            arrayList.add(i + 1);
        }

        int expected = 5;
        Object actual = arrayList.get(4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void clearTest() {
        for (int i = 0; i < 20; i++){
            arrayList.add(i);
        }

        boolean expected = false;
        boolean actual = arrayList.isEmpty();

        Assertions.assertEquals(expected, actual);

        arrayList.clear();

        expected = true;
        actual = arrayList.isEmpty();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeTest() {
        for (int i = 0; i < 20; i++){
            arrayList.add(i + 5);
        }

        int expected = 20;
        int actual = arrayList.size();

        Assertions.assertEquals(expected, actual);

        int removedExpected = 8;
        Object removedActual = arrayList.remove(3);

        Assertions.assertEquals(removedExpected, removedActual);

        expected = 19;
        actual = arrayList.size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByIndex() {
        for (int i = 0; i < 20; i++){
            arrayList.add(i + 5);
        }

        int expected = 3;
        int actual = arrayList.indexOf(8);

        Assertions.assertEquals(expected, actual);

        expected = -1;
        actual = arrayList.indexOf(100);

        Assertions.assertEquals(expected, actual);

        arrayList.set(null, 11);

        expected = 11;
        actual = arrayList.indexOf(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByLastIndex() {
        for (int i = 0; i < 20; i++){
            arrayList.add(i + 5);
        }

        arrayList.set(2, 18);

        int expected = 18;
        int actual = arrayList.lastIndexOf(2);

        Assertions.assertEquals(expected, actual);

        expected = -1;
        actual = arrayList.lastIndexOf(100);

        Assertions.assertEquals(expected, actual);

        arrayList.set(null, 11);
        arrayList.set(null, 16);

        expected = 16;
        actual = arrayList.lastIndexOf(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void containsTest() {
        for (int i = 0; i < 20; i++){
            arrayList.add(i + 5);
        }

        boolean expected = true;
        boolean actual = arrayList.contains(12);

        Assertions.assertEquals(expected, actual);

        expected = false;
        actual = arrayList.contains(100);

        Assertions.assertEquals(expected, actual);
    }
}
