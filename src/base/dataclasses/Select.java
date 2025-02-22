package base.dataclasses;

import base.sort.containers.DynamicArray;

import java.io.*;


public class Select {
    private String jobClass = null;

    public DynamicArray createArrayOfClasses(int arraySize, DynamicArray dynamicArray, BufferedReader buffer) {
        try {
            while (dynamicArray == null) {
                String classSelection = buffer.readLine();

                switch (classSelection) {
                    case "Bus":
                    case "bus":
                    case "1":
                        dynamicArray = new DynamicArray<>(new Bus[arraySize]);
                        this.jobClass = "Bus";
                        break;
                    case "User":
                    case "user":
                    case "2":
                        dynamicArray = new DynamicArray<>(new User[arraySize]);
                        this.jobClass = "User";
                        break;
                    case "Student":
                    case "student":
                    case "3":
                        dynamicArray = new DynamicArray<>(new Student[arraySize]);
                        this.jobClass = "Student";
                        break;
                    default:
                        System.out.println("Такого класса нет! Повторите ввод.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dynamicArray;
    }

    public String getJobClass() {
        return this.jobClass;
    }

    public String chooseTheInput(String fillingMethod, BufferedReader buffer) throws IOException {

        while (fillingMethod == null) {
            String fillingSelection = buffer.readLine();
            switch (fillingSelection) {
                case "Hands", "hands", "1" -> fillingMethod = "Hands";
                case "File", "file", "2" -> fillingMethod = "File";
                case "Random", "random", "3" -> fillingMethod = "Random";
                default -> System.out.println("Такого способа нет! Повторите ввод.");
            }
        }
        return fillingMethod;
    }

    public void arrayOutput(DynamicArray dynamicArray) {

        for (int i = 0; i < dynamicArray.getSize(); i++) {
            System.out.print(dynamicArray.getElement(i).toString());
            System.out.println();
        }
        System.out.println();
    }

    public int inputArraySize(BufferedReader bufferedReaderHand) throws IOException {
        int arraySize;
        while (true) {
            try {
                arraySize = Integer.parseInt(bufferedReaderHand.readLine());
                if (arraySize <= 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо указать целое натуральное число.");
            }
        }
        return arraySize;
    }

    // public void serchInArray(){
    //     while (yesOrNo == null) {

    //         yesOrNoSelection = bufferedReaderHand.readLine();
    //         if (yesOrNoSelection.equals("Да")) {
    //             yesOrNo = "Да";

    //             //Реализация бинарного поиска с использованием дженериков

    //             //Еcли данные найдены предлагаем пользователю записать их в указанный файл
    //             System.out.println("Укажите путь к файлу для записи:");
    //             pathWriter = bufferedReaderHand.readLine();

    //             while (!Files.exists(Paths.get(pathWriter))){
    //                 System.out.println("Указанного файла не существует укажите другой:");
    //                 pathWriter = bufferedReaderHand.readLine();
    //             }


    //         } else if (yesOrNoSelection.equals("Нет")) {
    //             yesOrNo = "Нет";
    //             System.out.println("Если хотите заполнить новый массив напишите - Рестарт.\n" +
    //                     "Для завершения программы напишите - Выход");
    //             restartOrExitSelecton = bufferedReaderHand.readLine();
    //             while (restartOrExit == null) {
    //                 if (restartOrExitSelecton.equals("Рестарт")) {
    //                     restartOrExit = "Рестарт";
    //                     repeat = true;
    //                 } else if (restartOrExitSelecton.equals("Выход")) {
    //                     restartOrExit = "Выход";
    //                     repeat = false;
    //                 } else {
    //                     System.out.println("Напишите \"Рестарт\" или \"Выход\".");
    //                     restartOrExitSelecton = bufferedReaderHand.readLine();
    //                 }
    //             }
    //         } else {
    //             System.out.println("Введита либо \"Да\", либо \"Нет\".");
    //         }
    // }}
}
