static class DurationSpec {
  private final long duration;
  private final TimeUnit unit;

  private DurationSpec(long duration, TimeUnit unit) {
    this.duration = duration;
    this.unit = unit;
  }

  public static DurationSpec of(long duration, TimeUnit unit) {
    return new DurationSpec(duration, unit);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(duration, unit);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof DurationSpec) {
      DurationSpec that = (DurationSpec) o;
      return unit.toNanos(duration) == that.unit.toNanos(that.duration);
    }
    return false;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("duration", duration)
        .add("unit", unit)
        .toString();
  }
}
