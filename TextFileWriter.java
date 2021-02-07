import java.io.*;
import java.io.IOException;

class TextFileWriter{
  private String filename;
  private String[] lines;  

  TextFileWriter(String filename, String[] lines){
    setFilename(filename);
    setLines(lines); 
  }
  
  private void setFilename(String filename){this.filename = filename;}
  private void setLines(String[] lines){this.lines = lines;}
  private void createFile(){
    try{
      File myFile = new File(this.filename);
      if(myFile.createNewFile()){
        System.out.println("File created: " + myFile.getName());
      }else{
        System.out.println("File already exists. Overwriting");
      }
    }catch(IOException e){
      System.out.println("Something has gone horribly awry");
    }
  }
  public void writeFile(){
    createFile();
    try{
      FileWriter myWriter = new FileWriter(this.filename);
      for(String line : this.lines){
        myWriter.write(line + "\n");
      }
      myWriter.close();
    }catch(IOException e){
      System.out.println("Something has gone horribly awry");
      e.printStackTrace();
    }
  }
}