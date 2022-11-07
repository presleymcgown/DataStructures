package com.prog2.datastructures;

import com.prog2.interfaces.List;


/**
 * A doubly linked list implementation. Nodes have a previous connection AND a next connection.
 *
 * There is more memory overhead in a doubly linked list than a singly linked list.
 * This is useful in only particular cases where forward AND backward traversal are necessary.
 *
 * For example, a browser uses a doubly linked list in order to allow you to have a forward and a backward button.
 *
 *
 * @param <T>
 */
public class DoublyLinkedList<T> implements List<T>{

    //! you have to set up the previous node as well as the next when you add/remove/ect.

    private int count;
    private Node head;
    private Node tail;

    public DoublyLinkedList(){

        count = 0;
        head = null;
        tail = null;

    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getLength() {
        return count;
    }

    @Override
    public T get(int index) {

        //optimized version, see if it is closer to the beginning or end and loop from there

        return null;
    }

    @Override
    public List prepend(T element) {
        return null;
    }

    @Override
    public List append(T element) {
        return null;
    }

    @Override
    public List insert(int index, T element) {
        return null;
    }

    @Override
    public List remove(int index) {
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    private class Node{

        private T data;
        private Node next;
        private Node prev;

        Node(T data){

            this.data = data;
            this.next = null;
            this.prev = null;

        }

    }

}
