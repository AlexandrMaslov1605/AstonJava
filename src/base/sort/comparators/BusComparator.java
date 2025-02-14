package base.sort.comparators;

import java.util.Comparator;
import base.dataclasses.*;

public class BusComparator implements Comparator<Bus> {
    @Override
    public int compare(Bus o1, Bus o2) {
        return o1.getModel().compareTo(o2.getModel());
    }
}