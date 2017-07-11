/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter.GUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import minitwitter.Group;
import minitwitter.Observer.TreeObserver;
import minitwitter.TwitterMessage;
import minitwitter.User;
import minitwitter.UserGroup;
import minitwitter.Visitor.SizeVisitor;

/**
 *
 * @author MingKie
 */
public class AdminControlPanel extends javax.swing.JFrame {

    private static AdminControlPanel instance;
    private UserGroup rootGroup;
    private SizeVisitor sizeVisitor;
    private TreeObserver treeObserver;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode rootNode;
    private User userReference;
    private TwitterMessage twitterMessageReference;

    
    /**
     * Creates new form AdminControlPanel
     */
    private AdminControlPanel() {
        initComponents();
        rootGroup = new UserGroup("Root");
        userReference = new User("userReference");
        twitterMessageReference = new TwitterMessage("twitterMessageReference", 
                "This is a reference.");
        rootNode = new DefaultMutableTreeNode(rootGroup.getId());
        initalizeTree();
        treeObserver = new TreeObserver(tree, treeModel);
        sizeVisitor = new SizeVisitor();
        rootGroup.accept(sizeVisitor);
        rootGroup.attach(treeObserver);
        addNode();
        
    }

    public static synchronized AdminControlPanel getInstance() {
        if(instance == null){
        synchronized (AdminControlPanel.class) {
            if(instance == null){
                instance = new AdminControlPanel();
            }
        }
    }
    return instance;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treePane = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        addUserButton = new javax.swing.JButton();
        addGroupButton = new javax.swing.JButton();
        openUserViewButton = new javax.swing.JButton();
        showUserTotalButton = new javax.swing.JButton();
        showGroupTotalButton = new javax.swing.JButton();
        showMessagesTotalButton = new javax.swing.JButton();
        showPositivePercentageButton = new javax.swing.JButton();
        userIDTextField = new javax.swing.JTextField();
        groupIDTextField = new javax.swing.JTextField();
        warningLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treePane.setViewportView(tree);

        addUserButton.setText("Add User");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        addGroupButton.setText("Add Group");
        addGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGroupButtonActionPerformed(evt);
            }
        });

        openUserViewButton.setText("Open User View");
        openUserViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openUserViewButtonActionPerformed(evt);
            }
        });

        showUserTotalButton.setText("Show User Total");
        showUserTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUserTotalButtonActionPerformed(evt);
            }
        });

        showGroupTotalButton.setText("Show Group Total");
        showGroupTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGroupTotalButtonActionPerformed(evt);
            }
        });

        showMessagesTotalButton.setText("Show Messages Total");
        showMessagesTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMessagesTotalButtonActionPerformed(evt);
            }
        });

        showPositivePercentageButton.setText("Show Positive %");
        showPositivePercentageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPositivePercentageButtonActionPerformed(evt);
            }
        });

        userIDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userIDTextField.setToolTipText("");

        groupIDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        warningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(treePane, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showMessagesTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showPositivePercentageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showUserTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showGroupTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(groupIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(openUserViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(groupIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openUserViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showUserTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showGroupTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showMessagesTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showPositivePercentageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(treePane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openUserViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openUserViewButtonActionPerformed
        warningLabel.setText("");
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) 
                tree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            String ID = selectedNode.toString();
            rootGroup.findUserGroup(ID);
            UserGroup.getUserGroup();
            boolean isUser = !UserGroup.isFoundUserGroup();
            if (isUser) {
                new UserView(ID, rootGroup);
            } else {
                warningLabel.setText("Select a User");
            }
        } else {
            warningLabel.setText("Select a User");
        }
        
    }//GEN-LAST:event_openUserViewButtonActionPerformed

    private void showUserTotalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUserTotalButtonActionPerformed
        sizeVisitor.visitUser(userReference);
        createDialog("User Total", "User Total: ", sizeVisitor.getUserSize());
    }//GEN-LAST:event_showUserTotalButtonActionPerformed

    private void showGroupTotalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGroupTotalButtonActionPerformed
        sizeVisitor.visitGroup(rootGroup);
        createDialog("Group Total", "Group Total: ", sizeVisitor.getUserGroupSize());
    }//GEN-LAST:event_showGroupTotalButtonActionPerformed

    private void showMessagesTotalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMessagesTotalButtonActionPerformed
        sizeVisitor.visitTwitterMessage(twitterMessageReference);
        createDialog("Message Total", "Message Total: ", sizeVisitor.getMessageSize());
    }//GEN-LAST:event_showMessagesTotalButtonActionPerformed

    private void showPositivePercentageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPositivePercentageButtonActionPerformed
        sizeVisitor.visitTwitterMessage(twitterMessageReference);
        double positivePercent = 0;
        System.out.println("Message Total: " + sizeVisitor.getMessageSize());
        System.out.println("Positive " + sizeVisitor.getPositiveMessageSize());
        if (sizeVisitor.getMessageSize() > 0) {
           positivePercent = ((sizeVisitor.getPositiveMessageSize() * 1.0) / 
                sizeVisitor.getMessageSize()) * 100;
        }
        createDialog("Positive %", "Positive %: ", positivePercent);
    }//GEN-LAST:event_showPositivePercentageButtonActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        addElement(userIDTextField, true);       
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void addGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGroupButtonActionPerformed
        addElement(groupIDTextField, false);
    }//GEN-LAST:event_addGroupButtonActionPerformed
    
    public void addElement(JTextField textField, boolean isAddUser) {
        warningLabel.setText("");
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) 
                tree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            String selectedID = selectedNode.toString();
            rootGroup.findUserGroup(selectedID);
            UserGroup selectedGroup = UserGroup.getUserGroup();
            if (UserGroup.isFoundUserGroup()) {
                if (!textField.getText().trim().equals("")) {
                    String newID = textField.getText();
                    if (!rootGroup.search(newID)) {
                        if (isAddUser) {
                            User user = new User(newID);
                            User.increaseUserSize();
                            DefaultMutableTreeNode newNode = 
                                    new DefaultMutableTreeNode(user.getId());
                            rootGroup.add(user, selectedNode, newNode);
                            textField.setText("");
                        } else {
                            UserGroup userGroup = new UserGroup(newID);
                            DefaultMutableTreeNode newNode = 
                                new DefaultMutableTreeNode(userGroup.getId());
                            rootGroup.add(userGroup, selectedNode, newNode);
                            textField.setText("");
                        }
                    } else {
                        warningLabel.setText("The ID already exists");
                    }                   
                } else {
                    warningLabel.setText("Enter ID");
                }
            } else {
                warningLabel.setText("Select a Group");
            }
        } else {
            warningLabel.setText("Select a Group");
        }
    }
    
    private void createDialog(String title, String message, double number) {
        message = message + number;
        new InformationDialog(title, message);
    }
    
    private void initalizeTree() {    
        tree = new JTree(rootNode);
        treeModel = (DefaultTreeModel) tree.getModel();
        treePane.setViewportView(tree);

    }
    
    public void addNode() {
        UserGroup group1 = new UserGroup("group1");
        UserGroup group2 = new UserGroup("group2");
        UserGroup group3 = new UserGroup("group3");
        UserGroup group4 = new UserGroup("group4");
        UserGroup group5 = new UserGroup("group5");
 
        TwitterMessage message;
        User user2 = new User("user2");
        User.increaseUserSize();
        message = new TwitterMessage(user2.getId(), "Im good");
        user2.addMessage(message);
        TwitterMessage.increaseSize();
        
        User user3 = new User("user3");
        User.increaseUserSize();
        message = new TwitterMessage(user3.getId(), "Im user3");
        user2.addMessage(message);
        TwitterMessage.increaseSize();
        
        User user4 = new User("user4");
        User.increaseUserSize();
        message = new TwitterMessage(user3.getId(), "Im user3");
        user2.addMessage(message);
        TwitterMessage.increaseSize();
        
        User user5 = new User("user5");
        User.increaseUserSize();
        message = new TwitterMessage(user3.getId(), "Im user3");
        user2.addMessage(message);
        TwitterMessage.increaseSize();
        
        System.out.println("Message: " + TwitterMessage.getSize());
        System.out.println("Positive: " + TwitterMessage.getPositiveMessageSize());
        
        DefaultMutableTreeNode groupNode = 
                new DefaultMutableTreeNode(group1.getId());
        DefaultMutableTreeNode groupNode2 = 
                new DefaultMutableTreeNode(group2.getId());
        DefaultMutableTreeNode groupNode3 = 
                new DefaultMutableTreeNode(group3.getId());
        DefaultMutableTreeNode groupNode4 = 
                new DefaultMutableTreeNode(group4.getId());
        DefaultMutableTreeNode groupNode5 = 
                new DefaultMutableTreeNode(group5.getId());
        
        DefaultMutableTreeNode userNode2 = 
                new DefaultMutableTreeNode(user2.getId());
        DefaultMutableTreeNode userNode3 = 
                new DefaultMutableTreeNode(user3.getId());
        DefaultMutableTreeNode userNode4 = 
                new DefaultMutableTreeNode(user4.getId());
        DefaultMutableTreeNode userNode5 = 
                new DefaultMutableTreeNode(user5.getId());
        
        rootGroup.add(group1, rootNode, groupNode);
        rootGroup.add(group2, rootNode, groupNode2);
        rootGroup.add(group3, groupNode, groupNode3);
        rootGroup.add(group4, groupNode3, groupNode4);
        rootGroup.add(group5, groupNode4, groupNode5);
        rootGroup.add(user2, groupNode3, userNode2);
        rootGroup.add(user3, groupNode4, userNode3);
        rootGroup.add(user4, groupNode5, userNode4);
        rootGroup.add(user5, groupNode2, userNode5);
        
 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGroupButton;
    private javax.swing.JButton addUserButton;
    private javax.swing.JTextField groupIDTextField;
    private javax.swing.JButton openUserViewButton;
    private javax.swing.JButton showGroupTotalButton;
    private javax.swing.JButton showMessagesTotalButton;
    private javax.swing.JButton showPositivePercentageButton;
    private javax.swing.JButton showUserTotalButton;
    private javax.swing.JTree tree;
    private javax.swing.JScrollPane treePane;
    private javax.swing.JTextField userIDTextField;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
