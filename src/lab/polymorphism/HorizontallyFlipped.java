/*  Author: Gabriela Roznawska
 *  November 2023
 *  Text Layout mini-project
 *  Created with help of online resources provided by Sam Rebelsky, as well as his
 *  personal support
 */

package lab.polymorphism;

public class HorizontallyFlipped implements TextBlock{
  
  TextBlock block;
  Integer width;

  public HorizontallyFlipped(TextBlock blockTemp) {
    this.block = blockTemp;
    this.width = blockTemp.width();
  }

  public String row(int i) throws Exception {
    int x = this.width-1;
    String temp = "";
    while (x >= 0){
      temp += this.block.row(i).substring(x, x+1);
      x--;
    }
    return temp;
  }

  public int height() {
    return this.block.height();
  }

  public int width() {
    return this.width;
  }

  public boolean eqv(TextBlock other) throws Exception {
    if (! (other instanceof HorizontallyFlipped)){
      return false;
    }
    if (! (other.width() == this.width())){
      return false;
    }
    if (! (TBUtils.eqv(this.block, ((HorizontallyFlipped) other).block))){
      return false;
    }
    return true;
  }//eqv (TextBlock)

}
