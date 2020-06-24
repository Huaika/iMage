package org.iMage.iTiler.gui;

import org.iMage.mosaique.base.BufferedArtImage;
import org.iMage.mosaique.base.IMosaiqueArtist;

import java.util.List;

public interface Observer {
    /**
     *
     * @param inputImage
     * @param mosaiqueTiles
     * @param tileWidth
     * @param tileHeight
     * @param artist
     */
    void update(
            BufferedArtImage inputImage, List<BufferedArtImage> mosaiqueTiles,
            int tileWidth, int tileHeight, IMosaiqueArtist artist
    );
}
