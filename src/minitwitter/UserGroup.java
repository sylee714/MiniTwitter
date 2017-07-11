/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
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
    private static boolean alreadyExist = false;
    private static User selectedUser = null;
    private static boolean foundUserGroup = false;
    private static UserGroup userGroup = null;
    private static UserGroup parent = null;
    private static DefaultMutableTreeNode selectedNode;
    private static DefaultMutableTreeNode newNode;
    
    
    public UserGroup(String ID) {
        this.ID = ID;
        children = new ArrayList<>();
        size++;
    }
    
    public static boolean isFoundUserGroup() {
        boolean tempFound = foundUserGroup;
        foundUserGroup = false;
        return tempFound;
    }
    
    public static UserGroup getUserGroup() {
        UserGroup tempUserGroup = userGroup;
        userGroup = null;
        return tempUserGroup;
    }
    
    @Override
    public boolean search(String ID) {
        boolean found = false;
        if (this.ID.equals(ID)) {
            found = true;
        } else {
            for (Group child : children) {                                
                 if (child.search(ID)) {
                     found = true;
                     break;
                 } 
                     
            } 
        }
        return found;
    }
    
    @Override
    public void findUserGroup(String ID) {
        if (this.ID.equals(ID)) {
            foundUserGroup = true;
            userGroup = this;
        } else {
            for (Group child : children) {
                if (child instanceof UserGroup) {                  
                    child.findUserGroup(ID);                    
                }
            }
        }
    }
    
    @Override
    public boolean findParent(String ID) {
        boolean success =  false;
        for (Group child : children) {
            if (child.findParent(ID)) {
                System.out.println(this.ID);
                parent = this;
                success = true;
                break;
            }
        }
        return success;
    }
    
    @Override
    public User findUser(String ID) {
        User user = null;
        for (Group child : children) {
           if (child.findUser(ID) != null) {
               user = child.findUser(ID);
           }
        }
        return user;
    }
    
    public static UserGroup getParent() {
        UserGroup tempParent = parent;
        parent = null;
        return tempParent;
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
    
    public void add(Group child, DefaultMutableTreeNode selectedNode, 
            DefaultMutableTreeNode newNode) {
        
        if (!selectedNode.toString().equals("Root")) {
            UserGroup.selectedNode = selectedNode;
            UserGroup.newNode = newNode;
            findUserGroup(selectedNode.toString());
            getUserGroup().children.add(child); 
            notifyObservers();
        } else {
            children.add(child);
            UserGroup.selectedNode = selectedNode;
            UserGroup.newNode = newNode;    
            notifyObservers();  
        }
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

    public static DefaultMutableTreeNode getSelectedNode() {
        return selectedNode;
    }

    public static void setSelectedNode(DefaultMutableTreeNode selectedNode) {
        UserGroup.selectedNode = selectedNode;
    }

    public static DefaultMutableTreeNode getNewNode() {
        return newNode;
    }

    public static void setNewNode(DefaultMutableTreeNode newNode) {
        UserGroup.newNode = newNode;
    }

    public User getChild(String ID) {
        User user = null;
        for(int i = 0; i < children.size(); ++i) {
            if (children.get(i).getId().equals(ID)) {
                user = (User) children.get(i);
            }
        }
        return user;
    }
        
    
    
}
