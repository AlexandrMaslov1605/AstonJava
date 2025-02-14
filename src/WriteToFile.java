import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;

import Containers.DynamicArray;

import java.nio.charset.StandardCharsets;

public class WriteToFile<T> {
    /**
     * Записывает в указанную папку @param fileName ,
     * если она существует, поля элементов из
     * 
     * @param items - динамического массива,
     *              если массив содержит люой из трех классов (Bus, User, Student).
     * 
     *              Возвращает true если запись прошла успешно
     *              false если не получилось получить доступ к файлу
     *              false если в переданном массиве были элементы не классов (Bus,
     *              User, Student)
     */
    public static boolean writeToFileFunc(String fileName, DynamicArray items) {
        
        if (!Files.exists(Paths.get(fileName)))
            return false;

        StringBuilder line = new StringBuilder();
        line.append("\n----------------------------------------------\n");

        for (int i = 0; i < items.getSize(); i++) {
            if (items.getElement(i) instanceof Bus) {
                Bus bus = (Bus) items.getElement(i);
                line.append(String.format("State number of bus: %-10s Bus model: %-15s Car mileage: %-9d\n",
                        bus.getNumber(), bus.getModel(), bus.getMileage()));
            } else if (items.getElement(i) instanceof Student) {
                Student student = (Student) items.getElement(i);
                line.append(String.format("Group number: %-10s Average score: %-5.2f Matriculation number: %-15s\n",
                        student.getGroupNumber(), student.getGpa(), student.getRecordNumber()));
            } else if (items.getElement(i) instanceof User) {
                User user = (User) items.getElement(i);
                line.append(String.format("User name: %-15s Password: %-16s E-mail: %-15s\n",
                        user.getName(), user.getPassword(), user.getMail()));
            } else {
                System.out.println("Use writeToFile only with classes Bus, Student, User");
                return false;
            }

        }
        line.append("\n----------------------------------------------");

        // если будет очень много записей в стрингбилдер, он может выкинуть
        // outOfMemmoryError
        // нужно ли обрабатывать эту ошибку но мы знаем что такой ситуаци НЕ будет
        // поэтому все строки
        // сначала аккумулируется в stringBuilder
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.append(line.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("You may not have access rights to this file.");
            return false;
        }

        return true;
    }

    /**
     * Записывает в указанную папку @param fileName ,
     * если она существует, поля элементов из
     * 
     * @param bus     - объект класс Bus
     * @param user    - объект класс user
     * @param student - объект класс student
     * 
     *                Возвращает true если запись прошла успешно
     *                false если не получилось получить доступ к файлу
     */
    public static boolean writeToFileFunc(String fileName, Bus bus) {
        if (Files.exists(Paths.get(fileName))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.append("\n-----------Finded Bus -------------------\n");

                String line = new String();
                line = String.format("State number of bus: %-10s Bus model: %-15s Car mileage: %-9d\n",
                        bus.getNumber(), bus.getModel(), bus.getMileage());

                writer.append(line);

                writer.append("\n----------------------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("You may not have access rights to this file.");
                return false;
            }
            return true;
        }

        else
            return false;
    }

    public static boolean writeToFileFunc(String fileName, User user) {
        if (Files.exists(Paths.get(fileName))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.append("\n-----------Finded User -------------------\n");

                String line = new String();
                line = String.format("User name: %-15s Password: %-16d E-mail: %-15s\n",
                        user.getName(), user.getPassword(), user.getMail());

                writer.append(line);

                writer.append("\n----------------------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("You may not have access rights to this file.");
                return false;
            }
            return true;
        }

        else
            return false;
    }

    public static boolean writeToFileFunc(String fileName, Student student) {
        if (Files.exists(Paths.get(fileName))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.append("\n-----------Finded Student -------------------\n");

                String line = new String();
                line = String.format("Group number: %-10s Average score: %-5.2f Matriculation number: %-15s\n",
                        student.getGroupNumber(), student.getGpa(), student.getRecordNumber());

                writer.append(line);

                writer.append("\n----------------------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("You may not have access rights to this file.");
                return false;
            }
            return true;
        }

        else
            return false;
    }

}
