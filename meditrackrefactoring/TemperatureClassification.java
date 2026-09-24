
package meditrackrefactoring;

public class TemperatureClassification {
  private final String name;
  private final double threshold;

  TemperatureClassification(String name, double threshold) {
    this.name = name;
    this.threshold = threshold;
  }

  public String getName() {
    return this.name;
  }

  public double getThreshold() {
    return this.threshold;
  }
}