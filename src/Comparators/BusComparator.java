package Comparators;

import java.util.Comparator;

public class BusComparator implements Comparator<Bus> {
    @Override
    public int compare(Bus o1, Bus o2) {
        return o1.getModel().compareTo(o2.getModel());
    }
}