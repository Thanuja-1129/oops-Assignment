
import java.util.*;
 class invoi{
	String number;
	String description;
	int quantity;
	int pricePiteam;
	invoi(String number,String description,int quantity,int pricePiteam){
		this.number=number;
		this.description=description;
		this.pricePiteam=pricePiteam;
		SetQuan(quantity);
		get();
		double a=CalculateInvoice();
		System.out.println("Invoice Amount"+ a);
		 
	}
	public void SetQuan(int quantity) {
		this.quantity=quantity;
	}
	public void get() {
		System.out.println("  number :"+ number + " description: " + description + "  quantity :"+ quantity +"  pricePiteam :"+pricePiteam);
	}
	public double CalculateInvoice() {
		if(pricePiteam<0 || quantity<0) {
			return 0;
		}
		return quantity*pricePiteam;
		
	}
	
}

public class invoice {
public static void main(String[] args) {
	
	invoi a=new invoi("u123","description s written here",5,15);
}
}

