package lab.polymorphism;

public class VerticallyFlipped implements TextBlock{
  
    
  TextBlock block;
  Integer width;

  public VerticallyFlipped(TextBlock blockTemp) {
    this.block = blockTemp;
    this.width = blockTemp.width();
  }//VerticallyFlipped(Tempblock)

  public String row(int i) throws Exception {
      int x = this.block.height()-i;
      return this.block.row(x-1);
  }//row

  public int height() {
    return this.block.height();
  }//height

  public int width() {
    return this.width;
  }//width

}


