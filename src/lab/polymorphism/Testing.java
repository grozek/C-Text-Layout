/*
 * Author: Gabriela Roznawska 
 * November 2023 
 * Text Layout mini-project 
 * Created with help of online resources provided by Sam Rebelsky, 
 * as well as his personal support
 * 
 * This program in the file tests previously created classes that 
 * modify textBlocks. 
 */

package lab.polymorphism;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.PrintWriter;


/**
 * The testing procedure very cohesively tests all procedures 
 * that modify the textblocks. The are tested both as top level 
 * block and as parameters to another block.
 */
public class Testing {

  /**
   * Testing the class VerticallyFlipped
   */
  @Test
  public void VerticallyFlippedTests() throws Exception {
    // creating two blocks that will be stacked on top of each other
    TextBlock block = new TextLine("Hello");
    TextBlock block2 = new TextLine("GoodBye");
    // boxing each of the blocks
    BoxedBlock box = new BoxedBlock(block);
    BoxedBlock box2 = new BoxedBlock(block2);
    // VComposing vbox with box to the left, box2 to right
    VComposition vbox = new VComposition(box, box2);
    VComposition vboxFlipped = new VComposition(box2, box);
    VerticallyFlipped vflip = new VerticallyFlipped(vbox);
    VerticallyFlipped newVflip = vflip;
    // tests whether the lines of VerticallyFlipped textblock flipped
    assertTrue(TBUtils.equal(vboxFlipped, vflip));
    // VerticallyFlipped and VComposition objects do not have the same structure
    assertFalse(TBUtils.eq(vboxFlipped, vflip));
    // the same blocks should have the same memory location
    assertTrue(TBUtils.eq(newVflip, vflip));
    // the same blocks were built the same way
    assertTrue(TBUtils.eqv(newVflip, vflip));
    // seemingly the same, blocks built differently are not equivalent
    assertFalse(TBUtils.eqv(vboxFlipped, vflip));
  } // VerticallyFlippedTests()

  /**
   * Testing the class Centered Using Truncated as a parameter for Centered
   */
  @Test
  public void CenteredTests() throws Exception {
    TextBlock block = new TextLine("Hello");
    // creating objects used as a comparison to the object that boxing methods are performed on
    String stringComparedTo = TBUtils.spaces(3).concat("Hell").concat(TBUtils.spaces(3));
    TextBlock textBlockComparedTo = new TextLine(stringComparedTo);
    // truncating and then centering the block
    Truncated trunBlock = new Truncated(block, 4);
    Centered centeredBlock = new Centered(trunBlock, 10);
    // Truncated centered block with the same textline should be equal to one another
    assertTrue(TBUtils.equal(centeredBlock, textBlockComparedTo));
    // TextBlocks that do not have the same memory location, are not equal
    assertFalse(TBUtils.eq(centeredBlock, textBlockComparedTo));
    // TextBlocks made differently are not equal
    assertFalse(TBUtils.eqv(centeredBlock, textBlockComparedTo));
  } // Centered Tests()

  /**
   * Testing the class HorizontallyFlipped Using Original as a parameter for HorizontallyFlipped
   * 
   * @throws Exception
   */
  @Test
  public void HorizontallyFlippedTests() throws Exception {
    // creating two blocks, one standard, one manually reversed
    TextBlock block = new TextLine("HelloGrader");
    TextBlock blockReverse = new TextLine("redarGolleH");
    // creating boxes with the two blocks
    BoxedBlock box = new BoxedBlock(block);
    BoxedBlock boxReverse = new BoxedBlock(blockReverse);
    // fliping non-reversed block (reversing it)
    HorizontallyFlipped hflip = new HorizontallyFlipped(box);
    HorizontallyFlipped newHflip = hflip;
    // tests whether the lines of HorizontallyFlipped textblock flipped
    assertTrue(TBUtils.equal(boxReverse, hflip));
    // HorizontallyFlipped and HComposition objects do not have the same structure
    assertFalse(TBUtils.eq(boxReverse, hflip));
    // the same blocks should have the same memory location
    assertTrue(TBUtils.eq(newHflip, hflip));
    // the same blocks were built the same way
    assertTrue(TBUtils.eqv(newHflip, hflip));
    // seemingly the same, blocks built differently are not equivalent
    assertFalse(TBUtils.eqv(boxReverse, hflip));

    // encoding a line with original class
    Original original = new Original(blockReverse);
    // two lines, one encoded, one not, are not the same
    assertFalse(TBUtils.equal(original, blockReverse));
  } // HorizontallyFlippedTests()

  /**
   * Testing the class RightJustified Using Centered as a parameter for RightJustified
   */
  @Test
  public void RightJustifiedTests() throws Exception {
    // creating objects used as a comparison to the object that boxing methods are performed on
    TextBlock block = new TextLine("Ants");
    // Manualy performing Centered, first making a string, then using it for textBlock
    String stringComparedTo = TBUtils.spaces(8).concat(block.row(0)).concat(TBUtils.spaces(8));
    TextBlock textBlockComparedTo = new TextLine(stringComparedTo);
    // Manualy performing RightJustified, first adding it to string, then updating textBlock
    stringComparedTo = TBUtils.spaces(8).concat(stringComparedTo);
    textBlockComparedTo = new TextLine(stringComparedTo);
    // centering and then truncating the block
    Centered centeredBlock = new Centered(block, 20);
    RightJustified rightJustifiedBlock = new RightJustified(centeredBlock, 28);

    // RightJustified centered block with the same textline should be equal to one another
    assertTrue(TBUtils.equal(rightJustifiedBlock, textBlockComparedTo));
    // TextBlocks that do not have the same memory location, are not equal
    assertFalse(TBUtils.eq(centeredBlock, textBlockComparedTo));
    // TextBlocks made differently are not equal
    assertFalse(TBUtils.eqv(centeredBlock, textBlockComparedTo));
  } // RightJustifiedTests()

  /**
   * Testing the class Centered Using Truncated as a parameter for Centered
   */
  @Test
  public void TruncatedTests() throws Exception {
    // creating a basic line
    TextBlock block = new TextLine("Sloths are cool");
    TextBlock block2 = new TextLine("looc era shtolS");
    HorizontallyFlipped hflip = new HorizontallyFlipped(block);
    TextBlock blockTruncated = new TextLine(block2.row(0).substring(0, 9));
    Truncated trunFlip = new Truncated(hflip, 9);

    // Truncated centered block with the same textline should be equal to one another
    assertTrue(TBUtils.equal(trunFlip, blockTruncated));
    // TextBlocks that do not have the same memory location, are not equal
    assertFalse(TBUtils.eq(trunFlip, blockTruncated));
    // TextBlocks made differently are not equal
    assertFalse(TBUtils.eqv(trunFlip, blockTruncated));
  } // TruncatedTests()


  /**
   * Testing the class Original Using VerticallyFlipped as a parameter for Original
   */
  @Test
  public void OriginalTests() throws Exception {
    // creating basic blocks
    TextBlock block = new TextLine("Ameba");
    TextBlock block2 = new TextLine("Am3b4");
    // creating vcomposition and verticallyflipped
    VComposition vbox = new VComposition(block, block2);
    VerticallyFlipped vflip = new VerticallyFlipped(vbox);
    Original original = new Original(block);
    VComposition vboxWithOriginal = new VComposition(block, original);
    VerticallyFlipped vflipWithOriginal = new VerticallyFlipped(vboxWithOriginal);
    VerticallyFlipped vflipWithOriginalCopy = vflipWithOriginal;
    // two textlines with the same lines have are equal
    assertTrue(TBUtils.equal(original, block2));
    // two blocks with the same lines but different memory locations should not be eq
    assertFalse(TBUtils.eq(vbox, vboxWithOriginal));
    // two blocks made the same way should be eqv
    assertTrue(TBUtils.eqv(vflipWithOriginal, vflipWithOriginalCopy));
  } // OriginalTests ()
} // Testing class
