import java.util.HashMap;
import java.util.Scanner;
public class freq11 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String str = scanner.nextLine();

	        System.out.print("Enter a number n: ");
	        int n = scanner.nextInt();

	        HashMap<Character, Integer> freqMap = new HashMap<>();

	        for (char ch : str.toCharArray()) {
	            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
	        }

	        // Printing characters whose frequency exceeds 'n'
	        System.out.println("Characters appearing more than " + n + " times:");
	        for (char ch : freqMap.keySet()) {
	            if (freqMap.get(ch) > n) {
	                System.out.println("'"+ch +"'"+ " appears " + freqMap.get(ch) + " times.");
	            }
	        }

	        scanner.close();
	    }
	}


