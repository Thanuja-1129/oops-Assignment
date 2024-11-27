
import java.util.*;

public class ValidString {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        
        if (isPerfectString(inputString)) {
            System.out.println("The string is a perfect string.");
        } else {
            System.out.println("The string is not a perfect string.");
        }

        scanner.close();
    }

    
    public static boolean isPerfectString(String str) {
        ArrayList<Character> charSet = new ArrayList<>();

        for (char ch : str.toCharArray()) {
            if (charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }

        return true;
    }
}
