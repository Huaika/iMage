package org.iMage.iTiler.gui;

import javax.swing.*;

public class Main {

    /**
     * Create the GUI and show it.
     */
    private static void createAndShowGUI() {
        //setting the lookAndFeel
        JFrame.setDefaultLookAndFeelDecorated(true);
        //create and set up the window
        new MainFrame();

    }

    public static void main(String[] args) {
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}
