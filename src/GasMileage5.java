
import java.util.*;

public class GasMileage5 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double totalMiles = 0;
        double totalGallons = 0;
        double milesDriven, gallonsUsed;
        
        while (true) {
            System.out.print("Enter miles driven (-1 to quit): ");
            milesDriven = scanner.nextDouble();
            
            if (milesDriven == -1) {
                break;  
            }
            System.out.print("Enter gallons used: ");
            gallonsUsed = scanner.nextDouble();
            
            double tripMPG = milesDriven / gallonsUsed;
            System.out.printf("Miles per gallon for this trip: %.2f%n", tripMPG);
            
            totalMiles += milesDriven;
            totalGallons += gallonsUsed;
            
            double combinedMPG = totalMiles / totalGallons;
            System.out.printf("Combined miles per gallon for all trips: %.2f%n", combinedMPG);
        }
        
      
      
        
        System.out.println("calculator got ended");
        }
        }


