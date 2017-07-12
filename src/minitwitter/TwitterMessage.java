package minitwitter;

import minitwitter.Visitor.Visitor;

/**
 * This class represents a Twitter message that a user enters.
 * @author Seungyun Lee
 */
public class TwitterMessage implements Component {
    
    // Total number of messages
    private static int size = 0;
    // Total number of positive messages
    private static int positiveMessageSize = 0;
    // Positive word bank
    private final String[] positiveWords = new String[]{"good", "great", "cool",
        "nice", "positive"};
    // ID of the user that entered the message
    private String ID;
    private String message;
    
    /**
     * This is the constructor that creates a Twitter message.
     * @param ID, user's ID
     * @param message, message that user typed
     */
    public TwitterMessage(String ID, String message) {      
        this.message = message;
        this.ID = ID;
        countPositiveMessage(message);
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visitTwitterMessage(this);
    }

    /**
     * This method increase the size.
     */
    public static void increaseSize() {
        size++;
    }
    
    /**
     * This method returns the size which is the total number of messages.
     * @return total number of message
     */
    public static int getSize() {
        return size;
    }

    /**
     * This method returns the total number of positive messages.
     * @return total number of positive messages
     */
    public static int getPositiveMessageSize() {
        return positiveMessageSize;
    }

    /**
     * This method returns the ID of the user that typed the message.
     * @return user's ID
     */
    public String getID() {
        return ID;
    }

    /**
     * This method sets the ID as the ID of the user that typed the message.
     * @param ID, user's ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * This method gets the message.
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method sets the message
     * @param message, message that user typed.
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * This method checks if the message contains a positive word.
     * If yes, then increase the number of positive messages.
     * @param message, message that user typed.
     */
    private void countPositiveMessage(String message) {
        String tempMessage = message.toLowerCase();
        for (int i = 0; i < positiveWords.length; ++i) {
            for (int j = 0; j < tempMessage.length(); ++j) {
                if (tempMessage.contains(positiveWords[i])) {
                    positiveMessageSize++;
                    break;
                }
            }
        }
    }
    
}
