package base.sort.containers;

import java.util.Arrays;
import java.util.Optional;

public class BinarySearch {
    public static <T extends Comparable<T>> Optional<T> binarySearch(DynamicArray<T> list, T search) {
        Arrays.sort(list.getArray());

        int left = 0;
        int right = list.getSize() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = list.getElement(mid).compareTo(search);
            if (result == 0) {
                return Optional.of(list.getElement(mid));
            } else if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Optional.empty();
    }
}