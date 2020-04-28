public class Move {
  Char color;
  int Column;

  //constructor
  Move (char _color, int _column) {
    color = _color;
    column = _cloumn;
  }

  //methods
  /**
   * @return the color
   */
  public Char getColor() {
  	return color;
  }

  /**
   * @return the column
   */
  public int getColumn() {
  	return Column;
  }
}
