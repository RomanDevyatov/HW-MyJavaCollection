package com.netcracker;

import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> head;//=new Node(null, null);
    private int listSize;


    public MyLinkedList(){
        this.head=null;
        this.listSize=0;
    }

    public Node<E> getHead(){
        return head;
    }

    public E getE(){
        return this.head.element;
    }

    @Override
    public void add(Object element) {
        Node<E> newNode=new Node(element, null);
        if(head==null){
            head=newNode;
        }
        else{
            Node<E> last = head;
            while (last.nextNode != null) {
                last = last.nextNode;
            }
            last.nextNode = newNode;
        }
        listSize++;
    }

    public void add(int index, Object element) {
        if (index<0 || index >listSize){
            System.exit(-1);
        }
        int cnt=0;
        if(head==null){
            add(element);
        }
        else if(index==0){
            Node<E> newNode = new Node(element, head);
            head=newNode;
            listSize++;
        }
        else {
            Node<E> currNode = head;
            Node<E> prev=head;
            while (cnt < index) {
                cnt++;
                prev=currNode;
                currNode = currNode.nextNode;
            }
            Node<E> newNode = new Node(element, currNode);
            prev.nextNode=newNode;
            prev=currNode=null;
            listSize++;
        }


    }

    @Override
    public void clear() {
        head=null;
    }

    @Override
    public E get(int index) {
        int cnt=0;
        Node<E> currNode = head;
        if(index <=listSize) {
            while (cnt < index) {
                cnt++;
                currNode = currNode.nextNode;
            }
        }
        else System.exit(-1);

        return (E) currNode.element;
    }

    @Override
    public int indexOf(Object element) {
        Node<E> currNode = head;
        int index=0;
        while (currNode.element != element) {
            if(currNode.nextNode == null)
                System.exit(-1);
            index++;
        }
        return index;
    }

    @Override
    public E remove(int index) {
        if(index<0 || index>listSize){
            System.exit(-1);
        }
        if(head==null){
            System.exit(-2);
        }
        Node<E> currNode = head;
        int currIndex=0;
        while (currIndex<index-1) {
            currIndex++;
            currNode=currNode.nextNode;
        }
        Node<E> tmpNode=currNode.nextNode.nextNode;
        currNode.nextNode.nextNode=null;
        currNode.nextNode=tmpNode;

        listSize--;
        return null;
    }

    @Override
    public E set(int index, Object element) {
        if(index<0 || index>listSize){
            System.exit(-1);
        }
        Node<E> currNode = head;
        int currIndex=0;
        while (currIndex<index) {
            currIndex++;
            currNode=currNode.nextNode;
        }
        E oldVal = currNode.element;
        currNode.element= (E) element;
        return null;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public E[] toArray() {
        Object[] res=new Object[listSize];
        int i=0;
        if(head!=null){
            Node currNode=head;
            while(currNode!=null){
                currNode=currNode.nextNode;
                res[i++]= currNode.element;
            }
        }
        return (E[]) res;
    }
    @Override
    public  String toString(){
        //Object[] o=toArray();
        Node<E> curr=head;
        String res="[";
        for(int i=0; i<listSize;i++){
            res=res + " " + curr.element;
            curr=curr.nextNode;
        }
        res=res+"]";
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>(this);

//        Iterator<E> iterator = new Iterator<E>() {
//
//            private int currentIndex = 0;
//            public Node<E> curr=head;
//            //Object[] arr=toArray();
//
//
//            @Override
//            public boolean hasNext() {
//                return curr!=null;
//            }
//
//            @Override
//            public E next() {
//                    E e = curr.element;
//                    curr = curr.nextNode;
//                    return (E) e;
//            }
//
//            @Override
//            public void remove() {
//                throw new UnsupportedOperationException();
//            }
//        };
//        return iterator;
    }
}
