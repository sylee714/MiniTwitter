/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import minitwitter.Visitor.Visitor;

/**
 *
 * @author MingKie
 */
public interface Group extends Component {
    
    public boolean search(String ID);
    
    public void setID(String ID);
    
    public String getId();
    
    @Override
    public void accept(Visitor visitor);
    
    public void display();

    public void findUserGroup(String ID);
    
    public boolean findParent(String ID);
    
    public User findUser(String ID);
}
