/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes:  EmailNotification.java
******/


/**
 * Represents an email notification, a specific implementation of {@link AbstractNotification}.
 * Includes email-specific fields and behavior.
 */
public class EmailNotification extends AbstractNotification {
    // The subject of the email
    private String subject;

    /**
     * Constructs an EmailNotification with the specified target user, subject, and message.
     *
     * @param targetUser the user who will receive the email
     * @param subject    the subject of the email
     * @param message    the message content of the email
     */
    public EmailNotification(User targetUser, String subject, String message) {
        super(targetUser, message); // Call the parent constructor
        this.subject = subject;
    }

    /**
     * Sends the email notification.
     * Simulates the process of sending an email by printing the email details to the console.
     */
    @Override
    public void send() {
        System.out.println("Sending Email to " + targetUser.getEmail());
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }

    /**
     * Retrieves the full message of the email, including the subject and message content.
     *
     * @return the full email message in the format "Subject: Message"
     */
    @Override
    public String getMessage() {
        return subject + ": " + message;
    }

    /**
     * Retrieves the user who is the target of the email notification.
     *
     * @return the target user
     */
    @Override
    public User getTargetUser() {
        return targetUser;
    }
}