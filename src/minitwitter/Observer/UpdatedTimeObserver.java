/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter.Observer;

import javax.swing.JLabel;
import minitwitter.Subject.Subject;
import minitwitter.User;

/**
 * This class represents a updated time observer. Whenever a new message is added,
 * it updates user's updated time also his/her followers' time.
 * @author Seungyun Lee
 */
public class UpdatedTimeObserver implements Observer {
    
    private JLabel updatedTimeLabel;
    
    /**
     * This is the constructor to create a updated time observer. 
     * @param updatedTimeLabel, label to display the time 
     */
    public UpdatedTimeObserver(JLabel updatedTimeLabel) {
        this.updatedTimeLabel = updatedTimeLabel;
    }

    @Override
    public void update(Subject subject) {
        if (User.getState() == 1) {
            if (subject instanceof User) {
                // User that notified this observer
                User user = (User) subject;
                updatedTimeLabel.setText(user.getLastUpdateTime() + "");
            }
        }
    }
    
}
