package base.dataclasses;

import base.sort.containers.DynamicArray;

import java.io.*;
import java.util.Random;

public class Records {
    private DynamicArray dynamicArray;
    private String value1;
    private String value2;
    private String value3;
    private final String[] name = new String[]{
            "Дмитрий", "Олег", "Евгений", "Александр", "Анна", "Анастасия", "Пётр", "Иван",
            "Денис", "Даниил", "Татьяна", "Юлия", "Николай", "Екатерина", "Ирина", "Михаил",
            "Дарья", "Инна", "Никита", "Сергей", "Светлана", "Евгения", "Игнат", "Алексей",
            "Владислав", "Константин", "Глеб", "Надежда", "Юрий", "Артём"
    };

    private final String[] alphabetThisNumber = new String[]{
            "А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"
    };

    private final String[] busModel = new String[]{
            "Mercedes", "Peugeot", "Renault", "ПАЗ", "Газель", "ЛИАЗ", "Citroen"
    };

    private final String[] simbolPassword = new String[]{
            "!", "@", "#", "$", "%", "&", "?", "(", ")", "-", "=", "+", "q",
            "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f",
            "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m", "Q",
            "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F",
            "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"
    };
    private final char[] abcCyr = {
            'а', 'б', 'в', 'г', 'д',
            'е', 'ё', 'ж', 'з', 'и', 'й',
            'к', 'л', 'м', 'н', 'о', 'п', 'р',
            'с', 'т', 'у', 'ф', 'х', 'ц', 'ч',
            'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
    };
    private final String[] abcLat = {
            "a", "b", "v", "g", "d", "e", "e",
            "zh", "z", "i", "y", "k", "l", "m", "n",
            "o", "p", "r", "s", "t", "u", "f", "h",
            "ts", "ch", "sh", "sch", "", "i", "",
            "e", "ju", "ja"
    };

    private final String[] emailHost = new String[]{
            "@mail.ru", "@bk.ru", "@yandex.ru", "gmail.com", "@vk.ru"
    };


    public DynamicArray handsRecord(BufferedReader bufferedReaderHand, DynamicArray dynamicArray, String jobClass) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        switch (jobClass) {
            case "Bus" -> {
                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    System.out.println("Введите номер автобуса" + (i + 1) + " :");
                    value1 = bufferedReader.readLine();
                    System.out.println("Введите модель автобуса " + (i + 1) + " :");
                    value2 = bufferedReader.readLine();
                    System.out.println("Введите пробег автобуса " + (i + 1) + " :");

                    boolean flagMileage = false;
                    while (!flagMileage) {
                        value3 = bufferedReader.readLine();
                        try {
                            dynamicArray.set(i, new Bus.BusBuilder().setNumber(value1).setModel(value2).setMileage(Integer.parseInt(value3)).build());
                            flagMileage = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Пробег состоит только из числа. Повторно укажите пробег:");
                        }
                    }
                }
            }
            case "User" -> {
                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    System.out.println("Введите имя пользователя " + (i + 1) + " :");
                    value1 = bufferedReader.readLine();
                    System.out.println("Введите пароль пользователя " + (i + 1) + " :");
                    value2 = bufferedReader.readLine();
                    System.out.println("Введите почту пользоавтеля " + (i + 1) + " :");
                    boolean flagMail = false;
                    while (!flagMail) {
                        try {
                            value3 = bufferedReader.readLine();
                            if (value3.contains("@")) {
                                dynamicArray.set(i, new User.UserBuilder().setName(value1).setPassword(value2).setMail(value3).build());
                                flagMail = true;
                            } else {
                                throw new NullPointerException();
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Указан некорректный адрес электронной почты. Повторит ввод:");
                        }
                    }
                }
            }
            case "Student" -> {
                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    Double gpa = 0.0;
                    Integer recordNumber = 0;
                    System.out.println("Введите номер группы студента " + (i + 1) + " :");
                    value1 = bufferedReader.readLine();
                    System.out.println("Введите средний балл студента " + (i + 1) + " :");
                    boolean flagGPA = false;
                    while (!flagGPA) {
                        value2 = bufferedReader.readLine();
                        try {
                            gpa = Double.parseDouble(value2);
                            flagGPA = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Неправильно указан средний балл, повторите ввод:");
                        }
                    }
                    System.out.println("Введите номер зачётной книжки " + (i + 1) + " :");
                    boolean flagRecordNumber = false;
                    while (!flagRecordNumber) {
                        value3 = bufferedReader.readLine();
                        try {
                            recordNumber = Integer.parseInt(value3);
                            flagRecordNumber = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Пробег состоит только из числа. Повторно укажите пробег:");
                        }
                    }
                    dynamicArray.set(i, new Student.StudentBuilder().setGroupNumber(value1).setGpa(gpa).setRecordNumber(recordNumber).build());
                }
            }
        }
        return this.dynamicArray = dynamicArray;
    }

    public DynamicArray fileRecord(BufferedReader bufferedReaderHand, DynamicArray dynamicArray, String jobClass) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path;
        Integer flag = 0;
        System.out.println("Укажите путь");
        boolean flagPath = false;
        while (!flagPath) {
            path = bufferedReader.readLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line = reader.readLine();

                while ((flag < dynamicArray.getSize())) {
                    if (line != null) {
                        String[] words = line.split(" ");
                        value1 = words[0];
                        value2 = words[1];
                        value3 = words[2];
                        switch (jobClass) {
                            case "Bus" ->
                                    dynamicArray.set(flag, new Bus.BusBuilder().setNumber(value1).setModel(value2).setMileage(Integer.parseInt(value3)).build());
                            case "User" ->
                                    dynamicArray.set(flag, new User.UserBuilder().setName(value1).setPassword(value2).setMail(value3).build());
                            case "Student" ->
                                    dynamicArray.set(flag, new Student.StudentBuilder().setGroupNumber(value1).setGpa(Double.parseDouble(value2)).setRecordNumber(Integer.parseInt(value3)).build());

                        }
                        line = reader.readLine();
                    } else {
                        switch (jobClass) {
                            case "Bus" -> {
                                dynamicArray.set(flag, new Bus.BusBuilder().setNumber("0").setModel("0").setMileage(0).build());
                            }
                            case "User" -> {
                                dynamicArray.set(flag, new User.UserBuilder().setName("0").setPassword("0").setMail("0").build());
                            }
                            case "Student" -> {
                                dynamicArray.set(flag, new Student.StudentBuilder().setGroupNumber("0").setGpa(0.0).setRecordNumber(0).build());
                            }
                        }
                    }
                    flag++;
                }
                flagPath = true;
            } catch (FileNotFoundException e) {
                System.out.println("Неверный путь к файлу. Повторите ввод.");
            }
        }
        return this.dynamicArray = dynamicArray;
    }

    public DynamicArray randomRecord(DynamicArray dynamicArray, String jobClass) throws IOException {
        Integer flag = 0;
        String line = "";

        while (flag < dynamicArray.getSize()) {
            switch (jobClass) {
                case "Bus" -> {
                    value1 = alphabetThisNumber[(int) (Math.random() * 11)] + (int) (Math.random() * 10) + (int) (Math.random() * 10)
                            + (int) (Math.random() * 10) + alphabetThisNumber[(int) (Math.random() * 11)] + alphabetThisNumber[(int) (Math.random() * 11)]
                            + (int) (Math.random() * 10) + (int) (Math.random() * 10);
                    value2 = busModel[(int) (Math.random() * 6)];
                    dynamicArray.set(flag, new Bus.BusBuilder().setNumber(value1).setModel(value2).setMileage((int) (Math.random() * 500000)).build());
                }
                case "User" -> {
                    line = "";
                    value1 = name[(int) (Math.random() * 30)];
                    for (int i = 0; i < 8; i++) {
                        line += simbolPassword[(int) (Math.random() * 64)];
                    }
                    value2 = line;
                    line = "";
                    for (int i = 0; i < value1.length(); i++) {
                        for (int j = 0; j < abcCyr.length; j++) {
                            if (value1.toLowerCase().charAt(i) == abcCyr[j])
                                line += abcLat[j];
                        }
                    }
                    value3 = line + (int) (Math.random() * 2025) + emailHost[(int) (Math.random() * 5)];
                    dynamicArray.set(flag, new User.UserBuilder().setName(value1).setPassword(value2).setMail(value3).build());
                }
                case "Student" -> {
                    String str = String.valueOf(abcCyr[(int) (Math.random() * 33)]).toUpperCase();
                    while ((str.equals("Ъ")) || (str.equals("Ь"))
                            || (str.equals("Ы"))
                            || (str.equals("Ё"))){
                        str = String.valueOf(abcCyr[(int) (Math.random() * 33)]).toUpperCase();
                         }

                            value1 = (int) (Math.random() * 99) + str + "-" + (int) (Math.random() * 4 + 1);

                    Random random = new Random();
                    Double randomGpa = (random.nextFloat() * 3.0) + 2.0;
                    Double randomGpaWrite = (double) Math.round(randomGpa * 100) / 100;
                    dynamicArray.set(flag, new Student.StudentBuilder().setGroupNumber(value1).setGpa(randomGpaWrite).setRecordNumber((int) (Math.random() * 50000000)).build());
                }
            }
            flag++;
        }


        return this.dynamicArray = dynamicArray;
    }
}