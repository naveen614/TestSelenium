
public class String_Comparision {
	public static void main(String[] args) {
	String s1="Naveen";
	String s2="Chary";
	String s3="NAVEEN";
	String s4=new String("Naveen");
	String s5="Naveen";
	
	System.out.println(s1.equals(s3));//false
	System.out.println(s1.equals(s2));//false
	System.out.println(s1.equals(s4));//true
	System.out.println(s1.equals(s5));//true
	
	System.out.println(s1==s5);//true
	System.out.println(s1==s4);//false
	}}
