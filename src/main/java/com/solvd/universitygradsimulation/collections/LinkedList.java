package com.solvd.universitygradsimulation.collections;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E>{
    private Integer size;
    private Node<E> head;
    private Node<E> tail;

    public LinkedList(){
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        if(o == null || size == 0){
            return false;
        }

        E object = (E)o;


        for(E value: this){
            if(value.equals(object)){
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(head);
    }

    public Object[] toArray() {
        Object[] array = new Object[size];

        int i = 0;
        for(E value: this){
            array[i] = value;
            i++;
        }

        return array;
    }

    public <T> T[] toArray(T[] a) {
        Object[] array = a;

        if(size > array.length) {
            array = new Object[size];
        }

        int i = 0;
        for(E value: this){
            array[i] = value;
            i++;
        }

        if(array.length > i) {
            array[i] = null;
        }

        return (T[]) array;
    }

    public void add(E e) {
        if(size == 0){
            head = new Node<>(e);
            size++;
            return;
        }
        if(size == 1){
            tail = new Node<E>(e);
            head.setNext(tail);
            size++;
            return;
        }

        Node<E> newLast = new Node<>(e);
        tail.setNext(newLast);
        tail = newLast;
        size++;
    }

    public void addAtHead(E e){
        if (size == 0){
            head = new Node<E>(e);
        } else if(size == 1){
            tail = head;
            head = new Node<E>(tail, e);
        } else {
            head = new Node<E>(head, e);
        }
        size++;
    }

    public void add(int index, E e){
        if(index > size-1 || index < 0){
            return;
        }else if(index == 0){
            this.addAtHead(e);
        }else if(index == size - 1){
            tail = new Node<E>(e);
            head.setNext(tail);
        }else{
            Node<E> currentNode = head; // 1
            for (int i = 0; i <= index - 1; i++) {
                if (i == index - 1) {
                    Node<E> newNode = new Node<E>(e); // 2
                    Node<E> oldNode = currentNode.getNext(); // 3

                    currentNode.setNext(newNode); //
                    newNode.setNext(oldNode);
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }
        size++;
    }

    public E remove(int index) {
        if(index >= size || index < 0) return null;
        if(index == 0){
            E valueToRemove = head.getData();
            head = head.getNext();
            size--;
            return valueToRemove;
        }

        E valueToRemove = null;
        Node<E> currentNode = head;

        for(int i = 0; i <= index; i++){
            if(i == index-1){
                valueToRemove = currentNode.getNext().getData();
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
                break;
            }
            currentNode = currentNode.getNext();
        }
        return valueToRemove;
    }


    public E remove(Object o) {
        if(o == null || size == 0 ) return null;

        E object = (E) o;
        Node<E> currentNode = head;

        if(head.getData().equals(object)){
            E valueToRemove = head.getData();
            head = head.getNext();
            size--;
            return valueToRemove;
        }

        for(int i = 0; i <= size-2; i++){
            if(currentNode.getNext().getData().equals(object)){
                E valueToReturn = currentNode.getNext().getData();
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
                return valueToReturn;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public E get(int index) {
        int i = 0;
        for(E value: this){
            if(i == index){
                return value;
            }
            i++;
        }
        return null;
    }

    public void set(int index, E element) {
        if(index >= size || index < 0) return;

        Node<E> currentNode = head;

        for(int i = 0; i <= size-1; i++){
            if(i == index){
                currentNode.setData(element);
                return;
            }
            currentNode = currentNode.getNext();
        }
    }

    @Override
    public String toString(){
        Node<E> currentNode = head;
        StringBuilder string = new StringBuilder("[");
        while(currentNode != null){
            string.append(currentNode.getData().toString());
            string.append(", ");
            currentNode = currentNode.getNext();
        }
        if(string.length() > 1){
            string.delete(string.length() - 2, string.length());
        }
        string.append("]");
        return string.toString();
    }
}
