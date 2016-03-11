void physDown(int amount, int screenAmount)
{
  skew = 0;

  if(!isLineVisible(physicalLine))
  {
    int lastVisibleLine = getLastVisibleLine();
    if(physicalLine > lastVisibleLine)
      physicalLine = lastVisibleLine;
    else
    {
      int nextPhysicalLine = getNextVisibleLine(physicalLine);
      amount -= (nextPhysicalLine - physicalLine);
      scrollLine += getScreenLineCount(physicalLine);
      physicalLine = nextPhysicalLine;
    }
  }

  for(;;)
  {
    int nextPhysicalLine = getNextVisibleLine(
      physicalLine);
    if(nextPhysicalLine == -1)
      break;
    else if(nextPhysicalLine > physicalLine + amount)
      break;
    else
    {
      scrollLine += getScreenLineCount(physicalLine);
      amount -= (nextPhysicalLine - physicalLine);
      physicalLine = nextPhysicalLine;
    }
  }

  if(screenAmount < 0)
    scrollUp(-screenAmount);
  else if(screenAmount > 0)
    scrollDown(screenAmount);
}
