
package lab.polymorphism;


public class Truncated implements TextBlock{

  TextBlock block;
  int width;


  public Truncated(TextBlock blockTemp, int newWidth) {
    this.block = blockTemp;
    this.width = newWidth;
  }

  public String row(int i) throws Exception {
    return this.block.row(i).substring(0, this.width);
  }

  public int height() {
    return this.block.height();
  }

  public int width() {
    return this.width;
  }


} //Truncated


