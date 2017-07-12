package minitwitter.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import minitwitter.Subject.Subject;
import minitwitter.User;

/**
 * This class represents a news feed observer. Whenever a new message is added,
 * it updates JList of the user that typed the message and its followers'.
 * @author Seungyun Lee
 */
public class NewsFeedObserver implements Observer {
    
    private DefaultListModel newsFeedModel;
    private JList newsFeed;

    /**
     * This is the constructor to create a news feed observer. 
     * @param newsFeedModel, list model to update the view
     * @param newsFeed, JList that shows all the messages 
     */
    public NewsFeedObserver(DefaultListModel newsFeedModel, JList newsFeed) {
        this.newsFeedModel = newsFeedModel;
        this.newsFeed = newsFeed;
    }
    
    @Override
    public void update(Subject subject) {
        if (User.getState() == 1) {
            if (subject instanceof User) {
                // User that notified this observer
                User user = (User) subject;
                // Get the last index
                int index = user.getNewsFeed().size() - 1;
                String newMessage = user.getNewsFeed().get(index).getMessage();
                // Add at the end
                newsFeedModel.addElement(newMessage);
                // Select the last index and make it visible 
                newsFeed.setSelectedIndex(index);
                newsFeed.ensureIndexIsVisible(index);            
            }
        }
    }
    
}
