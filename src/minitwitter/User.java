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
    
    private static int size = 0;
    private String ID;
    private List<String> followers;
    private List<String> followings;
    private List<TwitterMessage> newsFeed;
    
    public User(String ID) {
        size++;
        this.ID = ID;
        followers = new ArrayList<>();
        followings = new ArrayList<>();
        newsFeed = new ArrayList<>();
    }

    public void addMessage(TwitterMessage message) {
        newsFeed.add(message);
    }
    
    public void addFollower(String follower) {
        followers.add(follower);
    }
    
    public void addFollowings(String following) {
        followings.add(following);
    }
    
    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        User.size = size;
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public List<String> getFollowings() {
        return followings;
    }

    public void setFollowings(List<String> followings) {
        this.followings = followings;
    }

    public List<TwitterMessage> getNewsFeed() {
        return newsFeed;
    }

    public void setNewsFeed(List<TwitterMessage> newsFeed) {
        this.newsFeed = newsFeed;
    }
    
    @Override
    public void foundUserGroup(String ID) {
        
    }

    @Override
    public void display() {
        System.out.println("User ID: " + ID);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitUser(this);
    }
}
