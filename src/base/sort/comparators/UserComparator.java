package base.sort.comparators;


import java.util.Comparator;
import base.dataclasses.*;


public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
