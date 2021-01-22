class CSVFileReaderTest{
  CSVFileReaderTest(){;}
  public void test(){
    String filename = "test1.csv";
    int myRows = 4;
    int max = 7;
    int min = 7;
    boolean rect = true;
    System.out.println("Passed readFileName:   " + readFileNameTest(filename));
    System.out.println("Passed readRows test:   " + readRowsTest(filename, myRows));
    System.out.println("Passed maxRows test:   " + maxRowTest(filename, max));
    System.out.println("Passed minRows test:   " + minRowTest(filename, min));
    System.out.println("Passed isRectangular test:   " + isRectangularTest(filename, rect));
    readLinesTest(filename);
    rowLengthTest(filename);
    readEntryTest(filename);
  }

  public boolean readFileNameTest(String filename){
    CSVFileReader read = new CSVFileReader(filename);
    return filename == read.readFileName();
  }

  public boolean readRowsTest(String filename, int rows){
    CSVFileReader read = new CSVFileReader(filename);
    return read.readRows() == rows;
  }

  public void readLinesTest(String filename){
    CSVFileReader cr = new CSVFileReader(filename);
    for(int r = 0; r < cr.readRows(); ++r){
      System.out.println(cr.readLine(r));
    }
  }

  public void rowLengthTest(String filename){
    CSVFileReader cr = new CSVFileReader(filename);
    for(int r = 0; r < cr.readRows(); ++r){
      System.out.println(cr.rowLength(r));
    }    
  }

  public boolean maxRowTest(String filename, int max){
    CSVFileReader cr = new CSVFileReader(filename);
    return max == cr.maxRow();
  }

  public boolean minRowTest(String filename, int min){
    CSVFileReader cr = new CSVFileReader(filename);
    return min == cr.minRow();
  }  

  public boolean isRectangularTest(String filename, boolean state){
    CSVFileReader cr = new CSVFileReader(filename);
    return state == cr.isRectangular();
  }

  public void readEntryTest(String filename){
    CSVFileReader fr = new CSVFileReader(filename);
    for(int r = 0; r < fr.readRows(); ++r){
      for(int c = 0; c < fr.readColumns(); ++c){
        System.out.print(fr.readEntry(r,c) + " ");
      }
      System.out.println("");
    }
  }
}
