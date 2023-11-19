
package lab.polymorphism;


public class Truncated implements TextBlock{

  TextBlock block;
  int width;


  public Truncated(TextBlock blockTemp, int newWidth) {
    this.block = blockTemp;
    this.width = newWidth;
  }//Truncated(TextBlock, int)

  public String row(int i) throws Exception {
    String tempOutput = this.block.row(i).substring(0, this.width);
    return tempOutput;
  }//row

  public int height() {
    return this.block.height();
  }//height

  public int width() {
    return this.width;
  }//width


} //Truncated


