package Strategy.Sort;

public class UserSorting implements SortStrategy{

    @Override
    public void sorting1() {
        System.out.println("User");
    }

    @Override
    public void sorting2() {
        System.out.println("У User нет данной сортировки");
    }
}
