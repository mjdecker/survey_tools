static class ExpirationSpec {
  @Nullable
  private final Long expireAfterAccessMillis;
  @Nullable
  private final Long expireAfterWriteMillis;

  private ExpirationSpec(Long expireAfterAccessMillis, Long expireAfterWriteMillis) {
    Preconditions.checkArgument(
        expireAfterAccessMillis == null || expireAfterWriteMillis == null);
    this.expireAfterAccessMillis = expireAfterAccessMillis;
    this.expireAfterWriteMillis = expireAfterWriteMillis;
  }

  public static ExpirationSpec afterAccess(long afterAccess, TimeUnit unit) {
    return new ExpirationSpec(unit.toMillis(afterAccess), null);
  }

  public static ExpirationSpec afterWrite(long afterWrite, TimeUnit unit) {
    return new ExpirationSpec(null, unit.toMillis(afterWrite));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(expireAfterAccessMillis, expireAfterWriteMillis);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof ExpirationSpec) {
      ExpirationSpec that = (ExpirationSpec) o;
      return Objects.equal(this.expireAfterAccessMillis, that.expireAfterAccessMillis)
          && Objects.equal(this.expireAfterWriteMillis, that.expireAfterWriteMillis);
    }
    return false;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("expireAfterAccessMillis", expireAfterAccessMillis)
        .add("expireAfterWriteMillis", expireAfterWriteMillis)
        .toString();
  }
}
