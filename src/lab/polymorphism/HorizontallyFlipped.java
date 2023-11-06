package lab.polymorphism;

public class HorizontallyFlipped implements TextBlock{
  
  TextBlock block;
  Integer width;

  public HorizontallyFlipped(TextBlock blockTemp, int newWidth) {
    this.block = blockTemp;
    this.width = newWidth;
  }

  public String row(int i) throws Exception {
    int x = this.width;
    String temp = "";
    while (x > 0){

      temp += this.block.row(i).substring(x-1, this.width);
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
