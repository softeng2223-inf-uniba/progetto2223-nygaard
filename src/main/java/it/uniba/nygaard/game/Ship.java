package it.uniba.nygaard.game;

public abstract class Ship {

  private final Coordinate coord;
  private boolean direction;
  private int hp;

  public Ship(int hp) {
    this.coord = new Coordinate();
    this.direction = false;
    this.hp = hp;
  }

}
