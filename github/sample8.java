public static void assertDuration(double currentDuration,
    long referenceDuration, double referenceBIPS)
    throws AssertionFailedError {
  double ajustedDuration = adjustExpectedDuration(referenceDuration,
      referenceBIPS);
  if (currentDuration > ajustedDuration * SLACK_FACTOR) {
    throw new AssertionFailedError("current duration "+ currentDuration
        + " exceeded expected "
        + ajustedDuration + " (adjusted reference), "
        + referenceDuration + " (raw reference)");
  }
}
