import java.util.Scanner;


public class Main {

	public static int readNumber(Scanner input) {
		if (input == null) {
			input = new Scanner(System.in);
		}
		
		return input.nextInt(); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int a=0;
		while (true) {
			a = readNumber(input);
			if (a == 42) {
				return;
			} else {
				System.out.println(a);
			}
		}
	}
}
