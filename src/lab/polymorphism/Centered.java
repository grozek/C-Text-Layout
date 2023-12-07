/*  Author: Gabriela Roznawska
 *  November 2023
 *  Text Layout mini-project
 *  Created with help of online resources provided by Sam Rebelsky, as well as his
 *  personal support
 */

package lab.polymorphism;

/* given a text block and a width, builds a new block that centers the block within that width.
 */
public class Centered implements TextBlock{

  TextBlock block;
  int width;

  public Centered(TextBlock blockTemp, int newWidth) {
    this.block = blockTemp;
    this.width = newWidth;
  }

  /* Given a newWidth it adds half of the extra width (newWidth-textblock width) in front of the
   * new return string, so that is centered within the given width
   */
  public String row(int i) throws Exception {
    String tempString = "";
    if (this.width >= this.block.width()){
      String spaces = TBUtils.spaces(this.width-this.block.width()/2);
      tempString = spaces.concat(this.block.row(i).concat(spaces));
    }
    else if (this.width < this.block.width()){
    tempString = this.block.row(i).substring(0, this.width);
    }
    return tempString;
  }

  public int height() {
    return this.block.height();
  }

  public int width() {
    return this.width;
  }

  /*
   * Two textblocks are equal if they were built in the same way.
   * Testing if the two blocks were actually build the same way.
   */
  public boolean eqv(TextBlock other) {
    if (! (other instanceof Centered)){
      return false;
    }
    if (! (other.width() == this.width())){
      return false;
    }
    try {
      if (! (TBUtils.eqv(this.block, ((Centered) other).block))){
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }//eqv (TextBlock)
} //class Centered