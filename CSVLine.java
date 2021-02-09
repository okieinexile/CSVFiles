class CSVLine{
  private String line;
  private String[] entries;
  private int columns;
  private final String sep = ",";
  private final int parameter = -2;

  CSVLine(String line){
    setLine(line);
    setEntries();
    setColumns();
    }

  CSVLine(String[] entries){
    setEntries(entries);
    setLine();
    }

  private void setEntries(String[] entries){this.entries = entries;}

  private void setEntries(){
    String[] myEntries = readLine().split(sep, parameter);
    this.entries = new String[myEntries.length];
    for(int c = 0; c < myEntries.length; ++c){
      this.entries[c] = myEntries[c].trim();
    }
  }

  private void setColumns(){
    this.columns = this.entries.length;
  }

  public int readColumns(){ return this.columns;}

  public String[] readEntries(){
    return this.entries;
  }

  private void setLine(String line){this.line = line;}
  
  private void setLine(){
    this.line = "";
    for(int i = 0; i < this.entries.length - 1; ++i){
      this.line = this.line + this.entries[i] + ", ";
    }
    this.line = this.line + this.entries[this.entries.length - 1];
  }
  
  public String readLine(){return this.line;}
  
}