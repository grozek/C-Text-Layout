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
    HorizontallyFlipped hflip = new HorizontallyFlipped (box3, 10);
    //TBUtils.print(pen, box3);
    //TBUtils.print(pen, trun);
    TBUtils.print(pen, centr);
    TBUtils.print(pen, rjust);
    //TBUtils.print(pen, hflip);
    //box.row(1);
    //box2.row(0);
    //box3.row(1);
    

    
    // Print out the block
   /* TBUtils.print(pen, block);
    TBUtils.print(pen, box);
    TBUtils.print(pen, box2);
    TBUtils.print(pen, box3); 
    
    VComposition Vbox = new VComposition(block, block2);
    BoxedBlock Vbox1 = new BoxedBlock(Vbox);
    Vbox.row(1);
    TBUtils.print(pen, Vbox1);

    VComposition HelloGoodbye = new VComposition(box, box3);
    TBUtils.print(pen, HelloGoodbye);

    HComposition right = new HComposition(box, block2);
    TBUtils.print(pen, right);

    HComposition left = new HComposition(block2, box);
    TBUtils.print(pen, left);
    // Clean up after ourselves.
    */
    pen.close();
  } // main(String[])

} // class TBExpt
