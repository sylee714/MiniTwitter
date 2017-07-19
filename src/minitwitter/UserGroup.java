package minitwitter;

import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import minitwitter.Subject.Subject;
import minitwitter.Visitor.Visitor;

/**
 * This class represents a user group. It has all the needed fields and methods
 * to create and maintain the data of a user group.
 * @author Seungyun Lee
 */
public class UserGroup extends Subject implements Member {
    
    // Total number of groups
    private static int size = 0;
    private static int numberOfAppearance = 0;
    private static List<String> userGroupIDs = new ArrayList<>();
    private static int numberOfInvalidUserGroupID;
    // If there is a member with the given ID
    private static boolean alreadyExist = false;
    // If it found a user group with the given name
    private static boolean foundUserGroup = false;
    // The user group that user selected in the tree
    private static UserGroup userGroup = null;
    // The node that user selected in the tree
    private static DefaultMutableTreeNode selectedNode;
    // The node that is newly created
    private static DefaultMutableTreeNode newNode;
    private List<Member> children;
    
    /**
     * This is the constructor that creates a user group with the given ID.
     * @param ID, unique ID
     */
    public UserGroup(String ID) {
        setID(ID);
        if (!userGroupIDs.contains(ID)) {
            userGroupIDs.add(ID);   
        }
        children = new ArrayList<>();
        size++;
    }
    
    @Override
    public boolean search(String ID) {
        boolean found = false;
        if (getID().equals(ID)) {
            found = true;
        } else {
            for (Member child : children) {                                
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
        if (getID().equals(ID)) {
            foundUserGroup = true;
            userGroup = this;
        } else {
            for (Member child : children) {
                if (child instanceof UserGroup) {                  
                    child.findUserGroup(ID);                    
                }
            }
        }
    }
    
    @Override
    public User findUser(String ID) {
        User user = null;
        for (Member child : children) {
           if (child.findUser(ID) != null) {
               user = child.findUser(ID);
           }
        }
        return user;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visitGroup(this);
        for (Member child: children) {
            child.accept(visitor);
        }
    }
    
    /**
     * This method returns the value of isFoundUserGroup.
     * @return true if there is a user group with the given ID; otherwise, false
     */
    public static boolean isFoundUserGroup() {
        boolean tempFound = foundUserGroup;
        foundUserGroup = false;
        return tempFound;
    }
    
    /**
     * This method returns the user group with the given ID.
     * @return user group with the given ID
     */
    public static UserGroup getUserGroup() {
        UserGroup tempUserGroup = userGroup;
        userGroup = null;
        return tempUserGroup;
    }
    
    /**
     * This method adds a child to the children list. Notify observers
     * to update the view.
     * @param child, child can be either a user or a user group
     */
    public void addChild(Member child) {
        children.add(child);
        notifyObservers();
    }

    /**
     * This method returns the list of children.
     * @return list of children
     */
    public List<Member> getChildren() {
        return children;
    }

    /**
     * This method sets the list of children with the given list.
     * @param children, list of children
     */
    public void setChildren(List<Member> children) {
        this.children = children;
    }
    
    /**
     * This method adds a child to the selected parent.
     * @param child, newly created member
     * @param selectedNode, selected node from the tree
     * @param newNode, newly created node which is the child
     */
    public void add(Member child, DefaultMutableTreeNode selectedNode, 
            DefaultMutableTreeNode newNode) {    
        // If selected node is the root
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

    /**
     * This method returns the total number of user groups.
     * @return total number of user groups
     */
    public static int getSize() {
        return size;
    }

    /**
     * This method sets the total number of user groups.
     * @param size, total number of user groups
     */
    public static void setSize(int size) {
        UserGroup.size = size;
    }

    public static int getNumberOfAppearance() {
        return numberOfAppearance;
    }

    public static void setNumberOfAppearance(int numberOfAppearance) {
        UserGroup.numberOfAppearance = numberOfAppearance;
    }
    
    public static void addNumberOfAppearance(int number) {
        numberOfAppearance = numberOfAppearance + number;
    }
    
    public static void resetNumberOfAppearance() {
        numberOfAppearance = 0;
    }
    
    /**
     * This method returns the selected node from the tree.
     * @return selected node from the tree
     */
    public static DefaultMutableTreeNode getSelectedNode() {
        return selectedNode;
    }

    /**
     * This method sets the selected node with the given one.
     * @param selectedNode, selected node from the tree
     */
    public static void setSelectedNode(DefaultMutableTreeNode selectedNode) {
        UserGroup.selectedNode = selectedNode;
    }

    public static List<String> getUserGroupIDs() {
        return userGroupIDs;
    }

    public static void setUserGroupIDs(List<String> userGroupIDs) {
        UserGroup.userGroupIDs = userGroupIDs;
    }
    
    /**
     * This method return the node that is newly created which will be added
     * to the tree.
     * @return newly created node
     */
    public static DefaultMutableTreeNode getNewNode() {
        return newNode;
    }

    /**
     * This method sets the new node with the given one.
     * @param newNode, new node that is created
     */
    public static void setNewNode(DefaultMutableTreeNode newNode) {
        UserGroup.newNode = newNode;
    }

    /**
     * This method returns the child with the given ID
     * @param ID, a unique ID
     * @return user with the given ID
     */
    public User getChild(String ID) {
        User user = null;
        for(int i = 0; i < children.size(); ++i) {
            if (children.get(i).getID().equals(ID)) {
                user = (User) children.get(i);
            }
        }
        return user;
    }

    public static int getNumberOfInvalidID() {
        return numberOfInvalidUserGroupID;
    }

    public static void setNumberOfInvalidID(int numberOfInvalidID) {
        UserGroup.numberOfInvalidUserGroupID = numberOfInvalidID;
    }
    
    @Override
    public void checkDuplicate(String ID) {
        if (getID().contains(" ")) {
            numberOfAppearance++;
        }
        for (int i = 0; i < children.size(); ++i) {
            children.get(i).checkDuplicate(ID);
        }
    }
    
    @Override
    public void checkSpace() {
        if (getID().contains(" ")) {
            numberOfInvalidUserGroupID++;
        }
        for (int i = 0; i < children.size(); ++i) {
            children.get(i).checkSpace();
        }
    }
    
    public static void reset() {
        numberOfInvalidUserGroupID = 0;
    }
           
}
