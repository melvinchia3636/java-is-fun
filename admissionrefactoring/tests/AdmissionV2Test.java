package admissionrefactoring.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import admissionrefactoring.AdmissionV2;
import admissionrefactoring.Patient;
import admissionrefactoring.PriorityClassification;

class AdmissionV2Test {
  @Test
  void calculateRiskScore_feverSenior_returns55() {
    assertEquals(55, AdmissionV2.calculateRiskScore(new Patient("Maria", 38.9, 70)));
  }

  @Test
  void getPriority_score80_returnsUrgent() {
    assertEquals("URGENT", PriorityClassification.classify(80));
  }

  @Test
  void admit_normalPatient_printsRoutine() {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(capturedOut));

    try {
      AdmissionV2.admit(new Patient("Ahmad", 37.2, 30));
    } finally {
      System.setOut(originalOut);
    }

    assertEquals("Ahmad | ROUTINE", capturedOut.toString().trim());
  }

  @Test
  void calculateRiskScore_temperature39_5Age30_returns50() {
    assertEquals(50, AdmissionV2.calculateRiskScore(new Patient("Test", 39.5, 30)));
  }

  @Test
  void calculateRiskScore_temperature37_4Age64_returns15() {
    assertEquals(15, AdmissionV2.calculateRiskScore(new Patient("Test", 37.4, 64)));
  }

  @Test
  void getPriority_score70_returnsUrgent() {
    assertEquals("URGENT", PriorityClassification.classify(70));
  }

  @Test
  void getPriority_score69_returnsModerate() {
    assertEquals("MODERATE", PriorityClassification.classify(69));
  }

  @Test
  void admit_temperature120_throwsException() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> AdmissionV2.admit(new Patient("Priya", 120.0, 68)));

    assertEquals("Temperature out of range: 120.0", exception.getMessage());
  }

  @Test
  void admit_blankName_throwsException() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> AdmissionV2.admit(new Patient("", 38.0, 40)));

    assertEquals("Name must not be blank", exception.getMessage());
  }

  @Test
  void admit_negativeAge_throwsException() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> AdmissionV2.admit(new Patient("Sara", 38.0, -5)));

    assertEquals("Age out of range: -5", exception.getMessage());
  }
}
