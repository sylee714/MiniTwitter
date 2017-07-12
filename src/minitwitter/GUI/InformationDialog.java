package minitwitter.GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class represents an information dialog that displays the given 
 * information.
 * @author Seungyun Lee
 */
public class InformationDialog {
    
    private static JDialog dialog;
    private JFrame frame;
    private JButton okButton;
    
    /**
     * This is the constructor to create an information dialog.
     * @param title, title of the information
     * @param message, message that is to be displayed
     */
    public InformationDialog(String title, String message) {
        frame = new JFrame();
        dialog = new JDialog(frame, title, true);
        dialog.setLayout(new FlowLayout());
        okButton = new JButton("OK");
        // Click ok button to close it.
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformationDialog.dialog.setVisible(false);
            }
        });
        initialize(message);
    }
    
    /**
     * This method initializes the size and the message it will display with 
     * a button.
     */
    private void initialize(String message) {
        dialog.add(new JLabel(message));
        dialog.add(okButton);
        dialog.setSize(300,100);
        dialog.setVisible(true);
    }
    
}
