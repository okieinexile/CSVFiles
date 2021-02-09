class CSVLineTest{
  public void test(){
    String line = "The, quick, brown, fox, jumped";
    int columns = 5;
    System.out.println("Passed readLine:  " + readLineTest(line));
    System.out.println("Passed readColumns:  " + readColumnsTest(line, columns));
    readEntriesTest(line);
    fromEntriesCSVLineTest();
  }

  public boolean readLineTest(String line){
    CSVLine cl = new CSVLine(line);
    return line == cl.readLine();
  }

  public boolean readColumnsTest(String line, int columns){
    CSVLine cl = new CSVLine(line);
    return cl.readColumns() == columns;
  }

  public void readEntriesTest(String line){
    CSVLine cl = new CSVLine(line);
    String[] myEntries = cl.readEntries();
    for(int c = 0; c < cl.readColumns(); ++c){
      System.out.println(myEntries[c]);
    }
  }

  public void fromEntriesCSVLineTest(){
    String[] myEntries = {"A", "doe", "a", "deer", "a","female", "deer"};
    CSVLine cl = new CSVLine(myEntries);
    System.out.println(cl.readLine());
  }

}