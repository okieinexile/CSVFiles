class TextFileReaderTest{
  public void test(){
    String filename = "read.csv";
    int rows = 4;
    System.out.println("Passes  :   " + readFileNameTest(filename));
    System.out.println("Passes  :   " + readRowsTest(filename, rows));
    readLinesTest(filename);
  }

  public boolean readFileNameTest(String filename){
    TextFileReader fr = new TextFileReader(filename);
    return filename == fr.readFileName();
  }

  public boolean readRowsTest(String filename, int rows){
    TextFileReader fr =new TextFileReader(filename);
    return rows == fr.readRows();
  }

  public void readLinesTest(String filename){
    TextFileReader fr = new TextFileReader(filename);
    for(String line : fr.readLines()) System.out.println(line);
  }
}