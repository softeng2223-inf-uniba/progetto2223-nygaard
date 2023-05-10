package it.uniba.nygaard.game.grids;

import it.uniba.nygaard.game.Util;

class Cell {

  private char character;
  private int shipIndex;

  Cell(final char c) {
    this.character = c;
    this.shipIndex = Util.SEA_INDEX;
  }

  void setCharacter(final char character) {
    this.character = character;
  }

  void setShipIndex(final int shipIndex) {
    this.shipIndex = shipIndex;
  }

  char getCharacter() {
    return character;
  }

  int getShipIndex() {
    return shipIndex;
  }

}
