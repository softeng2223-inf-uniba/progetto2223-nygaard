package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;
import it.uniba.nygaard.game.entity.grids.CellsGrid;
import it.uniba.nygaard.game.entity.ships.Coordinate;
import it.uniba.nygaard.game.entity.ships.Ship;
import java.util.Random;

/**
 * << Control >>
 * <h2> StartMatchCommand </h2>
 * <p>
 *     La classe StartMatchCommand rappresenta il comando per iniziare la partita.
 * </p>
 * @see CommandInterface
 */
final class StartMatchCommand implements CommandInterface {
  /**
   * <h3> instance </h3>
   * <p>
   *     Istanza di StartMatchCommand.
   * </p>
   */
  private static StartMatchCommand instance = new StartMatchCommand();
  /**
   * <h3> Costruttore </h3>
   * <p>
   *     Costruttore della classe StartMatchCommand.
   * </p>
   */
  private StartMatchCommand() {
  }
  /**
   * <h3> getInstance </h3>
   * <p>
   *    Restituisce l'istanza di StartMatchCommand.
   * </p>
   */
  static StartMatchCommand getInstance() {
    return instance;
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *     Esegue il comando.
   * </p>
   */
  public void executeCommand(final String[] command) {
    Match p = GameManager.getMatch();
    if (p.getDifficulty() == Util.DIFFICULTY_NOT_SETTED) {
      StartMatchBoundary.noDifficulty();
      return;
    }
    if (p.getInGame()) {
      StartMatchBoundary.alreadyInGame();
      return;
    }
    p.setInGame(true);
    this.initializeShips(Util.MIN_SHIP, p);
    ShowGridBoundary.printGrid(p.getAttackGrid());
  }
  /**
   * <h3> initializeShips </h3>
   * <p>
   *     Inizializza le navi.
   * </p>
   * @param i Indice della nave da inizializzare.
   * @param match Partita.
   * @return true se tutte le navi sono state inizializzate, false altrimenti.
   */
  private boolean initializeShips(final int i, final Match match) {
    if (i > Util.MAX_SHIP) {
      return true;
    }
    boolean direction;
    Random rnd = new Random();
    Coordinate coord = new Coordinate();
    for (int j = Util.MIN_GENERATIONS; j <= Util.MAX_GENERATIONS; j++) {
      if (rnd.nextInt(2) == 1) {
        direction = Util.VERTICAL;
      } else {
        direction = Util.HORIZONTAL;
      }
      coord.setRow(rnd.nextInt(Util.MAX_ROWS) + 1);
      coord.setColumn((char) (rnd.nextInt(Util.MAX_COLUMN - Util.MIN_COLUMN + 1) + Util.MIN_COLUMN));
      match.getShip(i - 1).setDirection(direction);
      match.getShip(i - 1).setCoord(coord);
      if (outOfMap(match.getShip(i - 1))) {
        j--;
        continue;
      }
      if (intersects(match.getDefenseGrid(), match.getShip(i - 1))) {
        continue;
      }
      placeShip(i - 1, match);
      if (initializeShips(i + 1, match)) {
        return true;
      }
      removeShip(i - 1, match);
    }
    return false;
  }

  /**
   * <h3> placeShip </h3>
   * <p>
   * Il metodo placeShip posiziona la nave i-esima sulla griglia di difesa.
   * </p>
   *
   * @param i Indice della nave da posizionare.
   */
  private static void placeShip(final int i, final Match match) {
    Ship ship = match.getShip(i);
    if (match.getShip(i).getDirection() == Util.VERTICAL) {
      for (int j = 0; j < ship.getHp(); j++) {
        match.getDefenseGrid().setCellCharacter(ship.getCoordRow() - 1 + j,
                ship.getCoordColumn() - Util.MIN_COLUMN, Util.SHIP_CHARACTER);
        match.getDefenseGrid().setCellShipIndex(ship.getCoordRow() - 1 + j,
                ship.getCoordColumn() - Util.MIN_COLUMN, i);
      }
    } else {
      for (int j = 0; j < ship.getHp(); j++) {
        match.getDefenseGrid().setCellCharacter(ship.getCoordRow() - 1,
                ship.getCoordColumn() - Util.MIN_COLUMN + j, Util.SHIP_CHARACTER);
        match.getDefenseGrid().setCellShipIndex(ship.getCoordRow() - 1,
                ship.getCoordColumn() - Util.MIN_COLUMN + j, i);
      }
    }
  }

  /**
   * <h3> removeShip </h3>
   * <p>
   * Il metodo removeShip rimuove la nave i-esima dalla griglia di difesa.
   * </p>
   *
   * @param i Indice della nave da rimuovere.
   */
  private static void removeShip(final int i, final Match match) {
    for (int j = Util.MIN_ROWS; j <= Util.MAX_ROWS; j++) {
      for (int k = Util.MIN_ROWS; k <= Util.MAX_ROWS; k++) {
        if (match.getDefenseGrid().getCellShipIndex(j - 1, k - 1) == i) {
          match.getDefenseGrid().setCellCharacter(j - 1, k - 1, Util.SEA_CHARACTER);
          match.getDefenseGrid().setCellShipIndex(j - 1, k - 1, Util.SEA_INDEX);
        }
      }
    }
  }

  /**
   * <h3> outOfMap </h3>
   * <p>
   * Verifica se la nave è fuori dalla griglia.
   * </p>
   *
   * @return True se la nave è fuori dalla griglia, false altrimenti.
   */
  private static boolean outOfMap(final Ship ship) {
    if (ship.getDirection() == Util.VERTICAL) {
      return ship.getCoordRow() + ship.getHp() > Util.MAX_ROWS;
    } else {
      return ship.getCoordColumn() + ship.getHp() > Util.MAX_COLUMN;
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
  private static boolean intersects(final CellsGrid grid, final Ship ship) {
    int startx = Math.max(ship.getCoordRow() - 2, Util.MIN_ROWS - 1);
    int starty = Math.max(ship.getCoordColumn() - Util.MIN_COLUMN - 1, Util.MIN_ROWS - 1);
    int endx;
    int endy;
    if (ship.getDirection() == Util.VERTICAL) {
      endx = Math.min(ship.getCoordRow() + ship.getHp() - 1, Util.MAX_ROWS - 1);
      endy = Math.min(ship.getCoordColumn() - Util.MIN_COLUMN + 1, Util.MAX_ROWS - 1);
    } else {
      endx = Math.min(ship.getCoordRow(), Util.MAX_ROWS - 1);
      endy = Math.min(ship.getCoordColumn() - Util.MIN_COLUMN + ship.getHp(), Util.MAX_ROWS - 1);
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
