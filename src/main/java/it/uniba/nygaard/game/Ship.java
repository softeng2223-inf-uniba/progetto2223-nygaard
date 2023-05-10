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

  public void setCoord(Coordinate coord) {
    this.coord.setRow(coord.getRow());
    this.coord.setColumn(coord.getColumn());
  }

  public void setDirection(boolean direction) {
    this.direction = direction;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public Coordinate getCoord() {
    return coord;
  }

  public boolean getDirection() {
    return direction;
  }

  public int getHp() {
    return hp;
  }

}
