package minitwitter.Visitor;

import minitwitter.TwitterMessage;
import minitwitter.User;
import minitwitter.UserGroup;

/**
 * This class represents a size visitor that visits each given class
 * and gets their sizes.
 * @author Seungyun Lee
 */
public class SizeVisitor implements Visitor {
    
    private int userSize;
    private int userGroupSize;
    private int messageSize;
    private int positiveMessageSize;
    
    /**
     * This is the constructor to create a size visitor.
     */
    public SizeVisitor() {       
    }

    @Override
    public void visitGroup(UserGroup userGroup) {
        setUserGroupSize(UserGroup.getSize());
    }

    @Override
    public void visitUser(User user) {
        setUserSize(User.getSize());
    }
    
    @Override
    public void visitTwitterMessage(TwitterMessage twitterMessage) {
        setMessageSize(TwitterMessage.getSize());
        setPositiveMessageSize(TwitterMessage.getPositiveMessageSize());
    }
    
    /**
     * This method returns the total number of users.
     * @return total number of users
     */
    public int getUserSize() {
        return userSize;
    }

    /**
     * This method sets the total number of users.
     * @param userSize, total number of users
     */
    public void setUserSize(int userSize) {
        this.userSize = userSize;
    }

    /**
     * This method returns the total number of user groups.
     * @return total number of user groups
     */
    public int getUserGroupSize() {
        return userGroupSize;
    }

    /**
     * This method sets the total number of user groups with the given one.
     * @param userGroupSize, total number of user groups
     */
    public void setUserGroupSize(int userGroupSize) {
        this.userGroupSize = userGroupSize;
    }

    /**
     * This method returns the total number of messages.
     * @return total number of messages
     */
    public int getMessageSize() {
        return messageSize;
    }

    /**
     * This method sets the total number of messages with the given one.
     * @param messageSize, total number of messages
     */
    public void setMessageSize(int messageSize) {
        this.messageSize = messageSize;
    }

    /**
     * This method returns the total number of positive messages.
     * @return total number of positive messages
     */
    public int getPositiveMessageSize() {
        return positiveMessageSize;
    }

    /**
     * This method sets the total number of positive messages with the given one.
     * @param positiveMessageSize, total number of positive messages
     */
    public void setPositiveMessageSize(int positiveMessageSize) {
        this.positiveMessageSize = positiveMessageSize;
    }
 
}
