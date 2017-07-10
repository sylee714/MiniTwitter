/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import java.util.ArrayList;
import java.util.List;
import minitwitter.Visitor.SizeVisitor;

/**
 *
 * @author MingKie
 */
public class Test {
    
    public static void main(String[] args) {
        
        UserGroup root = new UserGroup("Root");
        
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user4 = new User("user4");
        User user5 = new User("user5");
        
        UserGroup userGroup1 = new UserGroup("userGroup1");
        userGroup1.add(user3);
        userGroup1.add(user4);
        
        UserGroup userGroup2 = new UserGroup("userGroup2");
        UserGroup userGroup3 = new UserGroup("userGroup3");
        UserGroup userGroup4 = new UserGroup("userGroup4");
        
        
        //root.add(user1);
        //root.add(user2);
        //root.add(user5);
        userGroup1.add(userGroup2);
        userGroup2.add(userGroup3);
        root.add(userGroup1);
        root.add(userGroup4);
        userGroup2.add(user1);
        userGroup2.add(user2);
        userGroup3.add(user5);
        
        root.display();
        
        SizeVisitor sizeVisitor = new SizeVisitor();
        root.accept(sizeVisitor);
        
        System.out.println("# of users: " + sizeVisitor.getUserSize());
        System.out.println("# of user groups: " + sizeVisitor.getUserGroupSize());

        root.foundUserGroup("Root");
        System.out.println(root.isFound());
        root.foundUserGroup("userGroup1");
        System.out.println(root.isFound());
        root.foundUserGroup("userGroup2");
        System.out.println(root.isFound());
        root.foundUserGroup("userGroup3");
        System.out.println(root.isFound());
        root.foundUserGroup("userGroup4");
        System.out.println(root.isFound());
        root.foundUserGroup("userGroup5");
        System.out.println(root.isFound());
        root.foundUserGroup("user5");
        System.out.println(root.isFound());
        
        
    }
    
}
