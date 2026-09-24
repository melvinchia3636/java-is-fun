package meditrackrefactoring;

public class Patient {
  private final String name;
  private final double temperatureC;

  Patient(String name, double temperatureC) {
    this.name = name;
    this.temperatureC = temperatureC;
  }

  public String getName() {
    return name;
  }

  public double getTemperatureC() {
    return temperatureC;
  }
}
