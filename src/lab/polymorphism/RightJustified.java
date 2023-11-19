
package lab.polymorphism;

/* given a text block and a width, 
 * builds a new block that right-justifies the input block within that width.
 */
public class RightJustified implements TextBlock{

  TextBlock block;
  int width;


  public RightJustified(TextBlock blockTemp, int newWidth) {
    this.block = blockTemp;
    this.width = newWidth;
  }

  public String row(int i) throws Exception {
    String spaces = TBUtils.spaces(this.width);
    String tempString = spaces.concat(this.block.row(i));
    TextBlock newBlock = new TextLine(tempString);
    return tempString;
  }

  public int height() {
    return this.block.height();
  }

  public int width() {
    return this.width;
  }


} //Truncated

