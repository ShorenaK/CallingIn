/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: PhoneNotification.java
******/


/**
 * Represents a phone notification, a specific implementation of {@link AbstractNotification}.
 * Includes phone-specific fields and behavior for sending SMS messages.
 */
public class PhoneNotification extends AbstractNotification {
    // The recipient's phone number
    private String phoneNumber;

    /**
     * Constructs a PhoneNotification with the specified target user, phone number, and message.
     *
     * @param targetUser  the user who will receive the notification
     * @param phoneNumber the recipient's phone number
     * @param message     the message content of the SMS
     */
    public PhoneNotification(User targetUser, String phoneNumber, String message) {
        super(targetUser, message); // Call the parent constructor
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sends the phone notification.
     * Simulates the process of sending an SMS by printing the details to the console.
     */
    @Override
    public void send() {
        System.out.println("Sending SMS to " + phoneNumber);
        System.out.println("Message: " + message);
    }
}