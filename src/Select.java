import Containers.DynamicArray;
import java.io.*;
import java.lang.classfile.instruction.SwitchCase;

public class Select {
    private String jobClass = null;

    public DynamicArray createArrayOfClasses( int arraySize, DynamicArray dynamicArray, BufferedReader buffer){    
        try {
            while (dynamicArray == null){
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
            }
        
        catch (IOException e) {
                e.printStackTrace();
        }
        return dynamicArray;
    }
    
    public String getJobClass(){
        return this.jobClass;
    }

    public String chooseTheInput(String fillingMethod, BufferedReader buffer) throws IOException{

        while (fillingMethod == null) {
            String fillingSelection = buffer.readLine();
            switch (fillingSelection) {
                case "Hands", "hands","1" -> fillingMethod = "Hands";
                case "File", "file" ,"2"-> fillingMethod = "File";
                case "Random", "random","3" -> fillingMethod = "Random";
                default -> System.out.println("Такого способа нет! Повторите ввод.");
            }
        }
        return fillingMethod;
    }
}
