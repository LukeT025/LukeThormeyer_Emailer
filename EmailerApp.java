/*
 * This is the class that will be be where the user will enter their emails, send the emails, write out their emails and 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailerApp {
	
	
	/**
	 * This is the welcome banner that will pop up once the user loads the program
	 */
	public static void printWelcomeBanner(){
		System.out.println("*".repeat(65));
		System.out.println(" ".repeat(29) + "Emailer");
		System.out.println("*".repeat(65));
		System.out.println();
	}
	
	/**
	 * This is menu that will pop up for the user and they can choose what they want
	 */
	public static void printMenu() {
		System.out.println("Here are your options:");
		System.out.println("1. Write email");
		System.out.println("2. List emails.");
		System.out.println("3. Send emails.");
		System.out.println("4. Save emails to file.");
		System.out.println("5. Exit");
	}
	
	/**
	 * This function does is asked for first the users recipients (which goes through each on of the user input and adds them to the array list), user subject and finally users body
	 * Then after that will add that information to the Email function in email 
	 * Finally it add that to the array list emails
	 * @param emails
	 * @param sc
	 */
	private static void writeEmail(ArrayList<Email> emails, Scanner sc) {
		System.out.print("Enter recipients' email: ");
	    String usersRecipient = sc.nextLine();
	    String[] recipientString = usersRecipient.split(" ");
	    ArrayList<String> recipients = new ArrayList<>();
	    for (String recipient : recipientString) {
	        recipients.add(recipient);
	    }
	    System.out.print("Enter subject: ");
	    String usersubject = sc.nextLine();
	    System.out.print("Enter body: ");
	    String userbody = sc.nextLine();
	    Email userEmail = new Email(recipients, usersubject, userbody);
	    emails.add(userEmail);
	}
	
	/**
	 * This function does is go through each part of the user email they have put in and will make them all to send.
	 * Then tell the user they have sent
	 * @param emails
	 */
	private static void sendEmails(ArrayList<Email> emails) {
		for (Email userEmail : emails) {
            userEmail.send();
        }
        System.out.println("All emails have been sent.");
    }
	
	/**
	 * What this function will 
	 * a) first ask for the user to enter in the user file in where they want to save the emails in
	 * b) then it will go through the function EmailPrinter to the function in there where they will make the
	 * c)if it did get to write he information in the file then then will print back its was successful
	 * d) if it could not then it will tell the user it failed  
	 * @param emails
	 * @param sc
	 */
	private static void saveToFile(ArrayList<Email> emails, Scanner sc) {
		System.out.print("Enter the name of the file to save: ");
        String userFileName = sc.nextLine();
        boolean ifSuccess = EmailPrinter.printToFile(emails, userFileName);
        if (ifSuccess) {
            System.out.println("Emails were saved successfully.");
        } else {
            System.out.println("Emails failed to save.");
        }
    }
	
	/**
	 * This function will
	 * a) make a welcome banner and also ask the user for what they want to do
	 * b) it will if 1) ask for the information from writeEmail, 2) will print out the emails, 3) will make the emails "send", 4) will ask for the users file and then print it in there
	 * c) if its 5) then will close the whole program and make a thank the user
	 * d) if its any other number then 1-5) then it will ask the user t put in a number from the list
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Email> emails = new ArrayList<Email>();
		Scanner sc = new Scanner(System.in);
		printWelcomeBanner();
		int userChoice;
		
		do {
			printMenu();
			System.out.print("Enter the number of your choice: ");
			userChoice = sc.nextInt();
			sc.nextLine();
			
			if (userChoice == 1) {
				writeEmail(emails, sc);
			}else if (userChoice == 2){
				EmailPrinter.printEmails(emails);
			}else if (userChoice == 3) {
				 sendEmails(emails);
			}else if (userChoice == 4) {
				saveToFile(emails, sc);
			}else if (userChoice == 5) {
				System.out.println(" ");
				System.out.println("Thank you for using this program.");
			} else {
				System.out.println("Please enter a number on the list.");
			}
		} while (userChoice != 5);
		
	}
}
