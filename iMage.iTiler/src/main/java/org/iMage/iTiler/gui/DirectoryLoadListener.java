package org.iMage.iTiler.gui;

import java.io.File;

public interface DirectoryLoadListener {

    /**
     *
     * @param directoryFile th directory file to open
     */
    void emitDirectory(File directoryFile);

}
