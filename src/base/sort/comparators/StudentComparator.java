package base.sort.comparators;

import java.util.Comparator;
import base.dataclasses.*;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGroupNumber().compareTo(o2.getGroupNumber());
    }
}
