import Containers.ContainersUtils;
import Containers.DynamicArray;

import java.io.*;
import java.util.Comparator;

public final class InteractionUtils {

    String yesOrNoSelection;
    String restartOrExitSelecton;
    String pathReader;
    String pathWriter;
    String classSelection;
    String fillingSelection;
    String sortingSelection;


   /* private InteractionUtils() {
        throw new UnsupportedOperationException();
    }*/

    public void interaction() throws IOException {

        BufferedReader bufferedReaderHand = new BufferedReader(new InputStreamReader(System.in));

        boolean repeat = true;


        while (repeat) {

            String jobClass = null;
            int arraySize;
            String fillingMethod = null;
            String sortingType = null;
            String yesOrNo = null;
            String restartOrExit = null;
            DynamicArray<Object> dynamicArray = null;


            // Указание размера массива
            System.out.println("Укажите размер массива:");

            try {
                arraySize = Integer.parseInt(bufferedReaderHand.readLine());
                if (arraySize <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Необходимо указать целое натуральное число.");
                continue;
            }

            System.out.println("Выберите класс для заполнения массива: Автобус(Bus), Пользователь(User), Студент(Student)");

            //Выбор класса

            while (jobClass == null) {
                classSelection = bufferedReaderHand.readLine();
                switch (classSelection) {
                    case "Bus", "bus" -> {
                        jobClass = "Bus";
                        dynamicArray = new DynamicArray<>(new Bus[arraySize]);
                    }
                    case "User", "user" -> {
                        jobClass = "User";
                        dynamicArray = new DynamicArray<>(new User[arraySize]);
                    }
                    case "Student", "student" -> {
                        jobClass = "Student";
                        dynamicArray = new DynamicArray<>(new Student[arraySize]);
                    }
                    default -> System.out.println("Такого класса нет! Повторите ввод.");
                }
            }

            // Выбор способа заполнения

            System.out.println("Выберите способ заполнения массива: Вручную(Hands), Из файла(File), Рандомно(Random).");

            while (fillingMethod == null) {
                fillingSelection = bufferedReaderHand.readLine();
                switch (fillingSelection) {
                    case "Hands", "hands" -> fillingMethod = "Hands";
                    case "File", "file" -> fillingMethod = "File";
                    case "Random", "random" -> fillingMethod = "Random";
                    default -> System.out.println("Такого способа нет! Повторите ввод.");
                }
            }

            //Здесь будут реализованы методы заполнения массива
            Records records = new Records();
            if (fillingMethod.equals("Hands")) {
                records.handsRecord(dynamicArray, jobClass);
            } else if (fillingMethod.equals("File")) {
                records.fileRecord(dynamicArray, jobClass);
            } else {
                records.randomRecord(dynamicArray, jobClass);
            }

            // Выводим заполненный массив

            if (jobClass.equals("Bus"))
                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    System.out.print(((Bus) dynamicArray.getElement(i)).getNumber() + " ");
                    System.out.print(((Bus) dynamicArray.getElement(i)).getModel() + " ");
                    System.out.print(((Bus) dynamicArray.getElement(i)).getMileage() + " ");
                    System.out.println();
                }
            if (jobClass.equals("User"))
                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    System.out.print(((User) dynamicArray.getElement(i)).getName() + " ");
                    System.out.print(((User) dynamicArray.getElement(i)).getPassword() + " ");
                    System.out.print(((User) dynamicArray.getElement(i)).getMail() + " ");
                    System.out.println();
                }
            if (jobClass.equals("Student"))
                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    System.out.print(((Student) dynamicArray.getElement(i)).getGroupNumber() + " ");
                    System.out.print(((Student) dynamicArray.getElement(i)).getGpa() + " ");
                    System.out.print(((Student) dynamicArray.getElement(i)).getRecordNumber() + " ");
                    System.out.println();
                }

            // Выбираем способ сортировки
            if (!jobClass.equals("User")) {
                System.out.println("Выберите метод сортировки: 1 - \"Сортировка выбором\"; 2 - Кастомная сортировка.");
                sortingSelection = bufferedReaderHand.readLine();
                while (sortingType == null) {

                    if (sortingSelection.equals("1")) {
                        sortingType = "1";
                    } else if (sortingSelection.equals("2")) {
                        sortingType = "2";
                    } else {
                        System.out.println("Введите номер который соответсвует выбранному виду сортировки.");
                        sortingSelection = bufferedReaderHand.readLine();
                    }
                }
            } else {
                System.out.println("Массив с объектами класса User будет отсортирован согласно алгоритму - \"Сортировка выбором\".");
            }

            // Выводим отсортированный массив
            class BusComparator implements Comparator<Bus> {
                @Override
                public int compare(Bus o1, Bus o2) {
                    return o1.getModel().compareTo(o2.getModel());
                }
            }


            ContainersUtils.selectionSort((Bus[]) dynamicArray.getArray(), new BusComparator());

            for (int i = 0; i < dynamicArray.getSize(); i++) {
                System.out.print(((Bus) dynamicArray.getElement(i)).getNumber() + " ");
                System.out.print(((Bus) dynamicArray.getElement(i)).getModel() + " ");
                System.out.print(((Bus) dynamicArray.getElement(i)).getMileage() + " ");
                System.out.println();
            }
            //Выбираем осуществлять поиск по отсортированному массиву или нет
            System.out.println("Осуществить поиск по массиву? Да/Нет");
            yesOrNoSelection = bufferedReaderHand.readLine();
            while (yesOrNo == null) {
                if (yesOrNoSelection.equals("Да")) {
                    yesOrNo = "Да";

                    //Реализация бинарного поиска с использованием дженериков

                    //Еали данные найдены предлагаем пользователю записать их в указанный файл
                    System.out.println("Укажите путь к файлу для записи:");
                    pathWriter = bufferedReaderHand.readLine();
                    try {
                        BufferedReader bufferedReaderFile = new BufferedReader(new FileReader(pathWriter));
                    } catch (FileNotFoundException e) {
                        System.out.println("Файл не найден, повторите ввод.");
                    }
                } else if (yesOrNoSelection.equals("Нет")) {
                    yesOrNo = "Нет";
                    System.out.println("Если хотите заполнить новый массив напишите - Рестарт.\n" +
                            "Для завершения программы напишите - Выход");
                    restartOrExitSelecton = bufferedReaderHand.readLine();
                    while (restartOrExit == null) {
                        if (restartOrExitSelecton.equals("Рестарт")) {
                            restartOrExit = "Рестарт";
                        } else if (restartOrExitSelecton.equals("Выход")) {
                            restartOrExit = "Выход";
                            repeat = false;
                        } else {
                            System.out.println("Напишите \"Рестарт\" или \"Выход\".");
                            restartOrExitSelecton = bufferedReaderHand.readLine();
                        }
                    }
                } else {
                    System.out.println("Введита либо \"Да\", либо \"Нет\".");
                    yesOrNoSelection = bufferedReaderHand.readLine();
                }
            }
        }
        bufferedReaderHand.close();
    }
}
