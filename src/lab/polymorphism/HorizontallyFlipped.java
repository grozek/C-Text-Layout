/*  Author: Gabriela Roznawska
 *  November 2023
 *  Text Layout mini-project
 *  Created with help of online resources provided by Sam Rebelsky, as well as his
 *  personal support
 * 
 *  This program flips a block horizonally 
 */

package lab.polymorphism;

public class HorizontallyFlipped implements TextBlock {

  /**
   * Fields
   */
  TextBlock block;
  Integer width;

  /**
   * Simple constructor
   * 
   * @param blockTemp input block
   */
  public HorizontallyFlipped(TextBlock blockTemp) {
    this.block = blockTemp;
    this.width = blockTemp.width();
  } // HorizontallyFlipped(TextBlock)

  /**
   * Alters the block so that it is horizontally flipepd
   */
  public String row(int i) throws Exception {
    int x = this.width - 1;
    String temp = "";
    while (x >= 0) {
      temp += this.block.row(i).substring(x, x + 1);
      x--;
    } // while
    return temp;
  } // row(int)

  /**
   * return the height of the block
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * return width of block
   */
  public int width() {
    return this.width;
  } // width()

  /*
   * Two textblocks are equal if they were built in the same way. Testing if the two blocks were
   * actually build the same way.
   */
  public boolean eqv(TextBlock other) {
    if (!(other instanceof HorizontallyFlipped)) {
      return false;
    } // if
    if (!(other.width() == this.width())) {
      return false;
    } // if
    if (!(TBUtils.eqv(this.block, ((HorizontallyFlipped) other).block))) {
      return false;
    } // if
    return true;
  }// eqv (TextBlock)

}
