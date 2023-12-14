/**  
 * Author: Gabriela Roznawska
 *  November 2023
 *  Text Layout mini-project
 *  Created with help of online resources provided by Sam Rebelsky, as well as his
 *  personal support
 */

package lab.polymorphism;

public class Original implements TextBlock{
  
  TextBlock block;
  int width;

  public Original(TextBlock blockTemp) {
    this.block = blockTemp;
  }//Original(TextBlock, int)

  /**
   * Modifies the line so that the string is now a cool-sounding all cool-looking
   * text, that imitates unconcious encription pracitises of young teens
   * creating their first username in an online game
   */
  public String row(int i) throws Exception {
    String tempOut = this.block.row(i);
    tempOut = tempOut.replace('a', '4');
    tempOut = tempOut.replace('i', '1');
    tempOut = tempOut.replace('e', '3');
    tempOut = tempOut.replace('o', '0');
    this.block = new TextLine(tempOut);
    return tempOut;
  }//row(int)

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
    if (! (other instanceof Original)){
      return false;
    }
    if (! (other.width() == this.width())){
      return false;
    }
    if (! (TBUtils.eqv(this.block, ((Original) other).block))){
      return false;
    }
    return true;
  }//eqv (TextBlock)
} //Original






