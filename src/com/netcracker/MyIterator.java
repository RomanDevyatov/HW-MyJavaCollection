package com.netcracker;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyIterator<E> implements Iterator<E> {
    Node<E> current;

    public MyIterator(MyLinkedList<E> list){
        current=list.getHead();
    }

    public boolean hasNext() {
        return current != null;
    }


    public E next() {
        E data = current.getData();
        current = current.getNext();
        return data;
    }


    public void remove() {
        throw new UnsupportedOperationException();
    }

}
