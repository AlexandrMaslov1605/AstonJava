import Containers.DynamicArray;

import java.io.*;

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

            System.out.println("Выберите класс для заполнения массива:\n1) Автобус(Bus) \n2) Пользователь(User) \n3) Студент(Student)");

            //Выбор класса

            Select select = new Select();
            dynamicArray = select.createArrayOfClasses(arraySize,dynamicArray, bufferedReaderHand);

            jobClass = select.getJobClass();



            // Выбор способа заполнения

            System.out.println("Выберите способ заполнения массива: \n1) Вручную(Hands) \n2) Из файла(File) \n3) Рандомно(Random)");

            fillingMethod = select.chooseTheInput(fillingMethod, bufferedReaderHand);

            //Здесь будут реализованы методы заполнения массива
            Records records = new Records();
            
            switch(fillingMethod) {
                case "Hands" ->  records.handsRecord(dynamicArray, jobClass);
                case "File" -> records.fileRecord(dynamicArray, jobClass);
                case "Random" -> records.randomRecord(dynamicArray, jobClass);
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
            

            //записываем в файл
            WriteToFile writter = new WriteToFile();
            while (true)
                {
                    System.out.println("Введить путь до файла");
                //String fileName = buff.readLine();
                   
                    if (WriteToFile.writeToFileFunc("src/test.txt", dynamicArray)) break;
                    
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

