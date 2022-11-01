package com.prog2.datastructures;

import com.prog2.interfaces.List;

public class ArrayList<T> implements List<T> {

    private T[] list;
    private int count;

    public ArrayList(){
        this(20);
    }

    public ArrayList(int initialSize){
        count = 0;
        list = (T[])(new Object[initialSize]);
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

        checkForGrowth();

        for (int i = count - 1; i >= 0; i--) {
            list[i + 1] = list[i];
        }

        list[0] = element;
        count++;

        return this;

    }



    @Override
    public List append(T element) {

        checkForGrowth();

        list[count] = element;
        count++;

        return this;

    }

    @Override
    public List insert(int index, T element) {

        if(index < 0 || index >= count){
            // throw IndexOutOfBoundsException();
        }

        checkForGrowth();

        for (int i = count - 1; i >= index; i--) {
            list[i + 1] = list [i];
        }

        list[index] = element;
        count++;

        return this;

    }

    @Override
    public List remove(int index) {

        if(index < 0 || index >= count){
            // throw IndexOutOfBoundsException();
        }

        for (int i = index; i >= count; i++) {

           list[i] = list[i + 1];

        }

        count--;

        return this;
    }

    @Override
    public int indexOf(T element) {



        for (int i = 0; i < count; i++) {

            if(list[i] == element){

                return i;

            }

        }

        return -1;
    }

    private void checkForGrowth(){

        if(count == list.length){

            T[] temp = (T[])(new Object[count * 2]);

            for (int i = 0; i < list.length; i++) {

                temp[i] = list[i];

            }

            list = temp;

        }

    }
}
