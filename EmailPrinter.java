/*
 * This class will be where the emails are printed out from
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class EmailPrinter {
	
	/**
	 * This function will go through each item in the users email and will print out that information through the function toString in the class Email
	 * @param emails
	 */
	public static void printEmails(ArrayList<Email> emails) {
        for (Email userEmail : emails) {
            System.out.println(userEmail.toString());
        }
    }
	
	/**
	 * This function will
	 * a) try first to see if they can use the users file and if not it will catch that and make the return false
	 * b) if it does work through it will go through the users email and then write each of the information in the string format function toFileString
	 * c) once it don will close the buffered writer and return true.
	 * @param emails
	 * @param fileName
	 * @return
	 */
	public static boolean printToFile(ArrayList<Email> emails, String userFileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(userFileName));
            for (Email userEmail : emails) {
                bw.write(userEmail.toFileString());
                bw.newLine();
            }
            bw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
