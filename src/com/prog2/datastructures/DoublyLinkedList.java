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

        if(index > count){
            throw new IndexOutOfBoundsException(index);
        }else{


            Node ptr = head;

            for (int i = 0; i < index; i++) {

                ptr = ptr.next;

            }

            return ptr.data;

        }

    }

    @Override
    public List prepend(T element) {

        Node n = new Node(element);

        if(count == 0){
            head = n;
            tail = n;
        } else {
            n.next = head;
            head = n;
        }

        count++;
        return this;
    }

    @Override
    public List append(T element) {
       Node n = new Node(element);

        if(count == 0){
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail.prev;
            tail = n;
        }

        count++;

        return this;
    }

    @Override
    public List insert(int index, T element) {
        Node n = new Node(element);

        if(count == 0){
            head = n;
            tail = n;
        } else if(index == 0) {

            prepend(element);

        } else if (index == count){

            append(element);

        }else{

            Node ptr = head;

            for (int i = 0; i < index - 1; i++) {

                ptr = ptr.next;

            }

            n.next = ptr.next;
            n.prev = ptr.prev;
            ptr.next = n;

        }

        count++;

        return this;
    }

    @Override
    public List remove(int index) {
        if(index > count){
            throw new IndexOutOfBoundsException(index);
        }else if(index == 0){

            head = head.next;

            count--;

        }else {

            Node ptr = head;

            for (int i = 0; i < index - 1; i++) {

                ptr = ptr.next;

            }

            if(ptr.next == tail){

                ptr.next = ptr.next.next;
                tail = ptr.next;
                count--;
                return this;

            }

            ptr.next = ptr.next.next;

            count--;

        }

        return this;
    }

    @Override
    public int indexOf(T element) {
       Node ptr = head;

        for (int i = 0; i < count; i++) {

            if(ptr.data == element){
                return i;
            }else{
                ptr = ptr.next;
            }


        }

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
