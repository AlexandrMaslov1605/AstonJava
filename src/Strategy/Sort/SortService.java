package Strategy.Sort;

import Containers.DynamicArray;
import Strategy.Sort.Sorting.BusSorting;
import Strategy.Sort.Sorting.StudentSorting;
import Strategy.Sort.Sorting.UserSorting;

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

    public void startStrategy(DynamicArray array){

        if (sortStrategy != null){
            if (sortStrategy != null) {
                sortStrategy.sorting1(array);
            }
            else {
                System.out.println("Вид сортировки не установлен");
            }
        }

    }



}
