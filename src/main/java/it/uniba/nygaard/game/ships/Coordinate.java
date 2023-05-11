package it.uniba.nygaard.game.ships;

public final class Coordinate {

  private int row;
  private char column;

  public Coordinate() {

  }

  public void setRow(final int newRow) {
    this.row = newRow;
  }

  public void setColumn(final char newColumn) {
    this.column = newColumn;
  }

  public int getRow() {
    return row;
  }

  public char getColumn() {
    return column;
  }

}
