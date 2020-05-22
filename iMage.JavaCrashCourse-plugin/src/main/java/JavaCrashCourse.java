import org.jis.Main;
import plugins.PluginForJmjrst;

/**
 * This class serves as a prototype for a sample plugin.
 *
 * @author alejandrovillagómez
 * @version 1.0
 */
public class JavaCrashCourse extends PluginForJmjrst {


    public String getName() {
        return this.getClass().getName();
    }

    public int getNumberOfParameters() {
        return 0;
    }

    public void init(Main main) {

    }

    public void run() {

    }

    public boolean isConfigurable() {
        return false;
    }

    public void configure() {

    }
}
