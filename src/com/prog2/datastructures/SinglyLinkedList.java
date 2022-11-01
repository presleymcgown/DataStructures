package com.prog2.datastructures;

import com.prog2.interfaces.List;

/**
 * In a singly linked list, nodes will only know where the next node in the chain is. This is  sometimes preferable because there is less memory overhead as compared to a doubly linked list.
 *
 * Advantages VS Array/ArrayList:
 * - True Dynamic Size
 * - Ease of insertion/deletion
 *
 * Disadvantages VS Array/ArrayList:
 * - Random access is not allowed, elements MUST be accessed sequentially.
 * - Extra memory space must be used for a pointer to each item in the list
 * - Not cache friendly, as linked lists do not store data in contiguous memory locations.
 *
 */
public class SinglyLinkedList<T> implements List {

    private int count;
    private Node head;
    private Node tail;

    public SinglyLinkedList(){

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
    public Object get(int index) {

        if(index < 0 || index >= count){
            throw new IndexOutOfBoundsException(index);
        }

        int i = 0;
        Node ptr = head;

        while(i < index && ptr.next != null){

            ptr = ptr.next;
            i++;

        }

        return ptr.data;
    }

    @Override
    public List prepend(Object element) {

        Node n = new Node((T) element); //! does this work???

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
    public List append(Object element) {

        Node n = new Node((T) element);

        if(count == 0){
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }

        count++;

        return this;
    }

    @Override
    public List insert(int index, Object element) {
        return null;
    }

    @Override
    public List remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }



    private class Node {

        //the info this node represents
        private T data;
        //the next node in the chain
        private Node next;

        Node(T data){
            this.data = data;
            this.next = null;
        }


    }

}
