package base.sort.sorting;

import base.dataclasses.Bus;
import base.sort.SortStrategy;
import base.sort.containers.DynamicArray;
import base.sort.comparators.*;
import base.sort.containers.ContainersUtils;


public class BusSorting implements SortStrategy{

    @Override
    public <T> void sorting1(DynamicArray<T> array) {

        ContainersUtils.selectionSort((Bus[]) array.getArray(), new BusComparator());

        System.out.println("Bus");
    }

    @Override
    public void sorting2() {
        // ContainersUtils.customSortBus(array);
    }
}
