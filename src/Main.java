import Containers.DynamicArray;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReaderHand = new BufferedReader(new InputStreamReader(System.in));
        String classSelection;
        String fillingSelection;
        String sortingSelection;
        String yesOrNoSelection;
        String restartOrExitSelecton;
        Boolean repeat = true;
        String pathReader;
        String pathWriter;

        while (repeat) {

            String jobClass = null;
            String fillingMethod = null;
            Integer arraySize = 0;
            String sortingType = null;
            String yesOrNo = null;
            String restartOrExit = null;
            DynamicArray<Object> dynamicArray = null;

            // Указание размера массива

            System.out.println("Укажите размер массива:");

            //while (arraySize <= 0) {
            try {
                arraySize = Integer.parseInt(bufferedReaderHand.readLine());
                if (arraySize <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Необходимо указать целое натуральное число.");
                continue;
            }
            // }

            System.out.println("Выберите класс для заполнения массива: Автобус(Bus), Пользователь(User), Студент(Student)");
            //Выбор класса

            while (jobClass == null) {
                classSelection = bufferedReaderHand.readLine();
                if (classSelection.equals("Bus") || classSelection.equals("bus")) {
                    jobClass = "Bus";
                    dynamicArray = new DynamicArray<>(new Bus[arraySize]);
                } else if (classSelection.equals("User") || classSelection.equals("user")) {
                    jobClass = "User";
                    dynamicArray = new DynamicArray<>(new User[arraySize]);
                } else if (classSelection.equals("Student") || classSelection.equals("student")) {
                    jobClass = "Student";
                    dynamicArray = new DynamicArray<>(new Student[arraySize]);
                } else {
                    System.out.println("Такого класса нет! Повторите ввод.");
                }

            }

            // Выбор способа заполнения

            System.out.println("Выберите способ заполнения массива: Вручную(Hands), Из файла(File), Рандомно(Random).");

            while (fillingMethod == null) {
                fillingSelection = bufferedReaderHand.readLine();
                if (fillingSelection.equals("Hands") || fillingSelection.equals("hands")) {
                    fillingMethod = "Hands";
                } else if (fillingSelection.equals("File") || fillingSelection.equals("file")) {
                    fillingMethod = "File";
                    //BufferedReader bufferedReaderFile = new BufferedReader(new FileReader(pathReader));
                } else if (fillingSelection.equals("Random") || fillingSelection.equals("random")) {
                    fillingMethod = "Random";
                } else {
                    System.out.println("Такого способа нет! Повторите ввод.");
                }
            }


            //Здесь будут реализованы методы заполнения массива

            if (jobClass.equals("Bus") && fillingMethod.equals("Hands")) {

                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    System.out.println("Введите номер автобуса " + (i + 1) + " :");
                    String busNumber = bufferedReaderHand.readLine();
                    System.out.println("Введите модель автобуса: " + (i + 1) + " :");
                    String modelBus = bufferedReaderHand.readLine();
                    System.out.println("Введите пробег автобуса " + (i + 1) + " :");
                    try {
                        Integer mileageBus = Integer.parseInt(bufferedReaderHand.readLine());
                        dynamicArray.set(i, new Bus.BusBuilder().setNumber(busNumber).setModel(modelBus).setMileage(mileageBus).build());
                    } catch (NumberFormatException e) {
                        System.out.println("Пробег автобуса может содержать только натуральное число. Повторите ввод параметров.");
                        i -= 1;
                    }
                }
            }
            // Выводим заполненный массив
            if (jobClass.equals("Bus"))
                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    System.out.print(((Bus)dynamicArray.getElement(i)).getNumber() + " ");
                    System.out.print(((Bus)dynamicArray.getElement(i)).getModel() + " ");
                    System.out.print(((Bus)dynamicArray.getElement(i)).getMileage() + " ");
                    System.out.println();
                }
            // Выбираем способ сортировки

            if (!jobClass.equals("User")) {
                System.out.println("Выберите метод сортировки: 1 - \"Сортировка выбором\"; 2 - Кастомная сортировка.");

                while (sortingType == null) {
                    sortingSelection = bufferedReaderHand.readLine();
                    if (sortingSelection.equals("1")) {
                        sortingType = "1";
                    } else if (sortingSelection.equals("2")) {
                        sortingType = "2";
                    } else {
                        System.out.println("Введите номер который соответсвует выбранному виду сортировки.");
                    }
                }
            } else {
                System.out.println("Массив с объектами класса User будет отсортирован согласно алгоритму - \"Сортировка выбором\".");
            }

            // Выводим отсортированный массив

            //Выбираем осуществлять поиск по отсортированному массиву или нет

            System.out.println("Осуществить поиск по массиву? Да/Нет");

            while (yesOrNo == null) {
                yesOrNoSelection = bufferedReaderHand.readLine();
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
                            repeat = true;
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
                }
            }
        }
        bufferedReaderHand.close();
    }
}
