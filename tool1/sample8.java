public static void assertDuration(double currentDuration,
    long referenceDuraion, double referenceBIPS)
    throws AssertionFailedError {
  double ajustedDuration = adjustExpectedDuration(referenceDuraion,
      referenceBIPS);
  if (currentDuration > ajustedDuration * SLACK_FACTOR) {
    throw new AssertionFailedError(currentDuration
        + " exceeded expected "
        + ajustedDuration + " (adjusted), "
        + referenceDuraion + " (raw)");
  }
}
