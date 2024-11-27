
class employe{
	String name;
	String lastName;
	double m_salary;
    employe(String name,String lastName,double m_salary){
		this.name=name;
		this.lastName=lastName;
		if(m_salary>0) {
			setm_salary(m_salary);
		}
		display();
	}
	public void setm_salary(double m_salary) {
		this.m_salary=m_salary;
	}
	public void display() {
		System.out.println("name :"+ name);
		System.out.println("lastName :"+ lastName);
		if(m_salary>0)
		{
		System.out.println("m_salary :"+ m_salary);
		}
	}
	public void hike() {
		m_salary+=(m_salary)*0.1;
	}
}
public class employee {
	public static void main(String[] arg) {
		
  employe a=new employe("Thanuja","Madhunala",5000);
  a.display();
  a.hike();
  System.out.println("After the hike");
  a.display();
  System.out.println("");
  employe b=new employe("Varshini","Budde",7800);
  b.display();
  b.hike();
  System.out.println("After the hike");
  b.display();
  
	}
  
}
