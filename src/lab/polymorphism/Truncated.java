/*  Author: Gabriela Roznawska
 *  November 2023
 *  Text Layout mini-project
 *  Created with help of online resources provided by Sam Rebelsky, as well as his
 *  personal support
 */

package lab.polymorphism;


public class Truncated implements TextBlock{

  TextBlock block;
  int width;

  /**
   * 
   * Truncates input block  to given witdth
   */
  public Truncated(TextBlock blockTemp, int newWidth) {
    this.block = blockTemp;
    this.width = newWidth;
  }//Truncated(TextBlock, int)

  public String row(int i) throws Exception {
    String tempOutput = this.block.row(i).substring(0, this.width);
    return tempOutput;
  }//row

  public int height() {
    return this.block.height();
  }//height

  public int width() {
    return this.width;
  }//width

  /**
   * Two textblocks are equal if they were built in the same way.
   * Testing if the two blocks were actually build the same way.
   */
  public boolean eqv(TextBlock other) {
    if (! (other instanceof Truncated)){
      return false;
    }
    
    if (! (other.width() == this.width())){
      return false;
    }

    if (! (TBUtils.eqv(this.block, ((Truncated) other).block))){
      return false;
    }
    return true;
  }//eqv (TextBlock)
} //Truncated


