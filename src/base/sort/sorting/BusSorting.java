package base.sort.sorting;

import base.dataclasses.Bus;
import base.sort.SortStrategy;
import base.sort.containers.DynamicArray;
import base.sort.comparators.*;
import base.sort.containers.ContainersUtils;


public class BusSorting implements SortStrategy{

    @Override
    public void sorting1(DynamicArray array) {

        ContainersUtils.selectionSort((Bus[]) array.getArray(), new BusComparator());

        System.out.println("Bus");
    }

    @Override
    public void sorting2() {

    }
}
