package com.solvd.universitygradsimulation.interfaces;

import java.util.List;

 @FunctionalInterface
public interface IAverage<T> {
    T average(List<T> elements);
}
