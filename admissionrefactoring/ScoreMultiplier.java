package admissionrefactoring;

public class ScoreMultiplier<T extends Number> {
  private final T conditionThreshold;
  private final int scoreMultiplier;

  public ScoreMultiplier(T conditionThreshold, int scoreMultiplier) {
    this.scoreMultiplier = scoreMultiplier;
    this.conditionThreshold = conditionThreshold;
  }

  private int scoreFor(Number conditionValue) {
    if (conditionValue.doubleValue() >= conditionThreshold.doubleValue()) {
      return scoreMultiplier;
    }

    return 0;
  }

  public static int firstMatchingScore(ScoreMultiplier<?>[] scoreMultipliers, Number conditionValue) {
    for (ScoreMultiplier<?> multiplier : scoreMultipliers) {
      int score = multiplier.scoreFor(conditionValue);

      if (score != 0) {
        return score;
      }
    }

    return 0;
  }
}
