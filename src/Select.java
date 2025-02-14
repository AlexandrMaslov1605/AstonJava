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

    public void arrayOutput(DynamicArray dynamicArray){
        switch(jobClass){
        case "Bus":
                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    System.out.print(((Bus) dynamicArray.getElement(i)).getNumber() + " ");
                    System.out.print(((Bus) dynamicArray.getElement(i)).getModel() + " ");
                    System.out.print(((Bus) dynamicArray.getElement(i)).getMileage() + " ");
                    System.out.println();
                }
                break;
        case "User":
                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    System.out.print(((User) dynamicArray.getElement(i)).getName() + " ");
                    System.out.print(((User) dynamicArray.getElement(i)).getPassword() + " ");
                    System.out.print(((User) dynamicArray.getElement(i)).getMail() + " ");
                    System.out.println();
                }
                break;
        case "Student":
                for (int i = 0; i < dynamicArray.getSize(); i++) {
                    System.out.print(((Student) dynamicArray.getElement(i)).getGroupNumber() + " ");
                    System.out.print(((Student) dynamicArray.getElement(i)).getGpa() + " ");
                    System.out.print(((Student) dynamicArray.getElement(i)).getRecordNumber() + " ");
                    System.out.println();
                }
                break;
    }
}

    public int inputArraySize(BufferedReader bufferedReaderHand) throws IOException{
        int arraySize;
        while(true){
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

}
