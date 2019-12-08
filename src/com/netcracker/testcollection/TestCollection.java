package com.netcracker.testcollection;

import java.util.*;

public class TestCollection {

    public static void main(String[] args){
        ArrayList<Integer> arrayList= new ArrayList<>();
        LinkedList<Integer> linkedList= new LinkedList<>();

        long
                startTime,
                endTime,
                estimatedTime,
                estimatedTime1,
                estimatedTime2;

        startTime = System.nanoTime();
        for(int i=0; i<100000; i++) arrayList.add(1);
        endTime=System.nanoTime();
        estimatedTime1 = (endTime - startTime);
        System.out.println("Adding of ArrayList:       " + estimatedTime1);

        startTime = System.nanoTime();
        for(int i=0; i<100000; i++) linkedList.add(1);
        endTime=System.nanoTime();
        estimatedTime2 = endTime - startTime;
        System.out.println("Adding of LinkedList:      " + estimatedTime2);


        startTime = System.nanoTime();
        arrayList.set(6666, 66666);
        estimatedTime1 = System.nanoTime() - startTime;
        System.out.println("Setting of ArrayList:      " + estimatedTime1);

        startTime = System.nanoTime();
        linkedList.set(6666, 66666);
        estimatedTime2 = System.nanoTime() - startTime;
        System.out.println("Setting of LinkedList:     " + estimatedTime2);


        startTime = System.nanoTime();
        arrayList.remove(1000);
        estimatedTime1 = System.nanoTime() - startTime;
        System.out.println("Removing of ArrayList:     " + estimatedTime1);

        startTime = System.nanoTime();
        linkedList.remove(1000);
        estimatedTime2 = System.nanoTime() - startTime;
        System.out.println("Removing of LinkedList:    " + estimatedTime2);
        System.out.println("***************************************************");

        HashSet<Integer> hs=new HashSet<>();
        LinkedHashSet<Integer> lhs=new LinkedHashSet<>();
        TreeSet<Integer> ts=new TreeSet<>();


        startTime = System.nanoTime();
        for(int i=0; i<100000; i++) hs.add(1);
        endTime=System.nanoTime();
        estimatedTime = (endTime - startTime);
        System.out.println("Adding of HashSet:         " + estimatedTime);

        startTime = System.nanoTime();
        for(int i=0; i<100000; i++) lhs.add(1);
        endTime=System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("Adding of LinkedHashSet:   " + estimatedTime);

        startTime = System.nanoTime();
        for(int i=0; i<100000; i++) ts.add(1);
        endTime=System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("Adding of TreeSet:         " + estimatedTime);

        startTime = System.nanoTime();
        hs.remove(1000);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Removing of HashSet:       " + estimatedTime);

        startTime = System.nanoTime();
        lhs.remove(1000);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Removing of LinkedHashSet: " + estimatedTime);

        startTime = System.nanoTime();
        ts.remove(1000);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Removing of TreeSet:       " + estimatedTime);
        System.out.println("***************************************************");


        HashMap<Integer, String> hm=new HashMap<>();
        LinkedHashMap<Integer, String> lhm=new LinkedHashMap<>();
        TreeMap<Integer,String> tm=new TreeMap<>();


        startTime = System.nanoTime();
        hm.put(212133, "Лидия Аркадьевна Бубликова");
        hm.put(162348, "Иван Михайлович Серебряков");
        hm.put(8082771, "Дональд Джон Трамп");
        endTime=System.nanoTime();
        estimatedTime = (endTime - startTime);
        System.out.println("Adding of HashMap:         " + estimatedTime);

        startTime = System.nanoTime();
        lhm.put(212133, "Лидия Аркадьевна Бубликова");
        lhm.put(162348, "Иван Михайлович Серебряков");
        lhm.put(8082771, "Дональд Джон Трамп");
        endTime=System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("Adding of LinkedHashMap:   " + estimatedTime);

        startTime = System.nanoTime();
        tm.put(212133, "Лидия Аркадьевна Бубликова");
        tm.put(162348, "Иван Михайлович Серебряков");
        tm.put(8082771, "Дональд Джон Трамп");
        endTime=System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("Adding of TreeMap:         " + estimatedTime);



        startTime = System.nanoTime();
        hm.remove(8082771);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Removing of HashMap:       " + estimatedTime);

        startTime = System.nanoTime();
        lhm.remove(8082771);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Removing of LinkedHashMap: " + estimatedTime);

        startTime = System.nanoTime();
        tm.remove(8082771);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Removing of TreeMap:       " + estimatedTime);
        System.out.println("**********************************************");
    }
}
