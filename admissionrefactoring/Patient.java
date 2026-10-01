package admissionrefactoring;

public class Patient {
  private final String name;
  private final double temperatureC;
  private final int age;

  Patient(String name, double temperatureC, int age) {
    this.name = name;
    this.temperatureC = temperatureC;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public double getTemperatureC() {
    return temperatureC;
  }

  public int getAge() {
    return age;
  }

}
