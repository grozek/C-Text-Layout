/*  Author: Gabriela Roznawska
 *  November 2023
 *  Text Layout mini-project
 *  Created with help of online resources provided by Sam Rebelsky, as well as his
 *  personal support
 * 
 *  This program justifies given input block witin provided width, and in case it is 
 *  smaller than the length of the block then truncates it to the new width
 */

package lab.polymorphism;

/**
 * Given a text block and a width, builds a new block that right-justifies the input block within
 * that width.
 */
public class RightJustified implements TextBlock {

  /**
   * Fields
   */
  TextBlock block;
  int width;

  /**
   * Simple constructor
   * 
   * @param blockTemp input block
   * @param newWidth the new width within which the block and indentation is
   */
  public RightJustified(TextBlock blockTemp, int newWidth) {
    this.block = blockTemp;
    this.width = newWidth;
  } // RightJustified (Textblock, int)

  /**
   * If the input width is larger than the block, then truncate it, elsewhere justify the block
   * within given width
   */
  public String row(int i) throws Exception {
    String tempString = "";
    if (this.width >= this.block.width()) {
      String spaces = TBUtils.spaces(this.width - this.block.width());
      tempString = spaces.concat(this.block.row(i));
    } // if
    else if (this.width < this.block.width()) {
      tempString = this.block.row(i).substring(0, this.width);
    } // else if
    return tempString;
  }// row

  /**
   * Return the height of the block
   */
  public int height() {
    return this.block.height();
  }// height()

  /**
   * Return the width of the block
   */
  public int width() {
    return this.width;
  }// width()

  /**
   * Two textblocks are equal if they were built in the same way. Testing if the two blocks were
   * actually build the same way.
   */
  public boolean eqv(TextBlock other) {
    if (!(other instanceof RightJustified)) {
      return false;
    } // if
    if (!(other.width() == this.width())) {
      return false;
    } // if
    if (!(TBUtils.eqv(this.block, ((RightJustified) other).block))) {
      return false;
    } // if
    return true;
  }// eqv (TextBlock)
} // RightJustified

