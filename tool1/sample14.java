public ImmutableSet<ClassInfo> getClassesRecursive(String packageName) {
  checkNotNull(packageName);
  String packagePrefix = packageName + '.';
  ImmutableSet.Builder<ClassInfo> builder = ImmutableSet.builder();
  for (ClassInfo classInfo : classes) {
    if (classInfo.getName().startsWith(packagePrefix)) {
      builder.add(classInfo);
    }
  }
  return builder.build();
}
