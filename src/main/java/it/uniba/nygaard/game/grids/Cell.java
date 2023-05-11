package it.uniba.nygaard.game.grids;

import it.uniba.nygaard.game.Util;

class Cell {

  private char character;
  private int shipIndex;

  Cell(final char c) {
    this.character = c;
    this.shipIndex = Util.SEA_INDEX;
  }

  void setCharacter(final char newCharacter) {
    this.character = newCharacter;
  }

  void setShipIndex(final int newShipIndex) {
    this.shipIndex = newShipIndex;
  }

  char getCharacter() {
    return character;
  }

  int getShipIndex() {
    return shipIndex;
  }

}
