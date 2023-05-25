package com.solvd.universitygradsimulation.collections;

import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E> {
    private Node<E> node;

    public LinkedListIterator(Node<E> node){
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public E next() {
        E data = node.getData();
        node = node.getNext();
        return data;
    }
}
