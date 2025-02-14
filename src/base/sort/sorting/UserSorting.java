package base.sort.sorting;


import base.dataclasses.User;
import base.sort.containers.DynamicArray;
import base.sort.comparators.*;
import base.sort.containers.ContainersUtils;
import base.sort.SortStrategy;


public class UserSorting implements SortStrategy {

    @Override
    public <T> void sorting1(DynamicArray<T> array) {

        ContainersUtils.selectionSort((User[]) array.getArray(), new UserComparator());

        System.out.println("User");
    }

    @Override
    public void sorting2() {
        System.out.println("У User нет данной сортировки");
    }
}
