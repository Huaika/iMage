package org.iMage.iTiler.dataBase;

import org.iMage.iTiler.utils.Utilities;
import org.iMage.mosaique.base.BufferedArtImage;
import org.iMage.mosaique.base.IMosaiqueArtist;
import org.iMage.mosaique.rectangle.RectangleArtist;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Database {


    private BufferedArtImage inputImage;
    private List<BufferedArtImage> mosaiqueImages;
    private int tileWidth;
    private int tileHeight;
    private IMosaiqueArtist artist;
    private boolean readyToExecute;


    public Database() {
        mosaiqueImages = new ArrayList<>();
    }


    /**
     * submits the inputImage into the database
     * @param inputImage
     */
    public void submitInputImage(BufferedImage inputImage) {
        this.inputImage = Utilities.convertToBufferedArtSingle(inputImage);
    }

    /**
     * submits a list of images into the database
     * @param mosaiqueImages    the images to submit
     */
    public void submitImages(List<BufferedImage> mosaiqueImages) {
        this.mosaiqueImages.addAll(Utilities.convertToBufferedArt(mosaiqueImages));
    }


    /**
     * submits the tile height value transformed to a String
     * @param tileHeight    the tile height value as String
     */
    public void submitTileHeight(String tileHeight) {
        this.tileHeight = Integer.parseInt(tileHeight);
    }

    /**
     * submits the width value transformed to a int
     * @param tileWidth     the width value as String
     */
    public void submitTileWidth(String tileWidth) {
        this.tileWidth = Integer.parseInt(tileWidth);
    }

    /**
     * submits the artist selected by transforming it parting from a String
     * @param artist    the artist as String
     */
    public void submitArtist(String artist) {
        if (artist.equals("rectangle")) {
            this.artist = new RectangleArtist(mosaiqueImages, tileWidth, tileHeight);
        } else if (artist.equals("triangle")) {
            // TODO triangle artist
        }
    }


    /**
     * analyses if the db has enough info to proceed with the execution
     * @return  if th info is full then true, else false
     */
    public boolean isReadyToExecute() {
        if (inputImage!= null && artist != null && mosaiqueImages != null && tileWidth != 0 && tileHeight != 0) {
            return true;
        }
        return false;
    }

    public BufferedArtImage getInputImage() {
        return inputImage;
    }

    public List<BufferedArtImage> getMosaiqueImages() {
        return mosaiqueImages;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public IMosaiqueArtist getArtist() {
        return artist;
    }
}
