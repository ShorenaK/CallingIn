/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: Reply.java
******/

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a reply in the system.
 * Extends {@link AbstractUserContent} to include nested replies and recursive display functionality.
 */
public class Reply extends AbstractUserContent {
    // List of nested replies
    private List<Reply> replies;

    /**
     * Constructs a Reply with the given sender and content.
     *
     * @param sender  the user who created the reply
     * @param content the textual content of the reply
     */
    public Reply(User sender, String content) {
        super(sender, content);
        this.replies = new ArrayList<>();
    }

    /**
     * Returns the list of nested replies.
     *
     * @return a list of nested replies
     */
    public List<Reply> getReplies() {
        return replies;
    }

    /**
     * Adds a nested reply to this reply.
     *
     * @param reply the nested reply to add
     */
    public void addReply(Reply reply) {
        replies.add(reply);
    }

    /**
     * Displays the reply's content and its sender.
     */
    @Override
    public void display() {
        System.out.println("Reply from " + sender.getName() + ": " + content);
    }

    /**
     * Recursively displays the reply and its nested replies with indentation based on depth.
     *
     * @param depth the indentation level for nested replies
     */
    public void displayReplies(int depth) {
        System.out.println("  ".repeat(depth) + "- " + content + " (by " + sender.getName() + ")");
        for (Reply reply : replies) {
            reply.displayReplies(depth + 1);
        }
    }

    /**
     * Returns a string representation of the reply.
     *
     * @return a string containing the content and sender of the reply
     */
    @Override
    public String toString() {
        return "Reply{content='" + content + "', sender='" + sender.getName() + "'}";
    }
}