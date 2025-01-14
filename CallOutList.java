/******
Name: Shorena K. Anzhilov
Assignment:  Final Lab -- CallingOut App  
Date: 11.27.2024
Notes: CallOutList.java
******/


/**
 * A linked list implementation for managing a collection of CallOut objects.
 * Provides methods to add, remove, find, display, and count CallOuts in the list.
 */
public class CallOutList {
    
    private CallOutNode head;

    /**
     * Adds a CallOut to the list. If the list is empty, the CallOut becomes the head.
     * Otherwise, it is added to the end of the list.
     *
     * @param callOut the CallOut to add
     */
    public void addCallOut(CallOut callOut) {
        if (head == null) {
            head = new CallOutNode(callOut);
        } else {
            CallOutNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new CallOutNode(callOut));
        }
    }

    /**
     * Displays all CallOuts in the list.
     * Each CallOut is printed using its {@code toString()} representation.
     */
    public void displayCallOuts() {
        CallOutNode current = head;
        while (current != null) {
            System.out.println(current.getCallOut());
            current = current.getNext();
        }
    }

    /**
     * Finds a CallOut by its unique ID.
     *
     * @param id the ID of the CallOut to find
     * @return the CallOut with the matching ID, or {@code null} if not found
     */
    public CallOut findCalloutById(String id) {
        CallOutNode current = head;
        while (current != null) {
            if (current.getCallOut().getId().equals(id)) {
                return current.getCallOut();
            }
            current = current.getNext();
        }
        System.out.println("No match found for ID: " + id);
        return null;
    }

    /**
     * Removes a CallOut by its unique ID.
     *
     * @param id the ID of the CallOut to remove
     * @return {@code true} if the CallOut was successfully removed, {@code false} otherwise
     */
    public boolean removeCallOutById(String id) {
        if (head == null) {
            return false;
        }

        // If the head needs to be removed
        if (head.getCallOut().getId().equals(id)) {
            head = head.getNext();
            return true;
        }

        // Traverse the list to find and remove the node
        CallOutNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getCallOut().getId().equals(id)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }

        return false; 
    }

    /**
     * Returns the size of the CallOut list.
     *
     * @return the number of CallOuts in the list
     */
    public int size() {
        int count = 0;
        CallOutNode current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    /**
     * Returns a string representation of the CallOutList, including all CallOuts in the list.
     *
     * @return a string representation of the CallOutList
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("CallOutList: [");
        CallOutNode current = head;
        while (current != null) {
            result.append(current.getCallOut().toString()).append(", ");
            current = current.getNext();
        }
        if (result.length() > 12) {
            result.setLength(result.length() - 2);
        }
        result.append("]");
        return result.toString();
    }
}