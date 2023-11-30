/*  Author: Gabriela Roznawska
 *  November 2023
 *  Text Layout mini-project
 *  Created with help of online resources provided by Sam Rebelsky, as well as his
 *  personal support
 */

package lab.polymorphism;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Testing {

  @Test
  public void equalTest () throws Exception{
    TextBlock block = new TextLine("Hello");
    TextBlock block2 = new TextLine("GoodBye");
    BoxedBlock box = new BoxedBlock(block);
    BoxedBlock box2 = new BoxedBlock(block2);
    VComposition vbox = new VComposition(box, box2);
    VComposition vboxFlipped = new VComposition(box2, box);
    VerticallyFlipped vflip = new VerticallyFlipped (vbox);
    VerticallyFlipped newVflip = vflip;
    assertTrue(TBUtils.equal(vboxFlipped, vflip));
    assertFalse(TBUtils.eq(vboxFlipped, vflip));
    assertTrue(TBUtils.eq(newVflip, vflip));
    
  }

  @Test
  public void VerticalTest () throws Exception{
    TextBlock block = new TextLine("Hello");
    TextBlock block2 = new TextLine("GoodBye");
    BoxedBlock box = new BoxedBlock(block);
    BoxedBlock box2 = new BoxedBlock(block2);
    VComposition vbox = new VComposition(box, box2);
    VComposition vboxFlipped = new VComposition(box2, box);
    VerticallyFlipped vflip = new VerticallyFlipped (vbox);
    VerticallyFlipped newVflip = vflip;
    assertFalse(TBUtils.eq(vboxFlipped, vflip));
    assertTrue(TBUtils.eq(newVflip, vflip));
  }


  @Test
  public void eqvTest () throws Exception{
    TextBlock block = new TextLine("Hello");
    TextBlock block2 = new TextLine("GoodBye");
    BoxedBlock box = new BoxedBlock(block);
    BoxedBlock box2 = new BoxedBlock(block2);
    HComposition vbox = new HComposition(box, box2);
    HComposition hboxFlipped = new HComposition(box2, box);
    HorizontallyFlipped hflip = new HorizontallyFlipped (vbox);
    HorizontallyFlipped newHflip = hflip;
    assertFalse(TBUtils.eqv(hboxFlipped, hflip));
    assertTrue(TBUtils.eqv(newHflip, hflip));
  }




}