package org.cyclopsgroup.jcli.spi;

import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.List;

/**
 * Data that comes from command arguments
 *
 * @author <a href="mailto:jiaqi@cyclopsgroup.org">Jiaqi Guo</a>
 */
public final class CommandLine {
  /** One entry of option value */
  public static final class OptionValue {
    /** Name of command line option it detects */
    public final String name;

    /** True if option name is a short name */
    public final boolean shortName;

    /** Detected value */
    public final String value;

    OptionValue(String name, String value, boolean shortName) {
      this.name = name;
      this.value = value;
      this.shortName = shortName;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(getClass().getSimpleName())
          .addValue(name)
          .addValue(value)
          .addValue(shortName)
          .toString();
    }
  }

  private final List<String> arguments = new ArrayList<String>();

  private final List<OptionValue> optionValues = new ArrayList<OptionValue>();

  void addArgument(String argument) {
    this.arguments.add(argument);
  }

  void addOptionValue(String name, String value, boolean shortName) {
    this.optionValues.add(new OptionValue(name, value, shortName));
  }

  /** @return List of arguments */
  public List<String> getArguments() {
    return arguments;
  }

  /** @return List of option and values */
  public final List<OptionValue> getOptionValues() {
    return optionValues;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(getClass())
        .addValue(arguments)
        .addValue(optionValues)
        .toString();
  }
}
