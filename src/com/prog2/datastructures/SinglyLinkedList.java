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

        Node n = new Node((T) element);

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

        Node n = new Node((T) element);

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
    public int indexOf(Object element) {

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
