package lab.polymorphism;

/**
 * The horizontal composition of two text blocks.
 * 
 * @author Samuel A. Rebelsky
 * With additions from Gabriela Roznawska
 * @version 1.3 of February 2019
 */
public class HComposition implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left portion of the composition.
   */
  TextBlock left;

  /**
   * The right portion of the composition.
   */
  TextBlock right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing left and right side by side.
   */
  public HComposition(TextBlock left, TextBlock right) {
    this.left = left;
    this.right = right;
  } // HComposition(String)

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
    int lh = this.left.height();
    int rh = this.right.height();
    int h = Math.max(lh, rh);

    // Sanity check
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    String result;
    if (i < lh) {
      result = this.left.row(i);
    } else {
      result = TBUtils.spaces(this.left.width());
    } // if
    if (i < rh) {
      result = result.concat(this.right.row(i));
    } else {
      result = result.concat(TBUtils.spaces(this.right.width()));
    } // if

    return result;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    // The height is the greater of the heights of the left and right
    // blocks.
    return Math.max(this.left.height(), this.right.height());
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    // The number of columns is the width of the left plus the
    // width of the right.
    return this.left.width() + this.right.width();
  } // width()

  /*
   * Two textblocks are equal if they were built in the same way. Testing if the two blocks were
   * actually build the same way.
   */
  public boolean eqv(TextBlock other) {
    if (!((other instanceof HComposition))) {
      return false;
    } // if
    if (!((TBUtils.eqv(this.left, ((HComposition) other).left))
        && (TBUtils.eqv(this.right, ((HComposition) other).right)))) {
      return false;
    } // if
    return true;
  }// eqv (TextBlock)
} // class HComposition
