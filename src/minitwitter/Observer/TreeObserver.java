package minitwitter.Observer;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import minitwitter.Subject.Subject;
import minitwitter.UserGroup;

/**
 * This class represents TreeObserver that updates the view of JTree
 * whenever a new user or a new user group is added.
 * @author Seungyun Lee
 */
public class TreeObserver implements Observer {
    
    private JTree tree;
    private DefaultTreeModel treeModel;
    
    /**
     * This is the constructor to create a tree observer.
     * @param tree, tree that shows all the users and user groups
     * @param treeModel, JTree model to update the view
     */
    public TreeObserver(JTree tree, DefaultTreeModel treeModel) {
        this.tree = tree;
        this.treeModel = treeModel;
    }

    @Override
    public void update(Subject subject) { 
        if (subject instanceof UserGroup) {
            // Selected node from the tree
            DefaultMutableTreeNode selectedNode = UserGroup.getSelectedNode();
            // New node that is created
            DefaultMutableTreeNode newNode = UserGroup.getNewNode();
            // Add the new one to the end of the selected node
            selectedNode.add(newNode);
            // Reload to view the updated one
            treeModel.reload();          
        }
    }
 
}
