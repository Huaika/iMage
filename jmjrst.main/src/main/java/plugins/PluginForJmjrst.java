package plugins;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Abstract parent class for plug-ins for JMJRST
 *
 * @author Dominik Fuchss
 */
public abstract class PluginForJmjrst implements Comparable<PluginForJmjrst> {

  /**
   * Returns the name of this plug-in
   *
   * @return the name of the plug-in
   */
  public abstract String getName();

  /**
   * Returns the number of parameters of this plug-in
   *
   * @return the number of parameters of this plug-in
   */
  public abstract int getNumberOfParameters();

  /**
   * JMJRST pushes the main application to every subclass - so plug-ins are allowed to look at Main
   * as well.
   *
   * @param main
   *     JMJRST main application
   */
  public abstract void init(org.jis.Main main);

  /**
   * Runs plug-in
   */
  public abstract void run();

  /**
   * Returns whether the plug-in can be configured or not
   *
   * @return true if the plug-in can be configured.
   */
  public abstract boolean isConfigurable();

  /**
   * Open a configuration dialogue.
   */
  public abstract void configure();

  /**
   * compares the current plugin with another one lexicographically
   * using the compareTo method as defined in the String class
   * @param otherPlugin the plugin to be compared to
   * @return  0 if equal, 1 if other precedes this, -1 if this precedes other
   */
  @Override
  public int compareTo(PluginForJmjrst otherPlugin) {
    return this.getName().compareTo(otherPlugin.getName());
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
            .append(this.getName())
            .append(this.getNumberOfParameters())
            .append(this.isConfigurable())
            .toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    boolean sameName = this.getName().equals(((PluginForJmjrst) obj).getName());
    boolean sameNumberOfParameters = this.getNumberOfParameters() == ((PluginForJmjrst) obj).getNumberOfParameters();
    boolean sameConfigurableValue = this.isConfigurable() == ((PluginForJmjrst) obj).isConfigurable();
    return sameName && sameConfigurableValue && sameNumberOfParameters;
  }
}
