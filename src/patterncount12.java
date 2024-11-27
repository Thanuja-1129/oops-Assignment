
import java.util.*;

public class patterncount12 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the start of the range (a): ");
	        int a = scanner.nextInt();
	        System.out.print("Enter the end of the range (b): ");
	        int b = scanner.nextInt();
	        
	        System.out.print("Enter the pattern (n) to search: ");
	        String pattern = scanner.next();

	       
	        int count = 0;

	        
	        for (int i = a; i <= b; i++) {
	            
	            String numberStr = String.valueOf(i);

	            
	            int index = numberStr.indexOf(pattern);
	            while (index != -1) {
	                count++;
	                
	                index = numberStr.indexOf(pattern, index + 1);
	            }
	        }

	        // Output: Total count of the pattern in the range
	        System.out.println("The pattern '" + pattern + "' occurs " + count + " times between " + a + " and " + b + ".");
	        
	        scanner.close();
	    }
}
