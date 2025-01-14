/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: User.java
******/


import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user in the system, capable of managing notifications, sending and replying to call-outs,
 * and reacting to call-outs.
 */
public class User {

    private String name;
    private String email;

    // List of notifications associated with the user
    private List<NotificationInterface> notifications;

    // Custom linked list of CallOuts for the user
    private CallOutList callOuts;

    /**
     * Constructs a new User with a name and email.
     *
     * @param name the name of the user
     * @param email the email address of the user
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.notifications = new ArrayList<>();
        this.callOuts = new CallOutList();
    }

    /**
     * Returns the name of the user.
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email address of the user.
     *
     * @return the user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Adds a notification to the user's notification list.
     *
     * @param notification the notification to add
     */
    public void addNotification(NotificationInterface notification) {
        notifications.add(notification);
    }

    /**
     * Sends all notifications in the user's notification list.
     */
    public void sendNotifications() {
        for (NotificationInterface notification : notifications) {
            notification.send();
        }
    }

    /**
     * Creates and sends a new CallOut to a receiver.
     *
     * @param message  the message content of the CallOut
     * @param receiver the receiver of the CallOut
     * @return the created CallOut
     */
    public CallOut sendCallout(String message, User receiver) {
        CallOut newCallOut = new CallOut(this, receiver, message);
        callOuts.addCallOut(newCallOut);
        return newCallOut;
    }

    /**
     * Retrieves a list of notification messages.
     *
     * @return a list of notification messages
     */
    public List<String> viewNotifications() {
        List<String> messages = new ArrayList<>();
        for (NotificationInterface notification : notifications) {
            messages.add(notification.getMessage());
        }
        return messages;
    }

    /**
     * Replies to a specific CallOut identified by its ID.
     *
     * @param calloutId the ID of the CallOut to reply to
     * @param message  the reply message
     */
    public void replyToCallout(String calloutId, String message, CallOutList callOutList) {
                CallOut callOut = callOutList.findCalloutById(calloutId);
                if (callOut != null) {
                    Reply reply = new Reply(this, message);
                    callOut.addReply(reply);
                    System.out.println("Reply added: " + message);
                } else {
                    System.out.println("CallOut with ID " + calloutId + " not found.");
                }
            }
            
    /**
     * Reacts to a specific CallOut identified by its ID.
     *
     * @param calloutId the ID of the CallOut to react to
     * @param type the type of reaction
     * @param globalCallOuts the global list of CallOuts
     */
    public void reactToCallout(String calloutId, ReactionType type, CallOutList globalCallOuts) {
        CallOut callOut = globalCallOuts.findCalloutById(calloutId);
        if (callOut != null) {
            Reaction reaction = new Reaction(this, type);
            callOut.addReaction(reaction);
        } else {
            System.out.println("CallOut with ID " + calloutId + " not found.");
        }
    }

    /**
     * Returns a string representation of the user.
     *
     * @return a string representation of the user
     */
    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email +
               "', callOuts=" + callOuts.size() +
               ", notifications=" + notifications.size() + "}";
    }
}