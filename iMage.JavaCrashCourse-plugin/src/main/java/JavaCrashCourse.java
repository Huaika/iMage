import org.jis.Main;
import plugins.PluginForJmjrst;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class serves as a prototype for a sample plugin.
 *
 * @author alejandrovillagómez
 * @version 1.0
 */
public class JavaCrashCourse extends PluginForJmjrst {

    /**
     * the main class in which the plugin will operate
     */
    private Main main;

    /**
     * a list of all java releases to this date
     */
    private List javaReleases;

    public String getName() {
        return this.getClass().getName();
    }

    public int getNumberOfParameters() {
        return javaReleases.size();
    }

    public void init(Main main) {
        this.main = main;
        javaReleases = List.of(
                "Java SE 9", "Java SE 10", "Java SE 11",
                "Java SE 12", "Java SE 13", "Java SE 14"
        );
    }

    public void run() {

    }

    public boolean isConfigurable() {
        return false;
    }

    public void configure() {
        JOptionPane.showMessageDialog(
                this.main,javaReleases.stream().collect(Collectors.joining("\n"))
        );
    }
}
