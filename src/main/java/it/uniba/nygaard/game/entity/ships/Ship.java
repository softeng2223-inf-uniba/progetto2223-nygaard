package it.uniba.nygaard.game.entity.ships;

import it.uniba.nygaard.game.utility.UGrid;
import it.uniba.nygaard.game.entity.grids.CellsGrid;
import it.uniba.nygaard.game.utility.UShip;

/**
 * <h2> Ship </h2>
 * <p>
 * La classe Ship rappresenta una generica nave.
 * </p>
 */
public class Ship {

  /**
   * <h3> coord </h3>
   * <p>
   * Coordinate della nave.
   * </p>
   *
   * @see Coordinate
   */
  private final Coordinate coord;
  /**
   * <h3> direction </h3>
   * <p>
   * Direzione della nave.
   * </p>
   */
  private boolean direction;
  /**
   * <h3> hp </h3>
   * <p>
   * Hp della nave.
   * </p>
   */
  private int hp;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe Ship.
   * Imposta gli hp della nave.
   * La nave è posizionata in orizzontale.
   * </p>
   *
   * @param newHp Hp della nave.
   */
  public Ship(final int newHp) {
    this.coord = new Coordinate();
    this.direction = UShip.HORIZONTAL;
    this.hp = newHp;
  }

  /**
   * <h3> setCoord </h3>
   * <p>
   * Imposta le coordinate della nave.
   * </p>
   *
   * @param newCoord Coordinate della nave.
   */
  public void setCoord(final Coordinate newCoord) {
    this.coord.setRow(newCoord.getRow());
    this.coord.setColumn(newCoord.getColumn());
  }

  /**
   * <h3> setDirection </h3>
   * <p>
   * Imposta la direzione della nave.
   * </p>
   *
   * @param newDirection Direzione della nave.
   */
  public void setDirection(final boolean newDirection) {
    this.direction = newDirection;
  }

  /**
   * <h3> getCoordRow </h3>
   * <p>
   * Restituisce la riga della coordinata iniziale della nave.
   * </p>
   *
   * @return Riga della coordinata iniziale della nave.
   */
  public int getCoordRow() {
    return coord.getRow();
  }

  /**
   * <h3> getCoordColumn </h3>
   * <p>
   * Restituisce la colonna della coordinata iniziale della nave.
   * </p>
   *
   * @return Colonna della coordinata iniziale della nave.
   */
  public char getCoordColumn() {
    return coord.getColumn();
  }

  /**
   * <h3> getDirection </h3>
   * <p>
   * Restituisce la direzione della nave.
   * </p>
   *
   * @return Direzione della nave.
   */
  public boolean getDirection() {
    return direction;
  }

  /**
   * <h3> getHp </h3>
   * <p>
   * Restituisce gli hp della nave.
   * </p>
   *
   * @return Hp della nave.
   */
  public int getHp() {
    return hp;
  }

  /**
   * <h3> hit </h3>
   * <p>
   * Decrementa gli hp della nave.
   * </p>
   */
  public void hit() {
    this.hp--;
  }

  /**
   * <h3> outOfMap </h3>
   * <p>
   * Verifica se la nave è fuori dalla griglia.
   * </p>
   *
   * @return True se la nave è fuori dalla griglia, false altrimenti.
   */
  public boolean outOfMap(final CellsGrid grid) {
    if (this.direction == UShip.VERTICAL) {
      return this.coord.getRow() + this.hp > grid.getMaxRows();
    } else {
      return this.coord.getColumn() + this.hp > grid.getMaxColumn();
    }
  }

  /**
   * <h3> intersects </h3>
   * <p>
   * Verifica se la nave interseca altre navi.
   * </p>
   *
   * @param grid Griglia di gioco.
   * @return True se la nave interseca altre navi, false altrimenti.
   */
  public boolean intersects(final CellsGrid grid) {
    int startx = Math.max(this.coord.getRow() - 2, UGrid.MIN_ROWS - 1);
    int starty = Math.max(this.coord.getColumn() - UGrid.MIN_COLUMN - 1, UGrid.MIN_ROWS - 1);
    int endx;
    int endy;
    if (this.direction == UShip.VERTICAL) {
      endx = Math.min(this.coord.getRow() + this.hp - 1, grid.getMaxRows() - 1);
      endy = Math.min(this.coord.getColumn() - UGrid.MIN_COLUMN + 1, grid.getMaxRows() - 1);
    } else {
      endx = Math.min(this.coord.getRow(), grid.getMaxRows() - 1);
      endy = Math.min(this.coord.getColumn() - UGrid.MIN_COLUMN + this.hp, grid.getMaxRows() - 1);
    }
    for (int i = startx; i <= endx; i++) {
      for (int j = starty; j <= endy; j++) {
        if (grid.getCellCharacter(i, j) != UGrid.SEA_CHARACTER) {
          return true;
        }
      }
    }
    return false;
  }
}
