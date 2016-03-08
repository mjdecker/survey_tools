private void convertFile(File file) {
  try {
    InplaceFileConverter fc = new InplaceFileConverter(lineConverter);
    byte[] ba = fc.readFile(file);
    fc.convert(file, ba);
  } catch (IOException exc) {
    addException(new ConversionException(exc.toString()));
  }
}
