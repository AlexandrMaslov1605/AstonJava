import Containers.DynamicArray;

import java.io.*;
import java.util.Random;

public class Records {
    private DynamicArray dynamicArray;
    private String value1;
    private String value2;
    private String value3;


    public DynamicArray handsRecord(DynamicArray dynamicArray, String jobClass) throws IOException {

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
        bufferedReader.close();
        return this.dynamicArray = dynamicArray;
    }

    public DynamicArray fileRecord(DynamicArray dynamicArray, String jobClass) throws IOException {
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
                            case "Bus" -> {
                                dynamicArray.set(flag, new Bus.BusBuilder().setNumber(value1).setModel(value2).setMileage(Integer.parseInt(value3)).build());
                            }
                            case "User" -> {
                                dynamicArray.set(flag, new User.UserBuilder().setName(value1).setPassword(value2).setMail(value3).build());
                            }
                            case "Student" -> {
                                dynamicArray.set(flag, new Student.StudentBuilder().setGroupNumber(value1).setGpa(Double.parseDouble(value2)).setRecordNumber(Integer.parseInt(value3)).build());
                            }
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
        bufferedReader.close();
        return this.dynamicArray = dynamicArray;
    }

    public DynamicArray randomRecord(DynamicArray dynamicArray, String jobClass) throws IOException {
        Integer flag = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("randomFile.txt"))) {
            String line = reader.readLine();

            while (flag < dynamicArray.getSize()) {
                if (jobClass.equals(line)) {
                    line = reader.readLine();
                    while (line != null && !line.equals("Bus") && !line.equals("User") && !line.equals("Student") && flag < dynamicArray.getSize()) {
                        String[] words = line.split(" ");
                        switch (jobClass) {
                            case "Bus" -> {
                                value1 = words[0];
                                value2 = words[1];
                                dynamicArray.set(flag, new Bus.BusBuilder().setNumber(value1).setModel(value2).setMileage((int) (Math.random() * 500000)).build());
                            }
                            case "User" -> {
                                value1 = words[0];
                                value2 = words[1];
                                value3 = words[2];
                                dynamicArray.set(flag, new User.UserBuilder().setName(value1).setPassword(value2).setMail(value3).build());
                            }
                            case "Student" -> {
                                value1 = words[0];
                                Random random = new Random();
                                Double randomGpa = (random.nextFloat() * 3.0) + 2.0;
                                Double randomGpaWrite = (double) Math.round(randomGpa * 100) / 100;
                                dynamicArray.set(flag, new Student.StudentBuilder().setGroupNumber(value1).setGpa(randomGpaWrite).setRecordNumber((int) (Math.random() * 500000)).build());
                            }
                        }
                        line = reader.readLine();
                        flag++;
                    }
                } else {
                    if ((flag > 0) && (flag < dynamicArray.getSize())) {
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
                        flag++;
                    } else
                    line = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
        return this.dynamicArray = dynamicArray;
    }
}