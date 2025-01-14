/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: UserAction.java
******/

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a CallOut, which is a form of user-generated content exchanged between users.
 * Supports actions such as adding replies and reactions, and tracking the status and history of the CallOut.
 */
public class CallOut implements UserAction {
    
    private String id;
    private User sender;
    private User receiver;
    private String content;
    private CallOutStatusType status;
    private List<Reply> replies;
    private List<Reaction> reactions;
    private String timestamp;

    /**
     * Constructs a CallOut with a sender, receiver, and content.
     * Initializes the CallOut with a unique ID, a timestamp, and a status of PENDING.
     *
     * @param sender the user who created the CallOut
     * @param receiver the user who is the recipient of the CallOut
     * @param content the content of the CallOut
     */
    public CallOut(User sender, User receiver, String content) {
        this.id = UUID.randomUUID().toString();
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.status = CallOutStatusType.PENDING;
        this.replies = new ArrayList<>();
        this.reactions = new ArrayList<>();
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * Adds a reply to the CallOut.
     *
     * @param reply the reply to add
     */
    @Override
    public void addReply(Reply reply) {
        replies.add(reply);
    }

    /**
     * Adds a reaction to the CallOut.
     *
     * @param reaction the reaction to add
     */
    @Override
    public void addReaction(Reaction reaction) {
        reactions.add(reaction);
    }

    /**
     * Retrieves the receiver of the CallOut.
     *
     * @return the receiver of the CallOut
     */
    public User getReceiver() {
        return receiver;
    }

    /**
     * Retrieves the timestamp of the CallOut's creation.
     *
     * @return the timestamp as a string
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Retrieves all replies associated with the CallOut.
     *
     * @return a list of replies
     */
    @Override
    public List<Reply> getReplies() {
        return replies;
    }

    /**
     * Retrieves all reactions associated with the CallOut.
     *
     * @return a list of reactions
     */
    @Override
    public List<Reaction> getReactions() {
        return reactions;
    }

    /**
     * Retrieves the content of the CallOut.
     *
     * @return the content as a string
     */
    @Override
    public String getContent() {
        return content;
    }

    /**
     * Retrieves the sender of the CallOut.
     *
     * @return the sender as a {@link User} object
     */
    @Override
    public User getSender() {
        return sender;
    }

    /**
     * Retrieves the unique ID of the CallOut.
     *
     * @return the ID as a string
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the current status of the CallOut.
     *
     * @return the status as a {@link CallOutStatusType}
     */
    public CallOutStatusType getStatus() {
        return status;
    }

    /**
     * Marks the CallOut as resolved by updating its status.
     */
    public void resolve() {
        this.status = CallOutStatusType.RESOLVED;
    }

    /**
     * Calculates the total number of replies, including nested replies.
     *
     * @return the total number of replies
     */
    public int getTotalReplies() {
        return replies.stream()
                .mapToInt(reply -> 1 + reply.getReplies().size())
                .reduce(0, Integer::sum);
    }

    /**
     * Returns a string representation of the CallOut, including its details such as
     * sender, receiver, content, status, and associated replies and reactions.
     *
     * @return a string representation of the CallOut
     */
    @Override
    public String toString() {
        return "CallOut{id='" + id + "', sender=" + sender.getName() + ", receiver=" + receiver.getName() +
               ", content='" + content + "', status=" + status + ", replies=" + replies.size() +
               ", reactions=" + reactions.size() + ", timestamp='" + timestamp + "'}";
    }
}