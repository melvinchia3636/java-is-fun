package admissionrefactoring;

public class AdmissionV2 {
  private static final RiskScoreMultiplier<?>[] temperatureScoreMultiplier = {
      new RiskScoreMultiplier<>(39.5, 50),
      new RiskScoreMultiplier<>(37.5, 25),
  };

  private static final RiskScoreMultiplier<?>[] ageScoreMultiplier = {
      new RiskScoreMultiplier<>(65, 30),
      new RiskScoreMultiplier<Number>(50, 15)
  };

  private static int calculateRiskScore(Patient patient) {
    return RiskScoreMultiplier.firstMatchingScore(temperatureScoreMultiplier, patient.getTemperatureC())
        + RiskScoreMultiplier.firstMatchingScore(ageScoreMultiplier, patient.getAgeYears());
  }

  public static void main(String[] args) {
    Patient patients[] = {
        new Patient("Maria", 38.9, 70),
        new Patient("Ahmad", 37.2, 30),
        new Patient("Priya", 39.8, 68),
        new Patient("", 120.0, -5)
    };

    for (Patient patient : patients) {
      System.out.printf("%s | %s\n",
          patient.getName(),
          PriorityClassification.classify(calculateRiskScore(patient)));
    }
  }
}
