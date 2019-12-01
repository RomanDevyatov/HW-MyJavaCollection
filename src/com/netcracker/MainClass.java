package com.netcracker;

public class MainClass {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(6);
        list.set(2, 33333);
        String s=list.toString();
        System.out.println(s);
//        for (Integer string : myList)
//            System.out.println(string);
    }
}

