/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter.Visitor;

import minitwitter.TwitterMessage;
import minitwitter.User;
import minitwitter.UserGroup;

/**
 *
 * @author MingKie
 */
public class SizeVisitor implements Visitor {
    
    private int userSize;
    private int userGroupSize;
    private int messageSize;
    private int positiveMessageSize;
    
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
    
    public int getUserSize() {
        return userSize;
    }

    public void setUserSize(int userSize) {
        this.userSize = userSize;
    }

    public int getUserGroupSize() {
        return userGroupSize;
    }

    public void setUserGroupSize(int userGroupSize) {
        this.userGroupSize = userGroupSize;
    }

    public int getMessageSize() {
        return messageSize;
    }

    public void setMessageSize(int messageSize) {
        this.messageSize = messageSize;
    }

    public int getPositiveMessageSize() {
        return positiveMessageSize;
    }

    public void setPositiveMessageSize(int positiveMessageSize) {
        this.positiveMessageSize = positiveMessageSize;
    }
 
}
