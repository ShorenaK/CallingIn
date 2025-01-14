/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: UserAction.java
******/

import java.util.List;

/**
 * Interface defining actions that can be performed on user-generated content, such as CallOuts.
 * Includes methods for adding replies and reactions, as well as retrieving content details.
 */
public interface UserAction {

    /**
     * Adds a reply to the content.
     *
     * @param reply the reply to be added
     */
    void addReply(Reply reply);

    /**
     * Adds a reaction to the content.
     *
     * @param reaction the reaction to be added
     */
    void addReaction(Reaction reaction);

    /**
     * Retrieves all replies associated with the content.
     *
     * @return a list of replies
     */
    List<Reply> getReplies();

    /**
     * Retrieves all reactions associated with the content.
     *
     * @return a list of reactions
     */
    List<Reaction> getReactions();

    /**
     * Retrieves the content of the CallOut or user-generated content.
     *
     * @return the content as a string
     */
    String getContent();

    /**
     * Retrieves the sender of the CallOut or user-generated content.
     *
     * @return the sender as a {@link User} object
     */
    User getSender();
}

