/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: Reaction.java
******/

/**
 * Represents a user's reaction to a call-out or content.
 * Inherits from {@link AbstractUserContent} and includes the type of reaction.
 */
public class Reaction extends AbstractUserContent {

    private ReactionType reactionType;

    /**
     * Constructs a Reaction with the given sender and reaction type.
     *
     * @param sender the user who made the reaction
     * @param reactionType the type of reaction
     */
    public Reaction(User sender, ReactionType reactionType) {
        super(sender, reactionType.toString());
        this.reactionType = reactionType;
    }

    /**
     * Returns the type of reaction.
     *
     * @return the type of reaction
     */
    public ReactionType getReactionType() {
        return reactionType;
    }

    /**
     * Displays the reaction details, including the sender and the reaction type.
     */
    @Override
    public void display() {
        System.out.println("Reaction by " + sender.getName() + ": " + reactionType);
    }
}