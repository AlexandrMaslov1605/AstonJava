package base.sort;

import base.sort.containers.DynamicArray;
import base.sort.sorting.BusSorting;
import base.sort.sorting.StudentSorting;
import base.sort.sorting.UserSorting;


public class SortService {

    SortStrategy sortStrategy;

    public void setStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void UseServiceSort(String className) {
        switch (className) {
            case "Bus":
                this.setStrategy(new BusSorting());
                break;
            case "Student":
                this.setStrategy(new StudentSorting());
                break;
            case "User":
                this.setStrategy(new UserSorting());
                break;
            default:
                System.out.println("Неизвестный класс");
                return;
        }
    }

    public <T> void startStrategy(DynamicArray<T> array){

        if (sortStrategy != null) {
            sortStrategy.sorting1(array);
        } else {
            System.out.println("Вид сортировки не установлен");
        }

    }



}
