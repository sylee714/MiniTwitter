package minitwitter;

import java.util.ArrayList;
import java.util.List;
import minitwitter.Subject.Subject;
import minitwitter.Visitor.Visitor;


/**
 * This class represents a user. It has all the needed fields and methods
 * to create and maintain the data of a user.
 * @author Seungyun Lee
 */
public class User extends Subject implements Member{
    // The one who performed an action: either following someone
    // or posting a message
    private static User mainUser;
    // 0 for followed someone and 1 for added a message
    private static int state;
    private static int numberOfInvalideUserID;
    // User that current user has chose to follow
    private static User followingUser;
    private static User lastUpdatedUser = null;
    private static boolean checkLastUpdatedUser = false;
    // Total number of users
    private static int userSize = 0;
    private static int numberOfAppearance = 0;
    private List<User> followers;
    // List of users that current user is following
    private List<User> followings;
    private List<TwitterMessage> newsFeed;
    private static String lastUpdateUserID = "NO ONE";
    private static List<String> userIDs = new ArrayList<>();
    private long lastUpdateTime;
    
    /**
     * This is the constructor that creates a user with the given ID.
     * @param ID
     */
    public User(String ID) {
        setID(ID);
        if (!userIDs.contains(ID)) {
            userIDs.add(ID);   
        }
        followers = new ArrayList<>();
        followings = new ArrayList<>();
        newsFeed = new ArrayList<>();
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visitUser(this);
        for (int i = 0; i < newsFeed.size(); ++i) {
            newsFeed.get(i).accept(visitor);
        }
    }

    @Override
    public boolean search(String ID) {
        return getID().equals(ID);
    }
    
    @Override
    public User findUser(String ID) {
        User user = null;
        if (getID().equals(ID)) {
            user = this;
            followingUser = user;
        }
        return user;
    }
    
    // It's not being used by User class.
    @Override
    public void findUserGroup(String ID) {
        
    }
    
    public static void reset() {
        numberOfInvalideUserID = 0;
    }

    public static User getLastUpdatedUser() {
        return lastUpdatedUser;
    }

    public static void setLastUpdatedUser(User lastUpdatedUser) {
        User.lastUpdatedUser = lastUpdatedUser;
    }

    /**
     * This method sets the main user.
     * @param user, the one who is following someone or typing a new message
     */
    public static void setMainUser(User user) {
        mainUser = user;
    }
    
    /**
     * This method increases the number of users.
     */
    public static void increaseUserSize() {
        userSize++;
    }
    
    /**
     * This method returns the user that current user is trying to follow.
     * @return user that current user is trying to follow
     */
    public static User getFollowingUser() {
        return followingUser;
    }
    
    /**
     * This method returns what state User class is in.
     * @return 0 for followed someone and 1 for added a message
     */
    public static int getState() {
        return state;
    }

    /**
     * This method adds a new message to the news feed. Notify observers
     * to update the view.
     * @param message, message that current user typed
     */
    public void addMessage(TwitterMessage message, long updatedTime) {
        // Sets state as 1
        state = 1;
        newsFeed.add(message);
        setLastUpdateTime(System.currentTimeMillis());
        checkUpdatedUser();
        // Checks if the one who's calling the method is the current user.
        // If it's not do not go thru their followers.
        if (mainUser.equals(this)) {
            for (int i = 0; i < followers.size(); ++i) {
                followers.get(i).addMessage(message, updatedTime);
            }
        }
        notifyObservers();
    }
    
    private void checkUpdatedUser() {
        if (!lastUpdatedUser.equals(null)) {
            System.out.println("Last updated user is not null");
            //lastUpdatedUser = this;
            setCheckLastUpdatedUser(true);
            if (lastUpdatedUser.getLastUpdateTime() < this.getLastUpdateTime()) {
                lastUpdatedUser = this;
                lastUpdateUserID = lastUpdatedUser.getID();
                setCheckLastUpdatedUser(true);
                System.out.println("New last updated user");
            }
        } else if (lastUpdatedUser.equals(null)) {
            System.out.println("Last user is set");
            setCheckLastUpdatedUser(true);
            lastUpdatedUser = this;
            lastUpdateUserID = lastUpdatedUser.getID();
        }
    }

    public static boolean isCheckLastUpdatedUser() {
        return checkLastUpdatedUser;
    }

    public static void setCheckLastUpdatedUser(boolean checkLastUpdatedUser) {
        User.checkLastUpdatedUser = checkLastUpdatedUser;
    }
    
    
    //public static boolean checkLastUpdatedUser() {
      //  return lastUpdatedUser.equals(null);
    //}
    
    /**
     * This method adds a follower to the follower list.
     * @param follower, new follower
     */
    public void addFollower(User follower) {
        followers.add(follower);
    }
    
    /**
     * This method adds a user to the following list that current user
     * decided to follow.
     * @param following, user that current user followed
     */
    public void addFollowings(User following) {
        state = 0;
        followings.add(following);
        notifyObservers();
    }
    
    /**
     * This method returns the total number of users.
     * @return total number of users
     */
    public static int getSize() {
        return userSize;
    }

    /**
     * This method sets the total number of users.
     * @param size, total number of users
     */
    public static void setSize(int size) {
        User.userSize = size;
    }

    public static String getLastUpdateUserID() {
        return lastUpdateUserID;
    }

    public static void setLastUpdateUserID(String lastUpdateUserID) {
        User.lastUpdateUserID = lastUpdateUserID;
    }
  
    /**
     * This method returns the list of followers.
     * @return list of followers
     */
    public List<User> getFollowers() {
        return followers;
    }

    /**
     * This method sets the list of followers with the given list.
     * @param followers, list of followers
     */
    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    /**
     * This method returns the list of user that a user is following.
     * @return list of users that a user is following
     */
    public List<User> getFollowings() {
        return followings;
    }

    /**
     * This method sets the list of users that a user is following.
     * @param followings, list of users that a user is following
     */
    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }

    public static int getNumberOfAppearance() {
        return numberOfAppearance;
    }

    public static void setNumberOfAppearance(int numberOfAppearance) {
        User.numberOfAppearance = numberOfAppearance;
    }
    
    public static void addNumberOfAppearance(int number) {
        numberOfAppearance = numberOfAppearance + number;
    }
    
    public static void resetNumberOfAppearance() {
        numberOfAppearance = 0;
    }
    
    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    
    /**
     * This method returns the list of Twitter messages which is a news feed.
     * @return news feed
     */
    public List<TwitterMessage> getNewsFeed() {
        return newsFeed;
    }

    public static List<String> getUserIDs() {
        return userIDs;
    }

    public static void setUserIDs(List<String> userIDs) {
        User.userIDs = userIDs;
    }
    
    /**
     * This method sets the news feed with the given list.
     * @param newsFeed, news feed
     */
    public void setNewsFeed(List<TwitterMessage> newsFeed) {
        this.newsFeed = newsFeed;
    }

    public static int getNumberOfInvalideUserID() {
        return numberOfInvalideUserID;
    }

    public static void setNumberOfInvalideUserID(int numberOfInvalideUserID) {
        User.numberOfInvalideUserID = numberOfInvalideUserID;
    }
    
    @Override
    public void checkDuplicate(String ID) {
        if (getID().equals(ID)) {
            numberOfAppearance++;
        }
    }
    
    @Override
    public void checkSpace() {
        if (getID().contains(" ")) {
            numberOfInvalideUserID++;
        }
    }
    
}
