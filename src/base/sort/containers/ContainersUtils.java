package base.sort.containers;
import base.dataclasses.Bus;

import java.util.Comparator;

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

    public static void customSort(DynamicArray<Bus> array) {
        int n = array.getSize();
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            if (array.getElement(i).getMileage() % 2 != 0) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                // В цикле находим реальный номер ячейки с минимальным значением
                minIdx = array.getElement(j).getMileage() < array.getElement(minIdx).getMileage() ? j : minIdx;
            }

            if (i != minIdx) {
                Bus temp = array.getElement(i);
                array.set(i, array.getElement(minIdx));
                array.set(minIdx, temp);
            }
        }
    }
}
