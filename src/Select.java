import Containers.DynamicArray;
import java.io.*;

public class Select {
    public static DynamicArray createArrayOfClasses(BufferedReader bufferedReaderHand, int arraySize, DynamicArray dynamicArray){

        
            try {
                while (dynamicArray.getSize() == 0){
                String classSelection = bufferedReaderHand.readLine();
                if (classSelection.equals("Bus") || classSelection.equals("bus") || classSelection.equals("1")) {
                    dynamicArray = new DynamicArray<>(new Bus[arraySize]);
                } else if (classSelection.equals("User") || classSelection.equals("user") || classSelection.equals("2")) {
                    dynamicArray = new DynamicArray<>(new User[arraySize]);
                } else if (classSelection.equals("Student") || classSelection.equals("student")|| classSelection.equals("3")) {
                    dynamicArray = new DynamicArray<>(new Student[arraySize]);
                } else {
                    System.out.println("Такого класса нет! Повторите ввод.");
                }
            }
            
        } catch (IOException e) {
                e.printStackTrace();
            }
            

        return dynamicArray;
    }


}
