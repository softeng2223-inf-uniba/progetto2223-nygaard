package it.uniba.nygaard.game.entity.ships;
import it.uniba.nygaard.game.Util;

/**
 * <h2> Ship </h2>
 * <p>
 * La classe Ship rappresenta una generica nave.
 * </p>
 */
public abstract class Ship {
  /**
   * <h3> coord </h3>
   * <p>
   * Coordinate della nave.
   * </p>
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
   * </p>
   *
   * @param newHp Hp della nave.
   */
  Ship(final int newHp) {
    this.coord = new Coordinate();
    this.direction = Util.HORIZONTAL;
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
   * <h3> setHp </h3>
   * <p>
   * Imposta gli hp della nave.
   * </p>
   *
   * @param newHp Hp della nave.
   */
  public void setHp(final int newHp) {
    this.hp = newHp;
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
}
