package lab.polymorphism;

public class HorizontallyFlipped implements TextBlock{
  
  TextBlock block;
  Integer width;

  public HorizontallyFlipped(TextBlock blockTemp) {
    this.block = blockTemp;
    this.width = blockTemp.width();
  }

  public String row(int i) throws Exception {
    int x = this.width-1;
    String temp = "";
    while (x >= 0){
      temp += this.block.row(i).substring(x, x+1);
      x--;
    }
    return temp;
  }

  public int height() {
    return this.block.height();
  }

  public int width() {
    return this.width;
  }

}
