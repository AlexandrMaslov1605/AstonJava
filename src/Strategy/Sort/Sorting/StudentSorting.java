package Strategy.Sort.Sorting;

import Comparators.StudentComparator;
import Containers.ContainersUtils;
import Containers.DynamicArray;
import Strategy.Sort.SortStrategy;

public class StudentSorting implements SortStrategy {

    @Override
    public void sorting1(DynamicArray array) {

        ContainersUtils.selectionSort((Student[])array.getArray(), new StudentComparator());

        System.out.println("Student");
    }


    @Override
    public void sorting2() {

    }
}
