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

    TextLine line = new TextLine ("Hello");
    BoxedBlock box = new BoxedBlock (line);
    PrintWriter pen = new PrintWriter(System.out, true);

    TBUtils.print(pen, box);
    TBUtils.print(pen, box);

    Centered centr = new Centered (box, 10);
    Centered centrTrun = new Centered (box, 3);
    RightJustified right = new RightJustified (box, 10);
    RightJustified rightTrun = new RightJustified (box, 3);
    Truncated trunBlock = new Truncated (centr, 3);
    TBUtils.print(pen, trunBlock);
    TBUtils.print(pen, centr);
    TBUtils.print(pen, centrTrun);
    TBUtils.print(pen, right);
    TBUtils.print(pen, rightTrun);

    // All important tests are in Testing.java
  } // main(String[])

}// class TBExpt
