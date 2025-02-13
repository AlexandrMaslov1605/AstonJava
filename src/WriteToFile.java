import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;

import Containers.DynamicArray;

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
                line.append(String.format("Гос.номер автобуса: %-10s Модель машины: %-15s Пробег машины: %-9d\n",
                        bus.getNumber(), bus.getModel(), bus.getMileage()));
            } else if (items.getElement(i) instanceof Student) {
                Student student = (Student) items.getElement(i);
                line.append(String.format("Номер группы: %-10s Срдений балл: %-3.2f Номер зачет. книжки %-15s\n",
                        student.getGroupNumber(), student.getGpa(), student.getRecordNumber()));
            } else if (items.getElement(i) instanceof User) {
                User user = (User) items.getElement(i);
                line.append(String.format("Имя пользователя: %-15s Пароль: %-16d E-mail: %-15s\n",
                        user.getName(), user.getPassword(), user.getMail()));
            } else {
                System.out.println("Изпользуйте writeToFile только с классами Bus, Student, User");
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
            System.out.println("Возможно у вас нет прав к этому файлу");
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
                writer.append("\n-----------Найденный Bus -------------------\n");

                String line = new String();
                line = String.format("Гос.номер автобуса: %-10s Модель машины: %-15s Пробег машины: %-9d\n",
                        bus.getNumber(), bus.getModel(), bus.getMileage());

                writer.append(line);

                writer.append("\n----------------------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Возможно у вас нет прав доступа к этому файлу");
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
                writer.append("\n-----------Найденный User -------------------\n");

                String line = new String();
                line = String.format("Имя пользователя: %-15s Пароль: %-16d E-mail: %-15s\n",
                        user.getName(), user.getPassword(), user.getMail());

                writer.append(line);

                writer.append("\n----------------------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Возможно у вас нет прав доступа к этому файлу");
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
                writer.append("\n-----------Найденный Student -------------------\n");

                String line = new String();
                line = String.format("Номер группы: %-10s Срдений балл: %-3.2f Номер зачет. книжки %-15s\n",
                        student.getGroupNumber(), student.getGpa(), student.getRecordNumber());

                writer.append(line);

                writer.append("\n----------------------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Возможно у вас нет прав доступа к этому файлу");
                return false;
            }
            return true;
        }

        else
            return false;
    }

}
