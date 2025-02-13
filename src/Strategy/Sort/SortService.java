package Strategy.Sort;

public class SortService {

    SortStrategy sortStrategy;

    public void setStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void startStrategy(){

        if (sortStrategy != null){
            if (sortStrategy != null) {
                sortStrategy.sorting1();
            }
            else {
                System.out.println("Вид сортировки не установлен");
            }
        }

    }

}
