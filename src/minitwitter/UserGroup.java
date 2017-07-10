/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import java.util.ArrayList;
import java.util.List;
import minitwitter.Subject.Subject;
import minitwitter.Visitor.Visitor;

/**
 *
 * @author MingKie
 */
public class UserGroup extends Subject implements Group {
    
    private static int size = 0;
    private String ID;
    private List<Group> children;
    private boolean found;

    public boolean isFound() {
        return found;
    }
    
    public UserGroup(String ID) {
        this.ID = ID;
        children = new ArrayList<>();
        size++;
        found = false;
    }
    
    public void isUserGroup(String ID) {
        if (children.size() == 0) {
            found = false;
            return;
        } else {
            for (Group child : children) {
                if (child instanceof UserGroup) {
                    if (child.getId().equals(ID)) {
                        found = true;
                        return;
                    } else {
                        isUserGroup(ID);
                    }
                }
            }
        }
    }
    
    @Override
    public void foundUserGroup (String ID) {
        boolean found =  false;
        if (this.ID.equals(ID)) {
            found = true;
        } else {
            for (Group child : children) {
                if (child instanceof UserGroup) {
                    child.foundUserGroup(ID);
                }
            }
        }
        //return found;
    }

    public UserGroup() {
    }
    
    public void addChild(Group child) {
        children.add(child);
        notifyObservers();
    }
    
    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Group> getChildren() {
        return children;
    }

    public void setChildren(List<Group> children) {
        this.children = children;
    }

    @Override
    public void display() {
        System.out.println("Group ID: " + ID);
        for (Group child: children) {
            child.display();
        }
    }
    
    public void add(Group child) {
        children.add(child);
        notifyObservers();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitGroup(this);
        for (Group child: children) {
            child.accept(visitor);
        }
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        UserGroup.size = size;
    }
   
}
