package minitwitter;

import minitwitter.Visitor.Visitor;

/**
 * This interface represents a member that uses program, either user or user 
 * group.
 * @author Seungyun Lee
 */
public interface Member extends Component {
    
    @Override
    public void accept(Visitor visitor);
    
    /**
     * This method search through a list of members to check if there is
     * an already existing member with the given ID.
     * @param ID, ID that user enters
     * @return true if there is a member with the same ID; otherwise, false
     */
    public boolean search(String ID);
    
    
    /**
     * This method sets the ID of a member.
     * @param ID, a unique ID
     */
    //public void setID(String ID);
    
    /**
     * This method returns the ID of a member.
     * @return member's ID
     */
    public String getID();

    /**
     * This method finds if there is a user group with the given ID.
     * @param ID, ID that user enters
     */
    public void findUserGroup(String ID);
    
    /**
     * This method finds if there is a user with the given ID.
     * @param ID, ID that user enters
     * @return the user with the given ID
     */
    public User findUser(String ID);
    
    public void checkDuplicate(String ID);
    
    public void checkSpace();
    
}
