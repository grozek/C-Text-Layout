/*  Author: Gabriela Roznawska
 *  November 2023
 *  Text Layout mini-project
 *  Created with help of online resources provided by Sam Rebelsky, as well as his
 *  personal support
 */

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
    this.block = newBlock;
    return tempString;
  }

  public int height() {
    return this.block.height();
  }

  public int width() {
    return this.width;
  }

  public boolean eqv(TextBlock other) {
    if (! (other instanceof RightJustified)){
      return false;
    }
    if (! (other.width() == this.width())){
      return false;
    }
    if (! (TBUtils.eqv(this.block, ((RightJustified) other).block))){
      return false;
    }
    return true;
  }//eqv (TextBlock)
} //Truncated

