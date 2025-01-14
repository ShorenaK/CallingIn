/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: NotificationInterface.java
******/


/**
 * Represents the interface for a notification system.
 * Provides methods for sending, managing, and retrieving notification details.
 */
public interface NotificationInterface {

  /**
   * Retrieves the unique identifier for the notification.
   *
   * @return the notification ID as a string
   */
  String getNotificationId();

  /**
   * Sends the notification to the target user.
   */
  void send();

  /**
   * Retrieves the message content of the notification.
   *
   * @return the notification message as a string
   */
  String getMessage();

  /**
   * Retrieves the user who is the target of the notification.
   *
   * @return the target user
   */
  User getTargetUser();

  /**
   * Checks whether the notification has been read.
   *
   * @return {@code true} if the notification is read, {@code false} otherwise
   */
  boolean isRead();

  /**
   * Marks the notification as read.
   */
  void markAsRead();
}