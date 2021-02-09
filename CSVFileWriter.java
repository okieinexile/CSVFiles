class CSVFileWriter{

  private String[][] entries;
  private String[] lines; 
  private String filename;

  CSVFileWriter(String filename, String[][] entries){
    setFilename(filename);
    setEntries(entries);
    setLines();
    }

  private void setFilename(String filename){this.filename = filename;}

  private void setEntries(String[][] entries){this.entries = entries;}
  private void setLines(){
    this.lines = new String[this.entries.length];
    for(int r = 0; r < this.entries.length; ++r){
      CSVLine cl = new CSVLine(this.entries[r]);
      this.lines[r] = cl.readLine();
    }
  }

  public String[] readLines(){return this.lines;}

  public void writeFile(){
    TextFileWriter tfw = new TextFileWriter(this.filename, this.lines);
    tfw.writeFile();
  }


}