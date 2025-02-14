package Strategy.Sort.Sorting;

import Comparators.BusComparator;
import Containers.ContainersUtils;
import Containers.DynamicArray;
import Strategy.Sort.SortStrategy;

public class BusSorting implements SortStrategy {

    @Override
    public void sorting1(DynamicArray array) {

        ContainersUtils.selectionSort((Bus[]) array.getArray(), new BusComparator());

        System.out.println("Bus");
    }

    @Override
    public void sorting2() {

    }
}
