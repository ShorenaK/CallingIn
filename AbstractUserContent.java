/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: AbstractUserContent.java
******/

/**
 * Represents an abstract base class for user-generated content.
 * Provides common properties and behaviors for content such as sender and content details.
 * Subclasses must implement the display method.
 */
public abstract class AbstractUserContent {
    // The user associated with the content
    protected User sender;

    // The textual content
    protected String content;

    /**
     * Constructs an AbstractUserContent object with the given sender and content.
     *
     * @param sender  the user who created the content
     * @param content the textual content
     */
    public AbstractUserContent(User sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    /**
     * Returns the sender of the content.
     *
     * @return the user who created the content
     */
    public User getSender() {
        return sender;
    }

    /**
     * Returns the textual content.
     *
     * @return the content as a string
     */
    public String getContent() {
        return content;
    }

    /**
     * Abstract method for displaying the content.
     * Subclasses must provide an implementation.
     */
    public abstract void display();
}