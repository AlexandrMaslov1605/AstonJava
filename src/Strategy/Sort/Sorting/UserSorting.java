package Strategy.Sort.Sorting;

import Comparators.UserComparator;
import Containers.ContainersUtils;
import Containers.DynamicArray;
import Strategy.Sort.SortStrategy;

public class UserSorting implements SortStrategy {

    @Override
    public void sorting1(DynamicArray array) {

        ContainersUtils.selectionSort((User[]) array.getArray(), new UserComparator());

        System.out.println("User");
    }

    @Override
    public void sorting2() {
        System.out.println("У User нет данной сортировки");
    }
}
