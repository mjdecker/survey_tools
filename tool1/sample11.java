public void expandFolds(int foldLevel, boolean update)
{
  if(buffer.getFoldHandler() instanceof IndentFoldHandler)
    foldLevel = (foldLevel - 1) * buffer.getIndentSize() + 1;

  showLineRange(0,buffer.getLineCount() - 1);

  int leastFolded = -1;
  int firstInvisible = 0;

  for(int i = 0; i < buffer.getLineCount(); i++)
  {
    if (leastFolded == -1 || buffer.getFoldLevel(i) < leastFolded)
    {
      leastFolded = buffer.getFoldLevel(i);
    }
  
    if (buffer.getFoldLevel(i) < foldLevel ||
        buffer.getFoldLevel(i) == leastFolded)
    {
      if(firstInvisible != i)
      {
        hideLineRange(firstInvisible,
          i - 1);
      }
      firstInvisible = i + 1;
    }
  }

  if(firstInvisible != buffer.getLineCount())
    hideLineRange(firstInvisible,buffer.getLineCount() - 1);

  notifyScreenLineChanges();
  if(update && textArea.getDisplayManager() == this)
  {
    textArea.foldStructureChanged();
  }
}
