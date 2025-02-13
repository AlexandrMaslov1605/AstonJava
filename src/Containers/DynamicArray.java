package Containers;

public class DynamicArray<T> {
    private int size;
    private Object[] array;

    /**
     * Создаёт пустой массив с размером равному 1.
     */
    public DynamicArray() {
        size = 0;
        array = new Object[1];
    }

    /**
     * Создаёт пустой массив указанного размера.
     * @param capacity общее количество элементов,
     * которые массив может содержать без необходимости перераспределения.
     */
    public DynamicArray(int capacity) {
        size = 0;
        array = new Object[capacity];
    }

    /**
     * Создаёт динамический массив на основе обычного массива.
     * @param array
     */
    public DynamicArray(T[] array) {
        size = array.length;
        this.array = array.clone();
    }

    /**
     * @return Количество элементов в массиве.
     */
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    public T[] getArray() {
        // TODO: воспользоваться другим способом приведения?
        return (T[])array;
    }

    public T getElement(int index) {
        // TODO: воспользоваться другим способом приведения?
        return (T)array[index];
    }

    /**
     * Увеличивает или уменьшает ёмкость до значения, большего или меньшего newCapacity.
     * Если значение newCapacity меньше или равно нулю, то метод ничего не делает.
     * @param newCapacity общее количество элементов,
     * которые массив может содержать без необходимости перераспределения.
     */
    public void reserve(int newCapacity) {
        if (newCapacity <= 0) {
            // TODO: Вставить сообщение о том что метод ничего не сделал?
            return;
        }

        int count = 0;
        Object[] newArray = new Object[newCapacity];

        count = array.length < newCapacity ? newCapacity : array.length;

        System.arraycopy(array, 0, newArray, 0, count);
        array = newArray.clone();
    }

    /**
     * Добавляет указанный элемент в конец этого массива.
     * @param element Элемент, который нужно добавить в массив.
     */
     public void add(T element) {
        if (size == (array.length - 1)) {
            reserve(array.length * 2);
        }
            array[size++] = element;
     }

    /**
     * Удаляет все элементы из этого списка.
     */
     public  void clear() {
         array = new Object[array.length];
     }

    /**
     * Заменяет элемент в указанной позиции в этом массиве на указанный элемент.
     * @param index Индекс элемента, который нужно заменить.
     * @param element Элемент, на который нужно заменить.
     */
    public void set(int index, T element) {
        //TODO: или лучше копировать?
        if (index >= 0 && index < array.length) {
            array[index] = element;
        }
    }
}
