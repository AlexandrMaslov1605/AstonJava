package base;

import base.sort.SortService;
import base.sort.containers.DynamicArray;
import base.dataclasses.Records;
import base.dataclasses.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public final class InteractionUtils {

   /* private InteractionUtils() {
        throw new UnsupportedOperationException();
    }*/

    public void interaction() throws IOException {

        BufferedReader bufferedReaderHand = new BufferedReader(new InputStreamReader(System.in));
        String sortingSelection;
        String yesOrNoSelection;
        String restartOrExitSelecton;
        Boolean repeat = true;
        String pathWriter;

        while (repeat) {

            String jobClass = null;
            int arraySize;
            String fillingMethod = null;
            String sortingType = null;
            String yesOrNo = null;
            String restartOrExit = null;
            DynamicArray<Object> dynamicArray = null;

            Select select = new Select();

            // Указание размера массива
            System.out.println("Укажите размер массива:");

            arraySize = select.inputArraySize(bufferedReaderHand);

            //Выбор класса
            System.out.println("Выберите класс для заполнения массива:\n1) Автобус(Bus) \n2) Пользователь(User) \n3) Студент(Student)");
            dynamicArray = select.createArrayOfClasses(arraySize,dynamicArray, bufferedReaderHand);
            jobClass = select.getJobClass();



            // Выбор способа заполнения
            System.out.println("Выберите способ заполнения массива: \n1) Вручную(Hands) \n2) Из файла(File) \n3) Рандомно(Random)");
            fillingMethod = select.chooseTheInput(fillingMethod, bufferedReaderHand);

            //Заполнение массива
            Records records = new Records();

            switch(fillingMethod) {
                case "Hands" ->  records.handsRecord(bufferedReaderHand,dynamicArray, jobClass);
                case "File" -> records.fileRecord(bufferedReaderHand, dynamicArray, jobClass);
                case "Random" -> records.randomRecord(dynamicArray, jobClass);
            }

            // Выводим заполненный массив
            select.arrayOutput(dynamicArray);



            // Выбираем способ сортировки
            if (!jobClass.equals("User")) {
                System.out.println("Выберите метод сортировки: 1 - \"Сортировка выбором\"; 2 - Кастомная сортировка.");

                while (sortingType == null) {
                    sortingSelection = bufferedReaderHand.readLine();
                    if (sortingSelection.equals("1")) {
                        sortingType = "1";
                        SortService sortService = new SortService();
                        sortService.UseServiceSort(jobClass);
                        sortService.startStrategy(dynamicArray);
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
            select.arrayOutput(dynamicArray);
            //Выбираем осуществлять поиск по отсортированному массиву или нет

            System.out.println("Осуществить поиск по массиву? Да/Нет");


          /* //записываем в файл
            WriteToFile writter = new WriteToFile();
            while (true)
            {
                System.out.println("Введить путь до файла");
                String fileName = bufferedReaderHand.readLine();
                if (WriteToFile.writeToFileFunc(fileName, dynamicArray)) break;
            }*/


            while (yesOrNo == null) {
                yesOrNoSelection = bufferedReaderHand.readLine();
                if (yesOrNoSelection.equals("Да")) {
                    yesOrNo = "Да";

                    //Реализация бинарного поиска с использованием дженериков
                    /*if (jobClass.equals("Bus")){
                        Bus busSearch = new Bus.BusBuilder().setMileage(Integer.parseInt(bufferedReaderHand.readLine())).build();
                        System.out.println(BinarySearch.binarySearch(dynamicArray, busSearch);
                    }*/
                    //Еали данные найдены предлагаем пользователю записать их в указанный файл
                    System.out.println("Укажите путь к файлу для записи:");
                    pathWriter = bufferedReaderHand.readLine();

                    while (!Files.exists(Paths.get(pathWriter))){
                        System.out.println("Указанного файла не существует укажите другой:");
                        pathWriter = bufferedReaderHand.readLine();
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
