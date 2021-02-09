class CSVFileWriterTest{
  public void test(){
    createTest();
    writeFileTest();
  }
  private void createTest(){
    String filename = "read.csv";
    CSVFileReader fr = new CSVFileReader(filename);
    CSVFileWriter cfw = new CSVFileWriter(filename, fr.readEntries());
    for(String line : cfw.readLines()){
      System.out.println(line);
    }
  }

  private void writeFileTest(){
    String filename = "read.csv";
    String newFilename = "read_out.csv";
    CSVFileReader fr = new CSVFileReader(filename);
    CSVFileWriter cfw = new CSVFileWriter(newFilename, fr.readEntries());
    cfw.writeFile();

  }

}