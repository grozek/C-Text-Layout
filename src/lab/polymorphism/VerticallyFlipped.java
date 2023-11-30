/*  Author: Gabriela Roznawska
 *  November 2023
 *  Text Layout mini-project
 *  Created with help of online resources provided by Sam Rebelsky, as well as his
 *  personal support
 */

package lab.polymorphism;

public class VerticallyFlipped implements TextBlock{
  
  TextBlock block;
  Integer width;

  public VerticallyFlipped(TextBlock blockTemp) {
    this.block = blockTemp;
    this.width = blockTemp.width();
  }//VerticallyFlipped(Tempblock)

  public String row(int i) throws Exception {
      int x = this.block.height()-i;
      return this.block.row(x-1);
  }//row(int)

  public int height() {
    return this.block.height();
  }//height

  public int width() {
    return this.width;
  }//width

  /*
   * Two textblocks are equal if they were built in the same way.
   * Testing if the two blocks were actually build the same way.
   */
  public boolean eqv(TextBlock other) {
    if (! (other instanceof VerticallyFlipped)){
      return false;
    }
    if (! (other.width() == this.width())){
      return false;
    }
    if (! (TBUtils.eqv(this.block, ((VerticallyFlipped) other).block))){
      return false;
    }
    return true;
  }//eqv(TextBlock)
}//class VerticallyFlipped


