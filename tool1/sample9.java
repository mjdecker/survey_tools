public synchronized boolean remove(Marker referenceToRemove) {
  if (refereceList == null) {
    return false;
  }

  int size = refereceList.size();
  for (int i = 0; i < size; i++) {
    Marker m = (Marker) refereceList.get(i);
    if (referenceToRemove.equals(m)) {
      refereceList.remove(i);
      return true;
    }
  }
  return false;
}
