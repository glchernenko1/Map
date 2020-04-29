package com.company;

import java.util.Comparator;

public class FlatAreaComparator  implements  Comparator<Flat> {

    @Override
    public int compare(Flat o1, Flat o2) {
        return (int)(o1.getSquare()-o2.getSquare());
    }
}
