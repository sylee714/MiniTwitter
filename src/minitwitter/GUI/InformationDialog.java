/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter.GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author MingKie
 */
public class InformationDialog {
    
    private static JDialog dialog;
    private JFrame frame;
    private JButton okButton;
    
    public InformationDialog(String title, String message) {
        frame = new JFrame();
        dialog = new JDialog(frame, title, true);
        dialog.setLayout(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformationDialog.dialog.setVisible(false);
            }
        });
        initialize(message);
    }
    
    private void initialize(String message) {
        dialog.add(new JLabel(message));
        dialog.add(okButton);
        dialog.setSize(300,100);
        dialog.setVisible(true);
    }
    
    
}
