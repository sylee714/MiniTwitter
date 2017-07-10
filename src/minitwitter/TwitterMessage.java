/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

/**
 *
 * @author MingKie
 */
public class TwitterMessage {
    private static int size = 0;
    private static int positiveMessageSize = 0;
    private final String[] positiveWords = new String[]{"good", "great", "cool",
        "nice", "positive"};
    private String ID;
    private String message;
    
    public TwitterMessage(String ID, String message) {
        size++;
        this.message = message;
        this.ID = ID;
        countPositiveMessage(message);
    }

    public static int getSize() {
        return size;
    }

    public static int getPositiveMessageSize() {
        return positiveMessageSize;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
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
