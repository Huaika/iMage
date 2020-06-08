package org.iMage.iTiler.gui;

import java.io.File;

public interface ImageFlowListener {

    /**
     *
     * @param imageFile
     */
    void emitImage(File imageFile);

    void saveResultImage(File saveFolder);

}


//TODO write javadoc