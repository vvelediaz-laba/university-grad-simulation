package com.solvd.universitygradsimulation.interfaces;

import java.util.List;

@FunctionalInterface
public interface IList<T, E> {
    List<T> toList(List<E> list);
}
