package com.netcracker;

public class Node<E> {
    E element;
    Node nextNode;

    public Node(E element, Node<E> nextNode) {
        this.element = element;
        this.nextNode=nextNode;
    }

    public E getData()
    {
        return element;
    }
    public Node<E> getNext()
    {
        return nextNode;
    }
}
