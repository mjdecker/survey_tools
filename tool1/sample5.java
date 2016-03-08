@Override public boolean containsAll(Collection<?> targets) {
  try {
    return range.containsAll((Iterable<? extends C>) targets);
  } catch (ClassCastException e) {
    return false;
  }
}
