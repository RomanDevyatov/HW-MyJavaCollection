package com.netcracker;


import java.util.Iterator;

interface ILinkedList<E> extends Iterable<E>{
    public void add(E element);//Appends the specified element to the end of this list
    public void add(int index, E element);//Inserts the specified element at the specified position in this list
    public void clear();//Removes all of the elements from this list
    public E get(int index);//Returns the element at the specified position in this list.
    public int indexOf(E element);//Returns the index of the first occurrence
                                 // of the specified element in this list,
                                 // or -1 if this list does not contain the element.
    public E remove(int index);//Removes the element at the specified position in this list (optional operation)
    public E set(int index, E element);//Replaces the element at the specified position
                                       // in this list with the specified element (optional operation)
    public int size();//Returns the number of elements in this list
    public E[] toArray();//Returns an array containing all
                        // of the elements in this list in proper sequence (from first to last element)
    public  String toString();
}
