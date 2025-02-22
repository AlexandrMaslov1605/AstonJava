package base.sort.sorting;


import base.dataclasses.Student;
import base.sort.SortStrategy;
import base.sort.containers.DynamicArray;
import base.sort.comparators.*;
import base.sort.containers.ContainersUtils;



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
