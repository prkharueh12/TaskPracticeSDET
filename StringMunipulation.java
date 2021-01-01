package practiceInterviewTask;

public class StringMunipulation {

	public static void main(String[] args) {
		String name = "abcdef"; 
		
		//For loop
		for (int i = name.length()-1; i >=0; i--) {
			System.out.print(name.charAt(i)+ ", ");
		}

	}

}
