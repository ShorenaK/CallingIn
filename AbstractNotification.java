/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: AbstractNotification.java
******/

import java.util.Date;
import java.util.UUID;

/**
 * Represents an abstract base class for notifications.
 * Implements common functionality for notifications and provides a blueprint for specific notification types.
 */
public abstract class AbstractNotification implements NotificationInterface {
    
    protected String notificationId;
    protected User targetUser;
    protected String message;
    protected Date timestamp;
    protected boolean isRead;

    /**
     * Constructs an AbstractNotification with a target user and message.
     * Automatically generates a unique ID and sets the timestamp to the current time.
     *
     * @param targetUser the user who will receive the notification
     * @param message the content of the notification
     */
    public AbstractNotification(User targetUser, String message) {
        this.notificationId = UUID.randomUUID().toString(); // Generate unique ID
        this.targetUser = targetUser;
        this.message = message;
        this.timestamp = new Date();  
        this.isRead = false;         
    }

    /**
     * Retrieves the unique identifier for the notification.
     *
     * @return the notification ID as a string
     */
    @Override
    public String getNotificationId() {
        return notificationId;
    }

    /**
     * Retrieves the message content of the notification.
     *
     * @return the notification message as a string
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * Retrieves the user who is the target of the notification.
     *
     * @return the target user
     */
    @Override
    public User getTargetUser() {
        return targetUser;
    }

    /**
     * Checks whether the notification has been read.
     *
     * @return {@code true} if the notification is read, {@code false} otherwise
     */
    @Override
    public boolean isRead() {
        return isRead;
    }

    /**
     * Marks the notification as read.
     */
    @Override
    public void markAsRead() {
        this.isRead = true;
    }

    /**
     * Abstract method to send the notification.
     * Must be implemented by subclasses to define specific behavior.
     */
    @Override
    public abstract void send();
}