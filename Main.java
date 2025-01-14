/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: Main.java
******/


import java.util.List;

/**
 * Entry point of the application.
 * Demonstrates the functionality of the CallingOut system, including users, CallOuts, replies, reactions, and notifications.
 */
public class Main {

    /**
     * The main method that drives the program execution.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create Users
        User sender = new User("Shorena", "Shorena@gmail.com");
        User receiver = new User("Sister", "Sister@gmail.com");

        System.out.println("\n**** ---- **** Testing user creation. **** ---- **** ");

        // Display User's specific attributes
        System.out.println("\nSender Info: " + "Name: " + sender.getName() + " & " + "Email Addresses: " + sender.getEmail());
        System.out.println("Receiver Info: " + "Name: " + receiver.getName() + " & " + "Email Addresses: " + receiver.getEmail());

        System.out.println("\n**** ---- **** Display User's full details. **** ---- **** ");
        // Display User's full details using toString()
        System.out.println("\nSender Details: " + sender);
        System.out.println("Receiver Details: " + receiver);

        // Create and Send a CallOut
        System.out.println("\n**** ---- **** Sending a CallingOut. **** ---- ****");
        CallOutList globalCallOuts = new CallOutList();
        CallOut callOut = sender.sendCallout("We need to discuss before we lose each other.", receiver);
        globalCallOuts.addCallOut(callOut);

        // Display only the CallOut message
        System.out.println("CallingOut Message: " + callOut.getContent());

        // Add Replies to the CallOut
        System.out.println("\n**** ---- **** Adding replies to the CallingOut. **** ---- ****");
        String calloutId = callOut.getId();

        receiver.replyToCallout(calloutId, "I agree. When can we talk?", globalCallOuts);
        sender.replyToCallout(calloutId, "How about tomorrow evening?", globalCallOuts);
        receiver.replyToCallout(calloutId, "Tomorrow evening works for me.", globalCallOuts);

        // Display the CallOut with Replies
        System.out.println("\nDisplaying the CallingOut with Replies:");
        CallOut foundCallOut = globalCallOuts.findCalloutById(calloutId);
        if (foundCallOut != null) {
            System.out.println("CallingOut Message: " + foundCallOut.getContent());
            System.out.println("\nAll Replies:");
            for (Reply reply : foundCallOut.getReplies()) {
                reply.displayReplies(0);
            }
        } else {
            System.out.println("CallingOut not found.");
        }

        // Add Nested Replies to Test Hierarchical Structure
        System.out.println("\n**** ---- **** Adding more nested replies. **** ---- ****");
        if (foundCallOut != null) {
            Reply initialReply = new Reply(sender, "What about next week?");
            foundCallOut.addReply(initialReply);

            Reply nestedReply1 = new Reply(receiver, "Next week works. How about Monday?");
            initialReply.addReply(nestedReply1);

            Reply nestedReply2 = new Reply(sender, "Monday sounds good.");
            nestedReply1.addReply(nestedReply2);

            // Display All Replies with Nesting
            System.out.println("\nDisplaying All Replies with Nesting:");
            for (Reply reply : foundCallOut.getReplies()) {
                reply.displayReplies(0);
            }
        }

        // Add Reactions to the CallOut
        System.out.println("\n**** ---- **** Adding reactions to the CallingOut. **** ---- ****");
        receiver.reactToCallout(calloutId, ReactionType.LIKE, globalCallOuts);
        sender.reactToCallout(calloutId, ReactionType.LOVE, globalCallOuts);

        // Display the CallOut with Reactions
        System.out.println("\nDisplaying the CallingOut with Reactions:");
        if (foundCallOut != null) {
            System.out.println("\nInitial message: " + foundCallOut.getContent());
            System.out.println("\nDisplay Reactions:");
            for (Reaction reaction : foundCallOut.getReactions()) {
                reaction.display();
            }
        }

        // Add Additional Reactions
        System.out.println("\n**** ---- **** Adding more reactions. **** ---- ****");
        receiver.reactToCallout(calloutId, ReactionType.LAUGH, globalCallOuts);
        sender.reactToCallout(calloutId, ReactionType.SAD, globalCallOuts);

        // Display Updated Reactions
        System.out.println("\nDisplaying Updated Reactions:");
        if (foundCallOut != null) {
            for (Reaction reaction : foundCallOut.getReactions()) {
                reaction.display();
            }
        }

        // This is Section below is all about Testing Notification System!
        System.out.println("\n**** ---- **** Testing notifications. **** ---- ****");
        NotificationManager notificationManager = new NotificationManager();

        // Create Notifications
        EmailNotification emailNotification = new EmailNotification(receiver, "Important", "Please reply to the CallingOut ASAP.");
        PhoneNotification phoneNotification = new PhoneNotification(receiver, "111-111-1111", "We need to talk soon.");

        // Add Notifications to Manager and User
        notificationManager.addNotification(emailNotification);
        notificationManager.addNotification(phoneNotification);
        receiver.addNotification(emailNotification);
        receiver.addNotification(phoneNotification);

        // Send Notifications
        System.out.println("\nSending all notifications:");
        notificationManager.sendAllNotifications();

        // View Unread Notifications
        System.out.println("\nUnread notifications for receiver:");
        List<NotificationInterface> unreadNotifications = notificationManager.getUnreadNotifications();
        unreadNotifications.forEach(notification -> System.out.println(notification.getMessage()));

        // Mark Notifications as Read
        System.out.println("\n**** ---- **** Marking all notifications as read. **** ---- ****");
        notificationManager.markAllAsRead();

        // Display Notification Summary
        System.out.println("\nNotification summary for receiver:");
        System.out.println("Total unread: " + notificationManager.countUnreadNotifications());
        System.out.println("All notifications:");
        notificationManager.getNotificationMessages().forEach(System.out::println);

        // Add Additional Notifications
        System.out.println("\n**** ---- **** Adding multiple notifications. **** ---- ****");
        notificationManager.addNotification(new EmailNotification(receiver, "Follow Up", "Are we meeting tomorrow?"));
        notificationManager.addNotification(new PhoneNotification(receiver, "111-111-1111", "Reminder: You have a pending CallOut."));
        notificationManager.addNotification(new EmailNotification(receiver, "Urgent", "We need to finish our discussion."));

        // View All Notifications
        System.out.println("\nAll notifications after adding more:");
        notificationManager.getNotificationMessages().forEach(System.out::println);

        // Filter, View and Count Unread Notifications
        System.out.println("\nUnread Notifications:");
        List<NotificationInterface> filteredUnread = notificationManager.getUnreadNotifications();
        filteredUnread.forEach(notification -> System.out.println(notification.getMessage()));

        System.out.println("\nCount of Unread Notifications:");
        System.out.println(notificationManager.countUnreadNotifications());

        // Mark All as Read and Display Updated Count
        notificationManager.markAllAsRead();
        System.out.println("\nUnread Notifications After Marking All as Read:");
        System.out.println(notificationManager.countUnreadNotifications());
    }
}