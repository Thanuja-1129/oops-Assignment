
import java.util.*;

public class DrivingWork {
	public static void main(String[] args) {
  int totalMiles;
  int gallon_of_gasoline;
  int average_fees_per_day;
  int tolls_per_day;
  Scanner input =new Scanner(System.in);
  System.out.println("totalMiles :");
  totalMiles=input.nextInt();  
  System.out.println("gallon_of_gasoline :");
  gallon_of_gasoline=input.nextInt();
  System.out.println("average_fees_per_day :");
  average_fees_per_day=input.nextInt();
  System.out.println("tolls_per_day :");
  tolls_per_day=input.nextInt();
  int cost=totalMiles*gallon_of_gasoline+average_fees_per_day+tolls_per_day;
  System.out.println("Cost Per Day="+cost);

}}
