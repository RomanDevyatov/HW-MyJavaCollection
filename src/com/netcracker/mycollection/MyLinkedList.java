package com.netcracker.mycollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {
    private int size=0;
    private Node<E> head;
    private Node<E> tail;
    private int modCount=0;


    public MyLinkedList(){
    }

    private void linkFirst(E e) {
        final Node<E> f = head;
        final Node<E> newNode = new Node<>(null, e, f);
        head = newNode;
        if (f == null)
            tail = newNode;
        else
            f.prevNode = newNode;
        modCount++;
        size++;
    }

    void linkLast(E e) {
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(l, e, null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.nextNode = newNode;
        modCount++;
        size++;
    }

    void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        final Node<E> pred = succ.prevNode;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prevNode = newNode;
        if (pred == null)
            head = newNode;
        else
            pred.nextNode = newNode;
        modCount++;
        size++;
    }

    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.element;
        final Node<E> next = f.nextNode;
        f.element = null;
        f.nextNode = null; // help GC
        head = next;
        if (next == null)
            tail = null;
        else
            next.prevNode = null;
        size--;
        modCount++;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.element;
        final Node<E> prev = l.prevNode;
        l.element = null;
        l.prevNode = null; // help GC
        tail = prev;
        if (prev == null)
            head = null;
        else
            prev.nextNode = null;
        size--;
        modCount++;
        return element;
    }

    E unlink(Node<E> x) {
        final E element = x.element;
        final Node<E> next = x.nextNode;
        final Node<E> prev = x.prevNode;

        if (prev == null) {
            head = next;
        } else {
            prev.nextNode = next;
            x.prevNode = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prevNode = prev;
            x.nextNode = null;
        }

        x.element = null;
        size--;
        modCount++;
        return element;
    }

    public E getFirst() {
        final Node<E> f = head;
        if (f == null)
            throw new NoSuchElementException();
        return f.element;
    }

    public E getLast() {
        final Node<E> l = tail;
        if (l == null)
            throw new NoSuchElementException();
        return l.element;
    }

    public E removeFirst() {
        final Node<E> f = head;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    public E removeLast() {
        final Node<E> l = tail;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    public void addLast(E e) {
        linkLast(e);
    }

    public int size() {
        return size;
    }

    public void add(E e) {
        linkLast(e);
    }

    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    public void clear() {
        for (Node<E> x = head; x != null; ) {
            Node<E> next = x.nextNode;
            x.element = null;
            x.nextNode = null;
            x.prevNode = null;
            x = next;
        }
        head = tail = null;
        size = 0;
        modCount++;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).element;
    }

    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.element;
        x.element = element;
        return oldVal;
    }


    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }



    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++)
                x = x.nextNode;
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prevNode;
            return x;
        }
    }

    public int indexOf(E element) { //from head
        int index = 0;
        for (Node<E> x = head; x != null; x = x.nextNode) {
            if (x.element == element)
                return index;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(E element) { //from last node
        int index = size;
        for (Node<E> x = tail; x != null; x = x.prevNode) {
            index--;
            if (x.element == element)
                return index;
        }
        return -1;
    }


//**************************
//    public MyListIterator<E> myListIterator(int index) {
//        checkPositionIndex(index);
//        return new ListItr(index);
//    }
//
//    private class ListItr implements MyListIterator<E> {
//        private Node<E> lastReturned;
//        private Node<E> next;
//        private int nextIndex;
//        private int expectedModCount = modCount;
//
//        ListItr(int index) {
//            // assert isPositionIndex(index);
//            next = (index == size) ? null : node(index);
//            nextIndex = index;
//        }
//
//        public boolean hasNext() {
//            return nextIndex < size;
//        }
//
//        public E next() {
//            checkForComodification();
//            if (!hasNext())
//                throw new NoSuchElementException();
//
//            lastReturned = next;
//            next = next.nextNode;
//            nextIndex++;
//            return lastReturned.element;
//        }
//
//        public boolean hasPrevious() {
//            return nextIndex > 0;
//        }
//
//        public E previous() {
//            checkForComodification();
//            if (!hasPrevious())
//                throw new NoSuchElementException();
//
//            lastReturned = next = (next == null) ? tail : next.prevNode;
//            nextIndex--;
//            return lastReturned.element;
//        }
//
//        public int nextIndex() {
//            return nextIndex;
//        }
//
//        public int previousIndex() {
//            return nextIndex - 1;
//        }
//
//        public void remove() {
//            checkForComodification();
//            if (lastReturned == null)
//                throw new IllegalStateException();
//
//            Node<E> lastNext = lastReturned.nextNode;
//            unlink(lastReturned);
//            if (next == lastReturned)
//                next = lastNext;
//            else
//                nextIndex--;
//            lastReturned = null;
//            expectedModCount++;
//        }
//
//        public void set(E e) {
//            if (lastReturned == null)
//                throw new IllegalStateException();
//            checkForComodification();
//            lastReturned.element = e;
//        }
//
//        public void add(E e) {
//            checkForComodification();
//            lastReturned = null;
//            if (next == null)
//                linkLast(e);
//            else
//                linkBefore(e, next);
//            nextIndex++;
//            expectedModCount++;
//        }
//
//        public void forEachRemaining(Consumer<? super E> action) {
//            Objects.requireNonNull(action);
//            while (modCount == expectedModCount && nextIndex < size) {
//                action.accept(next.element);
//                lastReturned = next;
//                next = next.nextNode;
//                nextIndex++;
//            }
//            checkForComodification();
//        }
//
//        final void checkForComodification() {
//            if (modCount != expectedModCount)
//                throw new ConcurrentModificationException();
//        }
//    }
//
//
//    private MyLinkedList<E> superClone() {
//        try {
//            return (MyLinkedList<E>) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new InternalError(e);
//        }
//    }


//    public Object clone() {
//        MyLinkedList<E> clone = superClone();
//
//        // Put clone into "virgin" state
//        clone.head = clone.tail = null;
//        clone.size = 0;
//        clone.modCount = 0;
//
//        // Initialize clone with our elements
//        for (Node<E> x = head; x != null; x = x.nextNode)
//            clone.add(x.element);
//
//        return clone;
//    }


    public Node<E> getHead(){
        return head;
    }

    public Node<E> getTail()
    {
        return tail;
    }



    @Override
    public Iterator<E> iterator() {
        return new MyListIterator<E>(this);
    }

//    @Override
//    public MyListIterator<E> listIterator(int index) {
//        return null;
//    }
//
//    @Override
//    public Iterator<E> iterator() {
//        return null;
//    }

//    public E getE(){
//        return this.head.element;
//    }


//    public void add(Object element) {
//        Node<E> l = tail;
//        Node<E> newNode=new Node(l,element, null);
//        tail=newNode;
//        if(l==null){
//            head=newNode;
//        }
//        else{
//            l.nextNode=newNode;
//        }
//        listSize++;
//    }

//    public void add(int index, Object element) {
//        if (index<0 || index >listSize){
//            System.exit(-1);
//        }
//        if (index == listSize){
//            add(element);
//        }
//        int cnt=0;
//        if(head==null){
//            add(element);
//        }
//        else if(index==0){
//            Node<E> newNode = new Node(element, head);
//            head=newNode;
//            listSize++;
//        }
//        else {
//            Node<E> currNode = head;
//            Node<E> prev=head;
//            while (cnt < index) {
//                cnt++;
//                prev=currNode;
//                currNode = currNode.nextNode;
//            }
//            Node<E> newNode = new Node(element, currNode);
//            prev.nextNode=newNode;
//            prev=currNode=null;
//            listSize++;
//        }
//
//
//    }





//    public E get(int index) {
//        int cnt=0;
//        Node<E> currNode = head;
//        if(index <=listSize) {
//            while (cnt < index) {
//                cnt++;
//                currNode = currNode.nextNode;
//            }
//        }
//        else System.exit(-1);
//
//        return (E) currNode.element;
//    }


//    public int indexOf(Object element) {
//        Node<E> currNode = head;
//        int index=0;
//        while (currNode.element != element) {
//            if(currNode.nextNode == null)
//                System.exit(-1);
//            index++;
//        }
//        return index;
//    }


//    public E remove(int index) {
//        if(index<0 || index>listSize){
//            System.exit(-1);
//        }
//        if(head==null){
//            System.exit(-2);
//        }
//        Node<E> currNode = head;
//        int currIndex=0;
//        while (currIndex<index-1) {
//            currIndex++;
//            currNode=currNode.nextNode;
//        }
//        Node<E> tmpNode=currNode.nextNode.nextNode;
//        currNode.nextNode.nextNode=null;
//        currNode.nextNode=tmpNode;
//
//        listSize--;
//        return null;
//    }


//    public E set(int index, Object element) {
//        if(index<0 || index>listSize){
//            System.exit(-1);
//        }
//        Node<E> currNode = head;
//        int currIndex=0;
//        while (currIndex<index) {
//            currIndex++;
//            currNode=currNode.nextNode;
//        }
//        E oldVal = currNode.element;
//        currNode.element= (E) element;
//        return null;
//    }


    public boolean isEmpty() {
        return size==0;
    }


    public E[] toArray() {
        Object[] res=new Object[size];
        int i=0;
        for (Node<E> x = head; x != null; x = x.nextNode)
            res[i++] = x.element;

        return (E[] ) res;

    }
    //@Override
//    public  String toString(){
//        //Object[] o=toArray();
//        Node<E> curr=head;
//        String res="[";
//        while(curr!=null){
//            res=res + " " + curr.element;
//            curr=curr.nextNode;
//        }
//        res=res+"]";
//        return res;
//    }

//    //@Override
//    public Iterator<E> iterator() {
//        return new MyIterator<E>(this);

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

