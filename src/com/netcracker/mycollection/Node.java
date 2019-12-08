package com.netcracker.mycollection;

public class Node<E> {
    E element;
    Node<E> nextNode;
    Node<E> prevNode;

    public Node(Node<E> prev, E element, Node<E> nextNode) {
        this.element = element;
        this.nextNode=nextNode;
        this.prevNode=prev;
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
