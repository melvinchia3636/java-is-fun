package admissionrefactoring;

public class Patient {
  private final String name;
  private final double temperatureC;
  private final int ageYears;

  Patient(String name, double temperatureC, int ageYears) {
    this.name = name;
    this.temperatureC = temperatureC;
    this.ageYears = ageYears;

    validateInput();
  }

  private void validateInput() {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name must not be blank");
    }

    if (temperatureC <= 0 || temperatureC > 45) {
      throw new IllegalArgumentException("Temperature out of range: " + temperatureC);
    }

    if (ageYears < 0 || ageYears > 120) {
      throw new IllegalArgumentException("Age out of range: " + ageYears);
    }
  }

  public String getName() {
    return name;
  }

  public double getTemperatureC() {
    return temperatureC;
  }

  public int getAgeYears() {
    return ageYears;
  }

}
