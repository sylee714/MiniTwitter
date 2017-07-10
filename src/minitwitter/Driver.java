/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import java.util.ArrayList;
import java.util.List;
import minitwitter.GUI.AdminControlPanel;

/**
 *
 * @author MingKie
 */
public class Driver {
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            AdminControlPanel instance = AdminControlPanel.getInstance();
            public void run() {
                instance.setVisible(true);
            }
        });
    }
    
}
