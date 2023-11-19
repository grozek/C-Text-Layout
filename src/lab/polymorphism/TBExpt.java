package lab.polymorphism;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);
    // Create a block to use
    TextBlock block = new TextLine("Hello");
    TextBlock block2 = new TextLine("GoodBye");
    TextBlock block3 = new TextLine("Truncate");

    BoxedBlock box = new BoxedBlock(block);
    BoxedBlock box2 = new BoxedBlock(box);
    BoxedBlock box3 = new BoxedBlock(block2);

    Truncated trun = new Truncated (box3, 5);
    Centered centr = new Centered (box3, 10);
    RightJustified rjust = new RightJustified (box3, 10);
    HorizontallyFlipped hflip = new HorizontallyFlipped (box3);
    //TBUtils.print(pen, box3);
    //TBUtils.print(pen, trun);
    //TBUtils.print(pen, centr);
    //TBUtils.print(pen, rjust);
    TBUtils.print(pen, hflip);
    //TBUtils.print(pen, vflip);
    VComposition Vbox = new VComposition(box, box3);
    TBUtils.print(pen, Vbox);
    VerticallyFlipped vflip = new VerticallyFlipped (Vbox);
    TBUtils.print(pen, vflip);
    //TBUtils.equal(Vbox1, vflip);
    /* 
    HComposition right = new HComposition(box, block2);
    TBUtils.print(pen, right);

    HComposition left = new HComposition(block2, box);
    TBUtils.print(pen, left);
    // Clean up after ourselves.
    */
    pen.close();
  } // main(String[])

} // class TBExpt
