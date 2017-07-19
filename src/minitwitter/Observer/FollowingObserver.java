package minitwitter.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import minitwitter.Subject.Subject;
import minitwitter.User;

/**
 * This class represents a following observer. Whenever a user follows another
 * user, it updates current following list view.
 * @author Seungyun Lee
 */
public class FollowingObserver implements Observer {
    
    private DefaultListModel followingModel;
    private JList currentFollowing;
    
    /**
     * This is the constructor to create a following observer.
     * @param followingModel, list model to update the view
     * @param currentFollowing, JList that shows all the users that 
     *                          the user is following 
     */
    public FollowingObserver(DefaultListModel followingModel, 
            JList currentFollowing) {
       this.followingModel = followingModel;
       this.currentFollowing = currentFollowing; 
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof User) {
            if (User.getState() == 0) {
                // User that notified this observer
                User user = (User) subject;
                // Get the user that the current user clicked to follow
                User followingUser = User.getFollowingUser();
                // Add at the end
                followingModel.addElement(followingUser.getID());
                // Get the last index
                int index = user.getFollowings().size() - 1;
                // Select the last index and make it visible 
                currentFollowing.setSelectedIndex(index);
                currentFollowing.ensureIndexIsVisible(index);
            }
        }
    }
    
}
