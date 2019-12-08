package com.netcracker.mycollection;


import java.util.Iterator;

class MyListIterator<E> implements Iterator<E> {
    Node<E> current;

    // initialize pointer to head of the list for iteration
    public MyListIterator(MyLinkedList<E> list)
    {
        current = list.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current != null;
    }

    // return current data and update pointer
    public E next() {
        E data = current.getData();
        current = current.getNext();
        return data;
    }

    // implement if needed
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}