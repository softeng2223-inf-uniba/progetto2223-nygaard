package it.uniba.nygaard.game;

public class Cell {

  char character;
  int shipIndex;

  Cell(char c) {
    this.character = c;
    this.shipIndex = Util.SEA_INDEX;
  }

  void setCharacter(char character) {
    this.character = character;
  }

  void setShipIndex(int shipIndex) {
    this.shipIndex = shipIndex;
  }

}
