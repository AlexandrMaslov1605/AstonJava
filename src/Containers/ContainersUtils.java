package Containers;
import java.util.Comparator;
import static java.util.Collections.swap;

public class ContainersUtils {
    public static <T> void selectionSort(T[] array, Comparator<T> comparator) {
        int minIndex;

        // Поочередно перемещаем границу несортированного подмассива
        for (int i = 0; i < array.length - 1; i++) {
            // Найти минимальный элемент в несортированном массиве
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (comparator.compare(array[j], array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Поменять найденный минимальный элемент на первый элемент
            swap(array[minIndex], array[i]);
        }
    }

    private static <T> void swap(T t, T t1) {
        T buffer;
        buffer = t;
        t = t1;
        t1 = (T) buffer;
    }
}
