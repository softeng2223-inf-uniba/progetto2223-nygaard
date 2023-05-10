package it.uniba.nygaard.game;

public class Cell {

  char character;
  int shipIndex;

  Cell(char c) {
    this.character = c;
    this.shipIndex = Util.SEA_INDEX;
  }

}
