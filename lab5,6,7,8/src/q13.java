package DrivingWork.java;

import java.util.Arrays;


class Half  {
    public int evaluate(int value) {
        return value / 2; 
    }
}

public class q13 {
    
    public static int[] processArray(int[] inputArray) {
         Half half = new Half();
        
        int[] resultArray = new int[inputArray.length];
        
        for (int i = 0; i < inputArray.length; i++) {
            resultArray[i] = half.evaluate(inputArray[i]);
        }
        
        return resultArray;
    }
    
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        int[] halvedNumbers = processArray(numbers);
        
        System.out.println("Original Array: " + Arrays.toString(numbers));
        System.out.println("Halved Array: " + Arrays.toString(halvedNumbers));
    }
}
