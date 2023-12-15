package lab.polymorphism;


/**
 * A text block surrounded by a box.
 *
 * @author Samuel A. Rebelsky
 *  With additions of Gabriela Roznawska
 * @version 1.2 of February 2019
 */
public class BoxedBlock implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box
   */
  TextBlock contents;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new line with contents _contents.
   */
  public BoxedBlock(TextBlock _contents) {
    this.contents = _contents;
  } // BoxedBlock(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    int h = this.contents.height();
    if ((i == 0) || (i == h + 1)) {
      return "+" + TBUtils.dashes(this.contents.width()) + "+";
    } // if
    else if ((i > 0) && (i <= h)) {
      return "|" + this.contents.row(i - 1) + "|";
    } // else if
    else {
      throw new Exception("Invalid row " + i);
    } // else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return 2 + this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return 2 + this.contents.width();
  } // width()


  /*
   * Two textblocks are equal if they were built in the same way.
   * Testing if the two blocks were actually build the same way.
   */
  public boolean eqv(TextBlock other) {
    if (! (other instanceof BoxedBlock)){
      return false;
    } // if

    if (! (TBUtils.eqv(this.contents, ((BoxedBlock) other).contents))){
      return false;
    } // if
    return true;
  }//eqv (TextBlock)
} // class BoxedBlock
