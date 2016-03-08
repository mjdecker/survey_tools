public synchronized boolean remove(Marker markerToRemove) {
  if (children == null) {
    return false;
  }

  int size = children.size();
  for (int i = 0; i < size; i++) {
    Marker m = (Marker) children.get(i);
    if (markerToRemove.equals(m)) {
      children.remove(i);
      return true;
    }
  }
  
  return false;
}
