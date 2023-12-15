/*
 * Author: Gabriela Roznawska 
 * November 2023 
 * Text Layout mini-project 
 * Created with help of online resources provided by Sam Rebelsky, 
 * as well as his personal support
 * 
 * This file of the project modifies the input by truncating it to 
 * a provided new width
 */

package lab.polymorphism;


public class Truncated implements TextBlock {

  /**
   * Fields!
   */
  TextBlock block;
  int width;

  /**
   * Lovely constructor Truncates input block to given witdth
   */
  public Truncated(TextBlock blockTemp, int newWidth) {
    this.block = blockTemp;
    this.width = newWidth;
  } // Truncated(TextBlock, int)

  /**
   * Truncates the input block to a given width
   */
  public String row(int i) throws Exception {
    String tempOutput = this.block.row(i).substring(0, this.width);
    return tempOutput;
  } // row(int)

  /**
   * Returns block's height
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Returns blocks's width
   */
  public int width() {
    return this.width;
  } // width()

  /**
   * Two textblocks are equal if they were built in the same way. Testing if the two blocks were
   * actually build the same way.
   */
  public boolean eqv(TextBlock other) {
    if (!(other instanceof Truncated)) {
      return false;
    } // if
    if (!(other.width() == this.width())) {
      return false;
    } // if
    if (!(TBUtils.eqv(this.block, ((Truncated) other).block))) {
      return false;
    } // if
    return true;
  }// eqv (TextBlock)
} // Truncated


