private void convertFile(File file) {
  try {
    InplaceFileConverter fc = new InplaceFileConverter(ruleSet);
    fc.convert(file);
  } catch (IOException exc) {
    addException(new ConversionException(exc.toString()));
  }
}
