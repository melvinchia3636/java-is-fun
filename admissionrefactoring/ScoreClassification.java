package admissionrefactoring;

public class ScoreClassification {
  private static final ScoreClassification[] CLASSIFICATIONS = {
      new ScoreClassification("URGENT", 70),
      new ScoreClassification("MODERATE", 30),
      new ScoreClassification("ROUTINE", 0),
  };

  private final String name;
  private final int threshold;

  ScoreClassification(String name, int threshold) {
    this.name = name;
    this.threshold = threshold;
  }

  public String getName() {
    return this.name;
  }

  public int getThreshold() {
    return this.threshold;
  }

  public static String classify(int score) {
    for (ScoreClassification classification : CLASSIFICATIONS) {
      if (score >= classification.getThreshold()) {
        return classification.getName();
      }
    }

    throw new Error("Unable to classify score");
  }
}
