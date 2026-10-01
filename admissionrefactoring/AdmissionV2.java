package admissionrefactoring;

public class AdmissionV2 {
  private static final ScoreMultiplier<?>[] temperatureScoreMultiplier = {
      new ScoreMultiplier<>(39.5, 50),
      new ScoreMultiplier<>(37.5, 25),
  };

  private static final ScoreMultiplier<?>[] ageScoreMultiplier = {
      new ScoreMultiplier<>(65, 30),
      new ScoreMultiplier<Number>(50, 15)
  };

  public static String check(Patient patient) {
    int score = ScoreMultiplier.firstMatchingScore(temperatureScoreMultiplier, patient.getTemperatureC())
        + ScoreMultiplier.firstMatchingScore(ageScoreMultiplier, patient.getAge());

    return patient.getName() + " | " + ScoreClassification.classify(score);
  }

  public static void main(String[] args) {
    Patient patients[] = {
        new Patient("Maria", 38.9, 70),
        new Patient("Ahmad", 37.2, 30),
        new Patient("Priya", 39.8, 68),
        new Patient("", 120.0, -5)
    };

    for (Patient patient : patients) {
      System.out.println(check(patient));
    }
  }
}
