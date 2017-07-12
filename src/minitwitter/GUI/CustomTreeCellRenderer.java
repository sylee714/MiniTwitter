/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter.GUI;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import minitwitter.UserGroup;

/**
 * This class is to customize the tree view in order to distinguish between
 * users and user groups.
 */
class CustomTreeCellRenderer implements TreeCellRenderer {
    
    private JLabel label;
    private UserGroup root;
    
    /**
     * This sets the label and root with the given ones.
     * @param root, root group
     */
    CustomTreeCellRenderer(UserGroup root) {
        this.root = root;
        label = new JLabel();  
    }

    @Override
    public java.awt.Component getTreeCellRendererComponent(JTree tree, Object value, 
            boolean selected, boolean expanded, boolean leaf, int row, 
            boolean hasFocus) {
        root.findUserGroup(((DefaultMutableTreeNode) value).toString());
        // Checks if it is a user group
        if (UserGroup.isFoundUserGroup()) {
            UserGroup userGroup = UserGroup.getUserGroup();
            label.setText("Group: " + userGroup.getId());
        } else {
            label.setText("User: " + value);
        }
        return label;
    }
    
}
