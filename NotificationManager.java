/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: NotificationManager.java
******/

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of notifications and provides functionality to add, send, filter,
 * and manipulate notifications.
 */
public class NotificationManager {
    // List of notifications managed by this class
    private List<NotificationInterface> notifications;

    /**
     * Constructs a new NotificationManager with an empty list of notifications.
     */
    public NotificationManager() {
        this.notifications = new ArrayList<>();
    }

    /**
     * Adds a new notification to the list.
     *
     * @param notification the notification to add
     */
    public void addNotification(NotificationInterface notification) {
        notifications.add(notification);
    }

    /**
     * Sends all notifications in the list by invoking their {@code send()} method.
     */
    public void sendAllNotifications() {
        for (NotificationInterface notification : notifications) {
            notification.send();
        }
    }

    /**
     * Retrieves a list of unread notifications.
     *
     * @return a list of unread notifications
     */
    public List<NotificationInterface> getUnreadNotifications() {
        return notifications.stream()
                .filter(notification -> !notification.isRead()) // Filter unread notifications
                .toList();
    }

    /**
     * Retrieves a list of messages from all notifications.
     *
     * @return a list of notification messages
     */
    public List<String> getNotificationMessages() {
        return notifications.stream()
                .map(NotificationInterface::getMessage) // Map to messages
                .toList();
    }

    /**
     * Counts the total number of unread notifications.
     *
     * @return the count of unread notifications
     */
    public int countUnreadNotifications() {
        return notifications.stream()
                .map(notification -> notification.isRead() ? 0 : 1) // Map unread to 1, read to 0
                .reduce(0, Integer::sum); // Sum the results
    }

    /**
     * Marks all notifications in the list as read by invoking their {@code markAsRead()} method.
     */
    public void markAllAsRead() {
        for (NotificationInterface notification : notifications) {
            notification.markAsRead();
        }
    }
}