package com.gmail.sunychsun;

public class Main {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }

        System.out.println(arrayList.toString() + ", size: " + arrayList.size());

        arrayList.add(22, 7);
        System.out.println(arrayList.toString() + ", size: " + arrayList.size());
        arrayList.set(13, 4);
        System.out.println(arrayList.toString() + ", size: " + arrayList.size());

        arrayList.remove(12);
        System.out.println(arrayList.toString() + ", size: " + arrayList.size());
    }
}
