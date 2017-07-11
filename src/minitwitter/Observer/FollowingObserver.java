/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import minitwitter.Subject.Subject;
import minitwitter.User;

/**
 *
 * @author MingKie
 */
public class FollowingObserver implements Observer {
    
    private DefaultListModel followingModel;
    private JList currentFollowing;
    
    public FollowingObserver(DefaultListModel followingModel, 
            JList currentFollowing) {
       this.followingModel = followingModel;
       this.currentFollowing = currentFollowing; 
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof User) {
            if (User.getState() == 0) {
            User user = (User) subject;
            User followingUser = User.getFollowingUser();
            followingModel.addElement(followingUser.getId());
            int index = user.getFollowings().size() - 1;
            currentFollowing.setSelectedIndex(index);
            currentFollowing.ensureIndexIsVisible(index);
            }
        }
    }
    
}
