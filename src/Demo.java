
class PasswordValidater{
	boolean isValidPassword(String password) {
	if(password.length()<5 && password.length()>12) {
		return false;
	}
	boolean hasLowerCase=false;
	boolean hasDigit=false;
	for(int i=0;i<password.length();i++) {
		char ch=password.charAt(i);
		if(Character.isLowerCase(ch)) {
			hasLowerCase=true;
		}
		if(Character.isDigit(ch)) {
			hasDigit=true;
		}
		if(Character.isUpperCase(ch)) {
			return false;
		}
		if(i>0 && password.charAt(i)==password.charAt(i-1)) {
			return false;
		}
	}
	return hasLowerCase&&hasDigit;
}
};
public class Demo {
   public static void main(String args[] ) {
	   PasswordValidater p=new PasswordValidater();
	   String s1="abcD123";
	 if(p.isValidPassword(s1)) {
          System.out.println("Valid password");
	 }
	 else {
		 System.out.println("INvalid password");
	 }
   }

}

