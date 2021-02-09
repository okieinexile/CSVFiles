import java.io.*;

class CSVFileReader extends TextFileReader {

  private int minRowLength = 10_000;
  private int maxRowLength = -10_000;
  private int columns;
  private String[][] entries;
  private boolean rectangular = false;

  CSVFileReader(String filename) {
    super(filename);
    findMaxMinRowLength();
    if (maxRow() == minRow()) {
      this.columns = maxRow();
      this.rectangular = true;
      setEntries();
    }
  }

  private void findMaxMinRowLength() {
    CSVLine mLine;
    int len;
    for (int r = 0; r < readRows(); ++r) {
      mLine = new CSVLine(readLine(r));
      len = mLine.readColumns();
      if (len > this.maxRowLength)
        this.maxRowLength = len;
      if (len < this.minRowLength)
        this.minRowLength = len;
    }
  }

  public Integer readColumns() {
    return this.columns;
  }

  public String[] rowEntries(int r) {
    CSVLine myLine = new CSVLine(readLine(r));
    return myLine.readEntries();
  }

  public Integer rowLength(int r) {
    CSVLine myLine = new CSVLine(readLine(r));
    return myLine.readColumns();
  }

  public Integer maxRow() {
    return this.maxRowLength;
  }

  public Integer minRow() {
    return this.minRowLength;
  }

  public boolean isRectangular() {
    return this.rectangular;
  }

  public void setEntries() {
    this.entries = new String[readRows()][readColumns()];
    CSVLine mLine;
    for (int r = 0; r < readRows(); ++r) {
      mLine = new CSVLine(readLine(r));
      for (int c = 0; c < readColumns(); ++c) {
        this.entries[r][c] = mLine.readEntries()[c];
      }
    }
  }

  public String readEntry(int r, int c) {
    if (!this.isRectangular()) {
      System.out.println("This files has an unequal number of columns!");
    }
    return this.entries[r][c];
  }

  public String[][] readEntries(){return this.entries;}
}