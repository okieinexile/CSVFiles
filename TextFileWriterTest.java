class TextFileWriterTest{
  public void test(){
    String filename = "test1.csv";
    String newfile = "test1_out.csv";
    TextFileReader tfr = new TextFileReader(filename);
    String[] lines = tfr.readLines();
    writerTest(newfile, lines);

  }
  public void writerTest(String filename, String[] lines){
    TextFileWriter tfw = new TextFileWriter(filename, lines);
    tfw.writeFile();
  }
}