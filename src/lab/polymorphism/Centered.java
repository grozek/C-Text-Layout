/*  Author: Gabriela Roznawska
 *  November 2023
 *  Text Layout mini-project
 *  Created with help of online resources provided by Sam Rebelsky, as well as his
 *  personal support
 * 
 *  Centeres given block in given width
 */

package lab.polymorphism;

/* given a text block and a width, builds a new block that centers the block within that width.
 */
public class Centered implements TextBlock{

  /**
   * Fields
   */ 
  TextBlock block;
  int width;

  /**
   * Simple constructor
   * @param blockTemp inputblock
   * @param newWidth the new width in int
   */
  public Centered(TextBlock blockTemp, int newWidth) {
    this.block = blockTemp;
    this.width = newWidth;
  } // Centered(Textblock, int)

  /* Given a newWidth it adds half of the extra width (newWidth-textblock width) in front of the
   * new return string, so that is centered within the given width
   */
  public String row(int i) throws Exception {
    String tempString = "";
    if (this.width >= this.block.width()){
      String spaces = TBUtils.spaces((this.width-this.block.width())/2);
      tempString = spaces.concat(this.block.row(i).concat(spaces));
    } // else
    else if (this.width < this.block.width()){
    tempString = this.block.row(i).substring(0, this.width);
    } // else if
    return tempString;
  } // row(int)

  /**
   * Returns height
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Returns width
   */
  public int width() {
    return this.width;
  } // width()

  /*
   * Two textblocks are equal if they were built in the same way.
   * Testing if the two blocks were actually build the same way.
   */
  public boolean eqv(TextBlock other) {
    if (! (other instanceof Centered)){
      return false;
    } // if
    if (! (other.width() == this.width())){
      return false;
    } // if
    try {
      if (! (TBUtils.eqv(this.block, ((Centered) other).block))){
        return false;
      } // if
    } catch (Exception e) {
      return false;
    } // catch
    return true;
  }//eqv (TextBlock)
} //class Centered