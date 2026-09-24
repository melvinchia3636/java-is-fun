
package meditrackrefactoring;

public class MediTrackV2 {
  private static final TemperatureClassification[] TEMPERATURE_CLASSIFICATIONS = {
      new TemperatureClassification("HIGH", 39.5),
      new TemperatureClassification("MODERATE", 37.5),
      new TemperatureClassification("LOW", 0),
  };

  public static String classifyTemperature(double temperatureC) {
    for (TemperatureClassification classification : TEMPERATURE_CLASSIFICATIONS) {
      if (temperatureC > classification.getThreshold()) {
        return classification.getName();
      }
    }

    throw new Error("Unable to classify temperature");
  }

  public static void printPatientResult(Patient patient, String resultClassification) {
    System.out.printf("%s | %f | %s\n", patient.getName(), patient.getTemperatureC(), resultClassification);
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

    System.out.println("\nTest cases:");
    System.out.println("37.4 -> " + classifyTemperature(37.4));
    System.out.println("37.5 -> " + classifyTemperature(37.5));
    System.out.println("38.9 -> " + classifyTemperature(38.9));
    System.out.println("39.4 -> " + classifyTemperature(39.4));
    System.out.println("39.5 -> " + classifyTemperature(39.5));
    System.out.println("40.0 -> " + classifyTemperature(40.0));

  }

}
