/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import java.util.ArrayList;
import java.util.List;
import minitwitter.Subject.Subject;
import minitwitter.Visitor.Visitor;


/**
 *
 * @author MingKie
 */
public class User extends Subject implements Group{
    
    // 0 for followed someone and 1 for added a message.
    private static int state;
    private static User followingUser;
    private static int userSize = 0;
    private String ID;
    private List<User> followers;
    private List<User> followings;
    private List<TwitterMessage> newsFeed;
    
    public User(String ID) {
        this.ID = ID;
        followers = new ArrayList<>();
        followings = new ArrayList<>();
        newsFeed = new ArrayList<>();
    }
    
    public static void increaseUserSize() {
        userSize++;
    }
    
    public static User getFollowingUser() {
        return followingUser;
    }
    
    public static int getState() {
        return state;
    }

    public void addMessage(TwitterMessage message) {
        state = 1;
        newsFeed.add(message);
        for (int i = 0; i < followers.size(); ++i) {
            followers.get(i).addMessage(message);
        }
        notifyObservers();
    }
    
    public void addFollower(User follower) {
        followers.add(follower);
    }
    
    public void addFollowings(User following) {
        state = 0;
        followings.add(following);
        notifyObservers();
    }
    
    public static int getSize() {
        return userSize;
    }

    public static void setSize(int size) {
        User.userSize = size;
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }

    public List<TwitterMessage> getNewsFeed() {
        return newsFeed;
    }

    public void setNewsFeed(List<TwitterMessage> newsFeed) {
        this.newsFeed = newsFeed;
    }
    
    @Override
    public void findUserGroup(String ID) {
        
    }

    @Override
    public void display() {
        System.out.println("User ID: " + ID);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitUser(this);
        for (int i = 0; i < newsFeed.size(); ++i) {
            System.out.println("message accpeted");
            newsFeed.get(i).accept(visitor);
        }
    }

    @Override
    public boolean search(String ID) {
            return this.ID.equals(ID);
    }
    
    
    @Override
    public boolean findParent(String ID) {
        return this.ID.equals(ID);
    }
    
    @Override
    public User findUser(String ID) {
        User user = null;
        if (this.ID.equals(ID)) {
            user = this;
            followingUser = user;
        }
        return user;
    }
}
