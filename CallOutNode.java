/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: CallOutNode.java
******/


/**
 * Represents a node in the CallOut linked list.
 * Each node contains a reference to a CallOut and the next node in the list.
 */
public class CallOutNode {
    // The CallOut object stored in this node
    private CallOut callOut;
    private CallOutNode next;

    /**
     * Constructs a CallOutNode with the given CallOut.
     * The next node is initialized to {@code null}.
     *
     * @param callOut the CallOut to store in this node
     */
    public CallOutNode(CallOut callOut) {
        this.callOut = callOut;
        this.next = null;
    }

    /**
     * Retrieves the CallOut stored in this node.
     *
     * @return the CallOut object
     */
    public CallOut getCallOut() {
        return callOut;
    }

    /**
     * Retrieves the next node in the linked list.
     *
     * @return the next CallOutNode, or {@code null} if this is the last node
     */
    public CallOutNode getNext() {
        return next;
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param next the next CallOutNode
     */
    public void setNext(CallOutNode next) {
        this.next = next;
    }

    /**
     * Returns a string representation of the CallOutNode.
     *
     * @return a string containing the CallOut details
     */
    @Override
    public String toString() {
        return "CallOutNode{" +
               "callOut=" + callOut +
               '}';
    }
}
