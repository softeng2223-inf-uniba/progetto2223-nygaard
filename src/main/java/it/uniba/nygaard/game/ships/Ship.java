package it.uniba.nygaard.game.ships;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.grids.CellsGrid;

public abstract class Ship {

  private final Coordinate coord;
  private boolean direction;
  private int hp;

  Ship(final int newHp) {
    this.coord = new Coordinate();
    this.direction = false;
    this.hp = newHp;
  }

  public void setCoord(final Coordinate newCoord) {
    this.coord.setRow(newCoord.getRow());
    this.coord.setColumn(newCoord.getColumn());
  }

  public void setDirection(final boolean newDirection) {
    this.direction = newDirection;
  }

  public void setHp(final int newHp) {
    this.hp = newHp;
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

  public boolean outOfMap() {
    if (this.direction) {
      return this.coord.getRow() + this.hp > Util.MAX_ROWS;
    } else {
      return this.coord.getColumn() + this.hp > Util.MAX_COLUMN;
    }
  }

  public boolean intersects(final CellsGrid grid) {
    int startx = Math.max(this.coord.getRow() - 2, Util.MIN_ROWS - 1);
    int starty = Math.max(this.coord.getColumn() - Util.MIN_COLUMN - 1, Util.MIN_ROWS - 1);
    int endx;
    int endy;
    if (this.direction) {
      endx = Math.min(this.coord.getRow() + this.hp - 1, Util.MAX_ROWS - 1);
      endy = Math.min(this.coord.getColumn() - Util.MIN_COLUMN + 1, Util.MAX_ROWS - 1);
    } else {
      endx = Math.min(this.coord.getRow(), Util.MAX_ROWS - 1);
      endy = Math.min(this.coord.getColumn() - Util.MIN_COLUMN + this.hp, Util.MAX_ROWS - 1);
    }
    for (int i = startx; i <= endx; i++) {
      for (int j = starty; j <= endy; j++) {
        if (grid.getCellCharacter(i, j) != Util.SEA_CHARACTER) {
          return true;
        }
      }
    }
    return false;
  }

}
