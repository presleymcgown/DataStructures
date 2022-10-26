package com.prog2.datastructures;

import com.prog2.interfaces.List;

public class ArrayList<T> implements List<T> {

    private T[] list;
    private int count;

    public ArrayList(){
        this(20);
    }

    public ArrayList(int maxSize){
        count = 0;
        list = (T[])(new Object[maxSize]);
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
        if(index < 0 || index >= count){
            return null;
        }
        return list[index];
    }

    @Override
    public List prepend(T element) {

        for (int i = count - 1; i >= 0; i--) {
            list[i + 1] = list[i];
        }

        list[0] = element;
        count++;

        return this;

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
    public int indexof(T element) {
        return 0;
    }
}
