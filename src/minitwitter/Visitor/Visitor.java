package minitwitter.Visitor;

import minitwitter.TwitterMessage;
import minitwitter.User;
import minitwitter.UserGroup;

/**
 * This class represents a visitor that visits certain fields
 * of another class.
 * @Seungyun Lee
 */
public interface Visitor {
    
    /**
     * This method visits class UserGroup.
     * @param userGroup, an instance of UserGroup
     */
    public void visitGroup(UserGroup userGroup);
    
    /**
     * This method visits class User.
     * @param user, an instance of User
     */
    public void visitUser(User user);
    
    /**
     * This method visits class TwitterMessage
     * @param twitterMessage, an instance of TwitterMessage
     */
    public void visitTwitterMessage(TwitterMessage twitterMessage);
    
}
