import java.io.*;

class TextFileReader{
  private String filename;
  private int rows;
  private String[] lines;

  TextFileReader(String filename){ 
    setFileName(filename);
    setRows();
    setLines();}
  
  private void setRows(){this.rows = findRows();}

  public Integer readRows(){return this.rows;}

  private int findRows(){
    int myRows = 0;
    try{
      File file = new File(readFileName());
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while((line = reader.readLine()) != null){
        ++myRows;
      }
      reader.close();
    }catch(Exception e){
      System.out.println("We were not able to open the file.");
    }
    return myRows;
  }

  private void setLines(){
    int myRows = 0;
    this.lines = new String[readRows()];
    try{
      File file = new File(readFileName());
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while((line = reader.readLine()) != null){
        this.lines[myRows] = line;
        ++myRows;
      }
      reader.close();
    }catch(Exception e){
      System.out.println("We were not able to open the file.");
    }
  }

  public String[] readLines(){return this.lines; }

  private void setFileName(String filename){this.filename = filename;}

  public String readFileName(){ return this.filename;}

  public String readLine(int r){
    return this.lines[r];
  }
}