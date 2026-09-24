
package meditrackrefactoring;

public class MediTrackV2 {
  private static final TemperatureClassification[] TEMPERATURE_CLASSIFICATIONS = {
      new TemperatureClassification("HIGH", 39.5),
      new TemperatureClassification("MEDIUM", 37.5),
      new TemperatureClassification("LOW", 0),
  };

  public static String classifyTemperature(double temperatureC) {
    for (TemperatureClassification classification : TEMPERATURE_CLASSIFICATIONS) {
      if (temperatureC >= classification.getThreshold()) {
        return classification.getName();
      }
    }

    throw new Error("Unable to classify temperature");
  }

  public static void printPatientResult(Patient patient, String resultClassification) {
    System.out.printf("%s | %f | %s", patient.getName(), patient.getTemperatureC(), resultClassification);
  }

  public static void main(String[] args) {
    Patient[] patients = {
        new Patient("Maria", 38.9),
        new Patient("Ahmad", 37.2),
        new Patient("Priya", 39.8)
    };

    for (Patient patient : patients) {
      String resultClassification = classifyTemperature(patient.getTemperatureC());

      printPatientResult(patient, resultClassification);
    }
  }

}
