package com.solvd.universitygradsimulation.enums;

public enum Grade {
    A,
    B,
    C,
    D,
    F;

    public int getValue(){
        switch(this){
            case A:
                return 4;
            case B:
                return 3;
            case C:
                return 2;
            case D:
                return 1;
            case F:
                return 0;
        }

        return 0;
    }
}
