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
public interface Visitor {
    
    public void visitGroup(UserGroup userGroup);
    
    public void visitUser(User user);
    
    public void visitTwitterMessage(TwitterMessage twitterMessage);
    
}
