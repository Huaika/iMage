package org.iMage.iTiler.gui;

import org.iMage.iTiler.dataBase.Database;
import org.iMage.iTiler.utils.DirectoryFilter;
import org.iMage.mosaique.base.BufferedArtImage;
import org.iMage.mosaique.base.IMosaiqueArtist;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LowerToolBar extends JPanel implements ActionListener, Observer {


    private JButton runButton;
    private JComboBox figureBox;
    private JButton showTilesButton;
    private JButton loadTilesButton;
    private JTextField widthField;
    private JTextField heightField;
    private JLabel tileSizeLabel;
    private JLabel artistLabel;
    private JFileChooser fileChooser;
    private DirectoryLoadListener directoryListener;
    private DatabaseListener dbListener;
    private WindowListener windowListener;

    private boolean tilesLoaded;


    public LowerToolBar() {

        //specifying the border
        setBorder(BorderFactory.createTitledBorder("Artistic"));

        //initiating the Components
        runButton = new JButton("run");
        figureBox = new JComboBox();
        showTilesButton = new JButton("Show Tiles");
        loadTilesButton = new JButton("Load Tiles");
        widthField = new JTextField(4);
        heightField = new JTextField(4);
        tileSizeLabel = new JLabel("Tile Size");
        artistLabel = new JLabel("Artist");
        fileChooser = new JFileChooser();

        //setting the file filter to accept only image Files
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        //adding the action listeners
        loadTilesButton.addActionListener(this);
        showTilesButton.addActionListener(this);
        runButton.addActionListener(this);

        //setting out the layout
        setLayout(new FlowLayout(FlowLayout.CENTER));

        //Setup Combo Box
        DefaultComboBoxModel figureModel = new DefaultComboBoxModel();
        figureModel.addElement("rectangle");
        figureModel.addElement("triangle");
        figureBox.setModel(figureModel);
        figureBox.setSelectedIndex(0);

        //adding the components to the toolbar
        add(tileSizeLabel);
        add(widthField);
        add(new JLabel("X"));
        add(heightField);
        add(loadTilesButton);
        add(showTilesButton);
        add(artistLabel);
        add(figureBox);
        add(runButton);
    }

    /**
     * sets the directory listener of the class
     * @param directoryListener the  directory listener
     */
    public void setDirectoryListener(DirectoryLoadListener directoryListener) {
        this.directoryListener = directoryListener;
    }

    /**
     * sets the db listener of the class
     * @param dbListener    the db listener
     */
    public void setDataBaseListener(DatabaseListener dbListener) {
        this.dbListener = dbListener;
    }

    /**
     * sets the window listener of the class
     * @param windowListener the passed window listener
     */
    public void setWindowListener(WindowListener windowListener) {
        this.windowListener = windowListener;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == loadTilesButton) {
            System.out.println("loading the tiles");
            if (directoryListener != null) {
                fileChooser.showOpenDialog(LowerToolBar.this);
                directoryListener.emitDirectory(fileChooser.getSelectedFile());
            }
            setTilesLoaded(true);
        }
        else if(clicked == showTilesButton) {
            if (areTilesLoaded()) {
                System.out.println("tiles are loaded and showing tiles proceeds");
                windowListener.displayWindow();
            }
        }
        else if (clicked == runButton) {
            if (dbListener != null) {
                System.out.println("run button clicked");
                String width = widthField.getText();
                String height = heightField.getText();
                String artist = (String) figureBox.getSelectedItem();
                dbListener.addAnalysisInfoTo_DB(new String[] {width, height, artist});
            }
        }
    }


    public boolean areTilesLoaded() {
        return tilesLoaded;
    }

    public void setTilesLoaded(boolean tilesLoaded) {
        this.tilesLoaded = tilesLoaded;
    }

    @Override
    public void update(BufferedArtImage inputImage, List<BufferedArtImage> mosaiqueTiles, int tileWidth, int tileHeight, IMosaiqueArtist artist) {

    }
}













