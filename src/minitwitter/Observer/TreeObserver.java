/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter.Observer;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import minitwitter.Subject.Subject;

/**
 *
 * @author MingKie
 */
public class TreeObserver implements Observer {
    
    private JTree tree;
    private DefaultTreeModel treeModel;
    
    public TreeObserver(JTree tree, DefaultTreeModel treeModel) {
        this.tree = tree;
        this.treeModel = treeModel;
    }

    @Override
    public void update(Subject subject) {
        display();
    }
    
    public void display() { 
        tree.setVisible(true);
    }
    
    public void add() {
        
    }
    
    public void reload() {
        
    }
    
}
