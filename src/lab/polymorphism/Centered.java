package lab.polymorphism;

/* given a text block and a width, builds a new block that centers the block within that width.
 */
public class Centered implements TextBlock{

  TextBlock block;
  int width;


  public Centered(TextBlock blockTemp, int newWidth) {
    this.block = blockTemp;
    this.width = newWidth;
  }

  /* Given a newWidth it adds half of the extra width (newWidth-textblock width) in front of the
   * new return string, so that is centered within the given width
   */
  public String row(int i) throws Exception {
    int holder = this.width/2;
    String spaces = TBUtils.spaces(holder);
    return spaces.concat(this.block.row(i));
  }

  public int height() {
    return this.block.height();
  }

  public int width() {
    return this.width;
  }


} //Centered