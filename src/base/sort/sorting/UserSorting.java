package base.sort.sorting;


import base.dataclasses.User;
import base.sort.containers.DynamicArray;
import base.sort.comparators.*;
import base.sort.containers.ContainersUtils;
import base.sort.SortStrategy;


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
