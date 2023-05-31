package it.uniba.nygaard.game.entity;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.entity.grids.CellsGrid;
import it.uniba.nygaard.game.entity.grids.CharactersGrid;
import it.uniba.nygaard.game.entity.ships.Coordinate;
import it.uniba.nygaard.game.entity.ships.Destroyer;
import it.uniba.nygaard.game.entity.ships.AircraftCarrier;
import it.uniba.nygaard.game.entity.ships.Battleship;
import it.uniba.nygaard.game.entity.ships.Cruiser;
import it.uniba.nygaard.game.entity.ships.Ship;

import java.util.Random;


/**
 * << Entity >>
 * <h2> Match </h2>
 * <p>
 * La classe Match si occupa della partita.
 * Contiene tutte le informazioni relative alla partita
 * e tutti i metodi per settarli e modificarli.
 * </p>
 */
public final class Match {
  /**
   * <h3> inGame </h3>
   * <p>
   *     Indica se il giocatore è in partita.
   * </p>
   */
  private boolean inGame;
    /**
     * <h3> difficulty </h3>
     * <p>
     *     Difficoltà della partita.
     * </p>
     */
  private int difficulty;
  /**
   * <h3> difficultyNames </h3>
   * <p>
   *     Nomi delle difficoltà.
   * </p>
   */
  private final String[] difficultyNames;
    /**
     * <h3> attempts </h3>
     * <p>
     *     Tentativi per ogni difficoltà.
     * </p>
     */
  private final int[] attempts;
  private final int failedAttempts;
  private final int usedAttempts;
  /**
   * <h3> ships </h3>
   * <p>
   * Navi della partita.
   * </p>
   *
   * @see Ship
   */
  private final Ship[] ships;
    /**
     * <h3> defenseGrid </h3>
     * <p>
     *     Griglia di difesa.
     * </p>
     * @see CellsGrid
     */
  private final CellsGrid defenseGrid;
    /**
     * <h3> attackGrid </h3>
     * <p>
     *     Griglia di attacco.
     * </p>
     * @see CharactersGrid
     */
  private final CharactersGrid attackGrid;
    /**
     * <h3> maxTime </h3>
     * <p>
     *     Tempo massimo per la partita.
     * </p>
     */
  private int maxTime;
    /**
     * <h3> startTime </h3>
     * <p>
     *     Tempo di inizio della partita espresso in millisecondi.
     * </p>
     */
  private long startTime;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Metodo costruttore di Match.
   * Inizializza tutti i suoi attributi ai valori di default prefissati.
   * </p>
   */
  public Match() {
    this.inGame = false;
    this.difficulty = Util.DIFFICULTY_MEDIUM;
    this.difficultyNames = new String[]{Util.EASY_NAME, Util.MEDIUM_NAME, Util.HARD_NAME};
    this.attempts = new int[]{Util.EASY_ATTEMPTS, Util.MEDIUM_ATTEMPTS, Util.HARD_ATTEMPTS};
    this.failedAttempts = 0;
    this.usedAttempts = 0;
    this.ships = new Ship[Util.MAX_SHIP];
    int i = Util.MIN_SHIP;
    for (int j = 0; j < Util.AIRCRAFT_NO; j++) {
      this.ships[i - 1] = new AircraftCarrier();
      i++;
    }
    for (int j = 0; j < Util.BATTLESHIP_NO; j++) {
      this.ships[i - 1] = new Battleship();
      i++;
    }
    for (int j = 0; j < Util.CRUISER_NO; j++) {
      this.ships[i - 1] = new Cruiser();
      i++;
    }
    for (int j = 0; j < Util.DESTROYER_NO; j++) {
      this.ships[i - 1] = new Destroyer();
      i++;
    }
    this.defenseGrid = new CellsGrid(Util.MAX_ROWS);
    this.attackGrid = new CharactersGrid(Util.MAX_ROWS);
    maxTime = Util.DEFAULT_TIME;
  }
  /**
   * <h3> getInGame </h3>
   * <p>
   *     Restituisce lo stato della partita.
   * </p>
   * @return inGame Stato della partita.
   */
  public boolean getInGame() {
    return this.inGame;
  }
    /**
     * <h3> getDifficulty </h3>
     * <p>
     *     Restituisce la difficoltà della partita.
     * </p>
     * @return difficulty Difficoltà della partita.
     */
  public int getDifficulty() {
    return this.difficulty;
  }

  /**
   * <h3> getDifficultyNames </h3>
   * <p>
   *     Restituisce i nomi delle difficoltà.
   * </p>
   * @param index Indice della difficoltà.
   * @return difficultyNames Nomi delle difficoltà.
   */
  public String getDifficultyNames(final int index) {
    return this.difficultyNames[index];
  }

  /**
   * <h3> getAttempts </h3>
   * <p>
   *     Restituisce il numero di tentativi per ogni difficoltà.
   * </p>
   * @param index Indice dei tentativi.
   * @return attempts Tentativi per ogni difficoltà.
   */
  public int getAttempts(final int index) {
    return this.attempts[index];
  }

  /**
   * <h3> setAttempts </h3>
   * <p>
   *     Imposta il numero di tentativi per una specifica difficoltà.
   * </p>
   * @param index Indice dei tentativi
   * @param value Nuovo numero di tentativi falliti per la difficoltà.
   */
  public void setAttempts(final int index, final int value) {
    this.attempts[index] = value;
  }

  public int getFailedAttempts() {
    return this.failedAttempts;
  }

  public int getUsedAttempts() {
    return this.usedAttempts;
  }

    /**
     * <h3> getDefenseGrid </h3>
     * <p>
     *     Restituisce la griglia di difesa della partita.
     * </p>
     * @return defenseGrid Griglia di difesa della partita.
     */
  public String getDefenseGrid() {
    return this.defenseGrid.toString();
  }
    /**
     * <h3> getAttackGrid </h3>
     * <p>
     *     Restituisce la griglia di attacco della partita.
     * </p>
     * @return attackGrid Griglia di attacco della partita.
     */
  public String getAttackGrid() {
    return this.attackGrid.toString();
  }
  /**
   * <h3> setDifficulty </h3>
   * <p>
   * Imposta la difficoltà della partita.
   * </p>
   *
   * @param newDifficulty Difficoltà della partita.
   */
  public void setDifficulty(final int newDifficulty) {
    this.difficulty = newDifficulty;
  }
    /**
     * <h3> setInGame </h3>
     * <p>
     * Imposta lo stato della partita.
     * </p>
     *
     * @param newInGame Stato della partita.
     */
  public void setInGame(final boolean newInGame) {
    this.inGame = newInGame;
  }
    /**
     * <h3> getShip </h3>
     * <p>
     *     Restituisce la nave in posizione index.
     * </p>
     * @param index Indice della nave.
     * @return ships[index] Nave in posizione index.
     */
  public Ship getShip(final int index) {
    return this.ships[index];
  }
  /**
     * <h3> getMaxTime </h3>
     * <p>
     *     Restituisce il tempo massimo per la partita.
     * </p>
     * @return maxTime Tempo massimo per la partita.
     */
  public int getMaxTime() {
    return maxTime;
  }
  /**
   * <h3> setMaxTime </h3>
   * <p>
   * Imposta il tempo massimo per la partita.
   * </p>
   *
   * @param newMaxTime Tempo massimo per la partita.
   */
  public void setMaxTime(final int newMaxTime) {
    this.maxTime = newMaxTime;
  }

  /**
   * <h3> getStartTime </h3>
   * <p>
   *     Restituisce il tempo di inizio della partita.
   * </p>
   * @return startTime Tempo di inizio della partita.
   */
  public long getStartTime() {
    return startTime;
  }

  /**
   * <h3> setStartTime </h3>
   * <p>
   * Imposta il tempo di inizio della partita.
   * </p>
   *
   * @param newStartTime Tempo di inizio della partita.
   */
  public void setStartTime(final long newStartTime) {
    this.startTime = newStartTime;
  }

  /**
   * <h3> initializeShips </h3>
   * <p>
   * Il metodo initializeShips inizializza le navi in posizioni casuali.
   * </p>
   *
   * @param i Indice della nave da inizializzare.
   * @return true se tutte le navi sono state inizializzate, false altrimenti.
   */
  public boolean initializeShips(final int i) {
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
      this.ships[i - 1].setDirection(direction);
      this.ships[i - 1].setCoord(coord);
      if (this.ships[i - 1].outOfMap()) {
        j--;
        continue;
      }
      if (this.ships[i - 1].intersects(defenseGrid)) {
        continue;
      }
      placeShip(i - 1);
      if (initializeShips(i + 1)) {
        return true;
      }
      removeShip(i - 1);
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
  private void placeShip(final int i) {
    if (ships[i].getDirection() == Util.VERTICAL) {
      for (int j = 0; j < ships[i].getHp(); j++) {
        defenseGrid.setCellCharacter(ships[i].getCoordRow() - 1 + j,
                ships[i].getCoordColumn() - Util.MIN_COLUMN, Util.SHIP_CHARACTER);
        defenseGrid.setCellShipIndex(ships[i].getCoordRow() - 1 + j,
                ships[i].getCoordColumn() - Util.MIN_COLUMN, i);
      }
    } else {
      for (int j = 0; j < ships[i].getHp(); j++) {
        defenseGrid.setCellCharacter(ships[i].getCoordRow() - 1,
                ships[i].getCoordColumn() - Util.MIN_COLUMN + j, Util.SHIP_CHARACTER);
        defenseGrid.setCellShipIndex(ships[i].getCoordRow() - 1,
                ships[i].getCoordColumn() - Util.MIN_COLUMN + j, i);
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
  private void removeShip(final int i) {
    for (int j = Util.MIN_ROWS; j <= Util.MAX_ROWS; j++) {
      for (int k = Util.MIN_ROWS; k <= Util.MAX_ROWS; k++) {
        if (defenseGrid.getCellShipIndex(j - 1, k - 1) == i) {
          defenseGrid.setCellCharacter(j - 1, k - 1, Util.SEA_CHARACTER);
          defenseGrid.setCellShipIndex(j - 1, k - 1, Util.SEA_INDEX);
        }
      }
    }
  }
}
