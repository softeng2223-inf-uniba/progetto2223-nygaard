package it.uniba.nygaard.game.ships;

public final class Coordinate {

  private int row;
  private char column;

  public Coordinate() {

  }

  public void setRow(final int row) {
    this.row = row;
  }

  public void setColumn(final char column) {
    this.column = column;
  }

  public int getRow() {
    return row;
  }

  public char getColumn() {
    return column;
  }

}
