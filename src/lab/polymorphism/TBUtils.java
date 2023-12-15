package lab.polymorphism;

import java.io.PrintWriter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 * 
 *          Additions in code: Gabriela Roznawska Methods: (equal), (eqv) and (eq) November 2023
 *          Text Layout mini-project Created with help of online resources provided by Sam Rebelsky,
 *          as well as his personal support
 */

public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /**
   * Two textblocks are equal if they contain the same lines.
   */
  static boolean equal(TextBlock t1, TextBlock t2) {
    int t1height = t1.height();
    if (t1height == t2.height()) {
      for (int i = 0; i < t1.height(); i++) {
        try {
          if (!t1.row(i).equals(t2.row(i))) {
            return false;
          } // if
        } catch (Exception e) {
          return false;
        } // catch
      }
      return true;
    } // if
    return false;
  }// equal(TextBlock, TextBlock)


  /**
   * Two textblocks are equal if they were built in the same way.
   */
  static Boolean eqv(TextBlock t1, TextBlock t2) {
    return t1.eqv(t2);
  }// eqv(TextBlock, TextBlock)


  /**
   * Two textblocks are equal if they occupy the same memory location.
   */
  static Boolean eq(TextBlock t1, TextBlock t2) {
    if (t1 == t2) {
      return true;
    } // if
    return false;
  }// eq(TextBlock, TextBlock)
}// class TBUtils
