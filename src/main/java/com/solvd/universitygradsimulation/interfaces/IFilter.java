package com.solvd.universitygradsimulation.interfaces;

@FunctionalInterface
public interface IFilter<T> {
    boolean filter(T element);
}
