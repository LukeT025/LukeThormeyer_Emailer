
public class Emailer {
	
	public static void printWelcomeBanner(){
		System.out.println("*".repeat(65));
		System.out.println(" ".repeat(29) + "Emailer");
		System.out.println("*".repeat(65));
		System.out.println();
	}
	
	public static void printMenu() {
		System.out.println("Here are your options:");
		System.out.println("1. Write email");
		System.out.println("2. List emails.");
		System.out.println("3. Send emails.");
		System.out.println("4. Save emails to file.");
		System.out.println("5. Exit");
	}
	
	public static void main(String[] args) {
		printWelcomeBanner();
	}
}
