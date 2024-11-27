
import java.util.Scanner;
public class TataMotorDealers {
	public static String category(String S) {
		switch (S.toUpperCase()) {
		case "SUV":
			return "TATA SAFARI";
		case "SEDAN":
			return "TATA INDIGO";
		case "ECONOMY":
			return "TATA INDICA";
		case "MINI":
			return "TATA NANO";
		default :
			return "not available";
		}
	}
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the category:");
		String c=sc.nextLine();
		String a=category(c);
		System.out.println("Available model:");
		System.out.println(a);
	}

}
