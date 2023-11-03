/*
 *  This class is where the variables  and where the format of the print statements are at.
 */

import java.util.ArrayList;

/**
 * Where the variables are at
 */
public class Email {
	private String subject;
	private String body;
	private ArrayList<String> recipients;
	private boolean sent;
	
	/**
	 * This function does is constructs specified recipents, subjects and bodies
	 * @param recipients
	 * @param subject
	 * @param body
	 */
	
	 public Email(ArrayList<String> recipients, String subject, String body) {
	        this.recipients = recipients;
	        this.subject = subject;
	        this.body = body;
	        this.sent = false;
	    }
	 
	 /**
	  * This function does is make the speific sent to true
	  */
	public void send() {
	    this.sent = true;
	}

	
	/**
	 * This function does is make a string of the email with the recipients, subjects, sent or not sent, and bodies 
	 * @return
	 */
	public String toString() {
		String ts = "To: " + recipients + "\n" + "Subject: " + subject + "\n" + "Status: " + (sent ? "sent" : "not sent") + "\n" + "Body:\n" + body + "\n";
		return ts;
    }
	
	
	/**
	 * This function does is return a string format that will be use for the file writing in one line of the user email with the recipents , subjects, bodies, and sent or not sent 
	 * @return
	 */
	 public String toFileString() {
		 return String.format("%s\t%s\t%s\t%s", recipients, subject, body, sent ? "sent" : "not sent");
	 }
	
}

