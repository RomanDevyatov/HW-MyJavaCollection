package com.netcracker.mycollection;

import java.util.LinkedList;

public class MainClass {

    public static void main(String[] args) {

//        long startTime;
//        long
//                estimatedTime1,
//                estimatedTime2;
//
//        startTime = System.nanoTime();
//        LinkedList<Integer> list= new LinkedList<>();
//        for(int j=0; j<100000;j++){
//            list.add(1);
//        }
//        estimatedTime2 = System.nanoTime() - startTime;
//
//        startTime = System.nanoTime();
//        MyLinkedList<Integer> myList = new MyLinkedList<>();
//        for(int i=0; i<100000; i++){
//            myList.add(1);
//        }
//        estimatedTime1 = System.nanoTime() - startTime;
//
//        System.out.println("Adding of my   Collection:    " + estimatedTime1);
//        System.out.println("Adding of java Collection:    " + estimatedTime2);
//
//        startTime = System.nanoTime();
//        myList.set(6666, 66666);
//        estimatedTime1 = System.nanoTime() - startTime;
//
//        startTime = System.nanoTime();
//        list.set(6666, 66666);
//        estimatedTime2 = System.nanoTime() - startTime;
//        System.out.println("Setting of my   Collection:    " + estimatedTime1);
//        System.out.println("Setting of java Collection:    " + estimatedTime2);
//
//        startTime = System.nanoTime();
//        myList.indexOf(666);
//        estimatedTime1 = System.nanoTime() - startTime;
//
//        startTime = System.nanoTime();
//        list.indexOf(666);
//        estimatedTime2 = System.nanoTime() - startTime;
//
//        System.out.println("Searching of my   Collection:    " + estimatedTime1);
//        System.out.println("Searching of java Collection:    " + estimatedTime2);
//
//        startTime = System.nanoTime();
//        myList.remove(1000);
//        estimatedTime1 = System.nanoTime() - startTime;
//
//        startTime = System.nanoTime();
//        list.remove(1000);
//        estimatedTime2 = System.nanoTime() - startTime;
//
//        System.out.println("Removing of my   Collection:    " + estimatedTime1);
//        System.out.println("Removing of java Collection:    " + estimatedTime2);


        MyLinkedList<Integer> myList = new MyLinkedList<>();
        for(int j=0; j<10;j++){
            myList.add(1);
        }
        for(Integer str: myList){ System.out.println(str); }




        //System.out.println(myl.toArray());
//        for (Integer item : myl)
//            System.out.println(item);
//        myl.add(666,6);
//        list.add(666,6);
//        startTime = System.nanoTime();
//        list.indexOf(6);
//        long estimatedTimeIndex1 = System.nanoTime() - startTime;
//
//        startTime = System.nanoTime();
//        myl.indexOf(6);
//        long estimatedTimeIndex2 = System.nanoTime() - startTime;
//
//        System.out.println("Searching of my   Collection:    " + estimatedTimeIndex2);
//        System.out.println("Searching of java Collection:    " + estimatedTimeIndex1);
    }
}

