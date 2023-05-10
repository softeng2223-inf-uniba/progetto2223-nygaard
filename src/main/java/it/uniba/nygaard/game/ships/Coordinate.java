package it.uniba.nygaard.game.ships;

public class Coordinate {

  private int row;
  private char column;

  public Coordinate() {

  }

  public void setRow(int row) {
    this.row = row;
  }

  public void setColumn(char column) {
    this.column = column;
  }

  public int getRow() {
    return row;
  }

  public char getColumn() {
    return column;
  }

}
