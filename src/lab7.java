
class date{
	int month;
	int day;
	int year;
	date(int month,	int day,int year){
		this.month=month;
		this.day=day;
		this.year=year;
	}
	
	public void displayDate() {
        System.out.println(month + "/" + day + "/" + year);
    }
	public void setMonth(int month) {
		this.month=month;
	}
	public void setday(int day) {
		this.day=day;
	}
	public void setyear(int year) {
		this.year=year;
	}
}

public class lab7 {
	public static void main(String[] args) {
        
        date date = new date(10, 15, 2024);

       
        date.displayDate();

        System.out.println("After setting date");
        date.setMonth(12);
        date.setday(25);
        date.setyear(2025);

        
        date.displayDate();

        
        System.out.println("Month: " + date.month);
        System.out.println("Day: " + date.day);
        System.out.println("Year: " + date.year);
    }

}

