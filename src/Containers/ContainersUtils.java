package Containers;
import java.util.Comparator;
import static java.util.Collections.swap;

public class ContainersUtils {
    public static <T> void selectionSort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; ++i) {
            // Находим индекс наименьшего элемента в неотсортированной части массива
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                boolean b = comparator.compare(array[j], array[minIdx]) < 0;
                // В цикле находим реальный номер ячейки с минимальным значением
                minIdx = b ? j : minIdx;
            }
            if (i != minIdx) {
                T temp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = temp;
            }
        }
        }
    }
}
