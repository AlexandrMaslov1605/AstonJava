package base.sort;

import base.dataclasses.Bus;
import base.sort.containers.DynamicArray;

public interface SortStrategy {

    public <T> void sorting1(DynamicArray<T> array);

    public void sorting2();

}
