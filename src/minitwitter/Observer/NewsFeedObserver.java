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
public class NewsFeedObserver implements Observer {
    
    private DefaultListModel newsFeedModel;
    private JList newsFeed;

    public NewsFeedObserver(DefaultListModel newsFeedModel, JList newsFeed) {
        this.newsFeedModel = newsFeedModel;
        this.newsFeed = newsFeed;
    }
    
    @Override
    public void update(Subject subject) {
        if (User.getState() == 1) {
        if (subject instanceof User) {
            User user = (User) subject;
            int index = user.getNewsFeed().size() - 1;
            System.out.println("index: " + index);
            String newMessage = user.getNewsFeed().get(index).getMessage();
            newsFeedModel.addElement(newMessage);
            newsFeed.setSelectedIndex(index);
            newsFeed.ensureIndexIsVisible(index);            
        }
        }
    }
    
}
