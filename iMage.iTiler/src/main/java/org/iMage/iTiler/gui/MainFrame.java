package org.iMage.iTiler.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    /**
     * the toolbar which is at the lower part of the frame
     */
    private LowerToolBar lowerToolBar;

    /**
     * the toolbar at the middle of the frame
     */
    private MiddleToolBar middleToolBar;

    public MainFrame() {
        super("iTiler");

        //setup the Layout-Manager
        setLayout(new BorderLayout());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(850, 450));
        setResizable(false);  // makes the frame no more resizeable

        //initiating the components
        lowerToolBar = new LowerToolBar();
        middleToolBar = new MiddleToolBar();

        //adding the components into the frame
        add(lowerToolBar, BorderLayout.PAGE_END);
        add(middleToolBar, BorderLayout.CENTER);

        //Display the window
        pack();
        setVisible(true);

    }



}
