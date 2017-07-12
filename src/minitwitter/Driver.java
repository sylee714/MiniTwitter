package minitwitter;

import java.util.ArrayList;
import java.util.List;
import minitwitter.GUI.AdminControlPanel;

/**
 * This class has the main method to run the program.
 * @author Seungyun Lee
 */
public class Driver {
    
    /**
     * This is the main method that creates the AdminControlPanel.
     * It only creates one instance since singleton design pattern is used.
     * @param args
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            AdminControlPanel instance = AdminControlPanel.getInstance();
            @Override
            public void run() {
                instance.setVisible(true);
            }
        });
    }
    
}
