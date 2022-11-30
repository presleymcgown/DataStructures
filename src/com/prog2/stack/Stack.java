package com.prog2.stack;

/**
 * A first in last out (FILO) or last in first out (LIFO) data structure.
 *
 * @param <T>
 */

public class Stack<T> {

    static final int MAX = 1000;
    private int top;
    T[] arr;

    public Stack(){

        top = -1;

        // indicies are 0-999. a total of 1000 slots
        arr = (T[]) new Object[MAX];


    }

    public boolean isEmpty(){

        return top < 0;

    }

    public boolean isFull(){

        return top >= MAX - 1;

    }

    public void push(T item){

        if(isFull()){
            System.out.println("Stack is full.");
            return;
        }

        arr[++top] = item;


    }

    public T pop(){

        if(isEmpty()){
            System.out.println("Stack is empty.");
            return null;
        }

        return arr[top--];

    }

    public T peek(){

        if(isEmpty()){
            System.out.println("Stack is empty.");
            return null;
        }

        return arr[top];

    }

}
