package com.netcracker.mycollection;

import java.util.Iterator;
import java.util.function.Consumer;

public interface MyListIterator<E> extends Iterator<E> {
    boolean hasNext();
    E next();
    boolean hasPrevious();

    E previous();

    int nextIndex();
    int previousIndex();


    void remove();
    void set(E e);
    void add(E e);
}


//public class MyListIterator<E> extends Iterator<E> {
//    Node<E> current;
//
//    public MyIterator(MyLinkedList<E> list){
//        current=list.getHead();
//    }
//
//    public boolean hasNext() {
//        return current != null;
//    }
//
//
//    public E next() {
//        E data = current.getData();
//        current = current.getNext();
//        return data;
//    }
//
//    public boolean hasPrevious(){}
//
//    public void remove() {
//        throw new UnsupportedOperationException();
//    }
//
//}
