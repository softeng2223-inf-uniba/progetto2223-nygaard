package it.uniba.nygaard.game.entity;

import it.uniba.nygaard.game.entity.grids.CellsGrid;
import it.uniba.nygaard.game.entity.grids.CharactersGrid;
import it.uniba.nygaard.game.entity.ships.Coordinate;
import it.uniba.nygaard.game.entity.ships.Ship;
import it.uniba.nygaard.game.entity.ships.ShipType;
import it.uniba.nygaard.game.utility.UGrid;
import it.uniba.nygaard.game.utility.UShip;
import it.uniba.nygaard.game.utility.UDifficulty;
import it.uniba.nygaard.game.utility.UTime;
import it.uniba.nygaard.game.utility.UResult;
import it.uniba.nygaard.game.utility.Util;

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
   * Indica se il giocatore è in partita.
   * </p>
   */
  private boolean inGame;
  /**
   * <h3> difficulty </h3>
   * <p>
   * Difficoltà della partita.
   * </p>
   */
  private int difficulty;
  /**
   * <h3> difficultyNames </h3>
   * <p>
   * Nomi delle difficoltà.
   * </p>
   */
  private final String[] difficultyNames;
  /**
   * <h3> attempts </h3>
   * <p>
   * Tentativi per ogni difficoltà.
   * </p>
   */
  private final int[] attempts;
  /**
   * <h3> failedAttempts </h3>
   * <p>
   * Tentativi falliti.
   * </p>
   */
  private int failedAttempts;
  /**
   * <h3> usedAttempts </h3>
   * <p>
   * Tentativi usati.
   * </p>
   */
  private int usedAttempts;
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
   * Griglia di difesa.
   * </p>
   *
   * @see CellsGrid
   */
  private CellsGrid defenseGrid;
  /**
   * <h3> attackGrid </h3>
   * <p>
   * Griglia di attacco.
   * </p>
   *
   * @see CharactersGrid
   */
  private CharactersGrid attackGrid;
  /**
   * <h3> maxTime </h3>
   * <p>
   * Tempo massimo per la partita.
   * </p>
   */
  private int maxTime;
  /**
   * <h3> startTime </h3>
   * <p>
   * Tempo di inizio della partita espresso in millisecondi.
   * </p>
   */
  private long startTime = UTime.DEFAULT_TIME;
  /**
   * <h3> gridSize </h3>
   * <p>
   * Dimensione della griglia.
   * </p>
   */
  private int gridSize;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Metodo costruttore di Match.
   * Inizializza tutti i suoi attributi ai valori di default prefissati.
   * </p>
   */
  public Match() {
    this.inGame = false;
    this.difficulty = UDifficulty.DIFFICULTY_MEDIUM;
    this.difficultyNames = new String[]{UDifficulty.EASY_NAME, UDifficulty.MEDIUM_NAME, UDifficulty.HARD_NAME};
    this.gridSize = UGrid.STANDARD_GRID_SIZE;
    this.attempts = new int[]{UDifficulty.EASY_ATTEMPTS, UDifficulty.MEDIUM_ATTEMPTS, UDifficulty.HARD_ATTEMPTS};
    this.failedAttempts = 0;
    this.usedAttempts = 0;
    this.ships = new Ship[UShip.MAX_SHIP];

    int i = UShip.MIN_SHIP;
    for (ShipType ship : ShipType.values()) {
      for (int j = 0; j < ship.getNumShips(); j++) {
        this.ships[i - 1] = new Ship(ship.getHp());
        i++;
      }
    }

    this.defenseGrid = new CellsGrid(UGrid.STANDARD_GRID_SIZE);
    this.attackGrid = new CharactersGrid(UGrid.STANDARD_GRID_SIZE);
    maxTime = UTime.DEFAULT_TIME;
  }

  /**
   * <h3> getInGame </h3>
   * <p>
   * Restituisce lo stato della partita.
   * </p>
   *
   * @return inGame Stato della partita.
   */
  public boolean getInGame() {
    return this.inGame;
  }

  /**
   * <h3> getDifficulty </h3>
   * <p>
   * Restituisce la difficoltà della partita.
   * </p>
   *
   * @return difficulty Difficoltà della partita.
   */
  public int getDifficulty() {
    return this.difficulty;
  }

  /**
   * <h3> getGridSize </h3>
   * <p>
   * Restituisce la dimensione delle griglie.
   * </p>
   *
   * @return Dimensione delle griglie.
   */
  public int getGridSize() {
    return this.gridSize;
  }

  /**
   * <h3> setGridSize </h3>
   * <p>
   * Imposta la dimensione delle griglie.
   * </p>
   *
   * @param newGridSize Dimensione delle griglie.
   */
  public void setGridSize(final int newGridSize) {
    this.gridSize = newGridSize;
  }

  /**
   * <h3> resizeGrids </h3>
   * <p>
   * Ridimensiona le griglie di gioco.
   * </p>
   *
   * @param newSize Nuova dimensione delle griglie.
   */
  public void resizeGrids(final int newSize) {
    this.defenseGrid = new CellsGrid(newSize);
    this.attackGrid = new CharactersGrid(newSize);

    this.defenseGrid.setMaxColumn((char) (newSize + Util.INT_TO_CHAR));
    this.attackGrid.setMaxColumn((char) (newSize + Util.INT_TO_CHAR));

    this.defenseGrid.setMaxRows(newSize);
    this.attackGrid.setMaxRows(newSize);

  }

  /**
   * <h3> getDifficultyNames </h3>
   * <p>
   * Restituisce i nomi delle difficoltà.
   * </p>
   *
   * @param index Indice della difficoltà.
   * @return difficultyNames Nomi delle difficoltà.
   */
  public String getDifficultyNames(final int index) {
    return this.difficultyNames[index];
  }

  /**
   * <h3> getAttempts </h3>
   * <p>
   * Restituisce il numero di tentativi per ogni difficoltà.
   * </p>
   *
   * @param index Indice dei tentativi.
   * @return attempts Tentativi per ogni difficoltà.
   */
  public int getAttempts(final int index) {
    return this.attempts[index];
  }

  /**
   * <h3> setAttempts </h3>
   * <p>
   * Imposta il numero di tentativi per una specifica difficoltà.
   * </p>
   *
   * @param index Indice dei tentativi
   * @param value Nuovo numero di tentativi falliti per la difficoltà.
   */
  public void setAttempts(final int index, final int value) {
    this.attempts[index] = value;
  }

  /**
   * <h3> getFailedAttempts </h3>
   * <p>
   * Restituisce il numero di tentativi falliti.
   * </p>
   *
   * @return failedAttempts Tentativi falliti.
   */
  public int getFailedAttempts() {
    return this.failedAttempts;
  }

  /**
   * <h3> getUsedAttempts </h3>
   * <p>
   * Restituisce il numero di tentativi usati.
   * </p>
   *
   * @return usedAttempts Tentativi usati.
   */
  public int getUsedAttempts() {
    return this.usedAttempts;
  }

  /**
   * <h3> getDefenseGrid </h3>
   * <p>
   * Restituisce la griglia di difesa della partita.
   * </p>
   *
   * @return defenseGrid Griglia di difesa della partita.
   */
  public String getDefenseGrid() {
    return this.defenseGrid.toString();
  }

  /**
   * <h3> getAttackGrid </h3>
   * <p>
   * Restituisce la griglia di attacco della partita.
   * </p>
   *
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
   * <h3> getMaxTime </h3>
   * <p>
   * Restituisce il tempo massimo per la partita.
   * </p>
   *
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
   * Restituisce il tempo di inizio della partita.
   * </p>
   *
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
    if (i > UShip.MAX_SHIP) {
      return true;
    }
    boolean direction;
    Random rnd = new Random();
    Coordinate coord = new Coordinate();
    for (int j = UShip.MIN_GENERATIONS; j <= UShip.MAX_GENERATIONS; j++) {
      if (rnd.nextInt(2) == 1) {
        direction = UShip.VERTICAL;
      } else {
        direction = UShip.HORIZONTAL;
      }
      coord.setRow(rnd.nextInt(this.attackGrid.getMaxRows()) + 1);
      coord.setColumn((char) (rnd.nextInt(this.attackGrid.getMaxColumn() - UGrid.MIN_COLUMN + 1) + UGrid.MIN_COLUMN));
      this.ships[i - 1].setDirection(direction);
      this.ships[i - 1].setCoord(coord);
      if (this.ships[i - 1].outOfMap(this.defenseGrid)) {
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
    if (ships[i].getDirection() == UShip.VERTICAL) {
      for (int j = 0; j < ships[i].getHp(); j++) {
        defenseGrid.setCellCharacter(ships[i].getCoordRow() - 1 + j,
            ships[i].getCoordColumn() - UGrid.MIN_COLUMN, UGrid.SHIP_CHARACTER);
        defenseGrid.setCellShipIndex(ships[i].getCoordRow() - 1 + j,
            ships[i].getCoordColumn() - UGrid.MIN_COLUMN, i);
      }
    } else {
      for (int j = 0; j < ships[i].getHp(); j++) {
        defenseGrid.setCellCharacter(ships[i].getCoordRow() - 1,
            ships[i].getCoordColumn() - UGrid.MIN_COLUMN + j, UGrid.SHIP_CHARACTER);
        defenseGrid.setCellShipIndex(ships[i].getCoordRow() - 1,
            ships[i].getCoordColumn() - UGrid.MIN_COLUMN + j, i);
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
    for (int j = UGrid.MIN_ROWS; j <= this.attackGrid.getMaxRows(); j++) {
      for (int k = UGrid.MIN_ROWS; k <= this.attackGrid.getMaxRows(); k++) {
        if (defenseGrid.getCellShipIndex(j - 1, k - 1) == i) {
          defenseGrid.setCellCharacter(j - 1, k - 1, UGrid.SEA_CHARACTER);
          defenseGrid.setCellShipIndex(j - 1, k - 1, UGrid.SEA_INDEX);
        }
      }
    }
  }

  /**
   * <h3> hit </h3>
   * <p>
   * Il metodo hit colpisce la cella di coordinate (row, column) e restituisce cosa è stato colpito
   * </p>
   *
   * @param row    Riga della cella da colpire.
   * @param column Colonna della cella da colpire.
   * @return Util.WATER_CODE se la cella è vuota o è già stata colpita,
   *         Util.HITTED_CODE se la cella è stata colpita ma non affondata,
   *         Util.SANK_CODE se la cella è stata colpita e affondata.
   */
  public int hit(final int row, final int column) {
    if (defenseGrid.getCellCharacter(row, column) == UGrid.SHIP_CHARACTER
        && attackGrid.getCharacter(row, column) == UGrid.SEA_CHARACTER) {
      usedAttempts++;
      ships[defenseGrid.getCellShipIndex(row, column)].hit();
      if (ships[defenseGrid.getCellShipIndex(row, column)].getHp() == 0) {
        sunkShip(defenseGrid.getCellShipIndex(row, column));
        return UResult.SANK_CODE;
      } else {
        attackGrid.setCharacter(row, column, UGrid.HITTED_SHIP_CHARACTER);
        return UResult.HITTED_CODE;
      }
    } else {
      usedAttempts++;
      failedAttempts++;
      if (defenseGrid.getCellCharacter(row, column) == UGrid.SEA_CHARACTER) {
        attackGrid.setCharacter(row, column, UGrid.HITTED_SEA_CHARACTER);
      }
      return UResult.WATER_CODE;
    }
  }

  /**
   * <h3> sunkShip </h3>
   * <p>
   * Il metodo sunkShip cambia carattere a tutte le celle
   * della i-esima nave sulla griglia di attacco.
   * </p>
   *
   * @param index Indice della nave di cui cambiare i caratteri.
   */
  private void sunkShip(final int index) {
    for (int j = UGrid.MIN_ROWS; j <= this.attackGrid.getMaxRows(); j++) {
      for (int k = UGrid.MIN_COLUMN; k <= this.attackGrid.getMaxColumn(); k++) {
        if (defenseGrid.getCellShipIndex(j - 1, k - Util.INT_TO_CHAR - 1) == index) {
          attackGrid.setCharacter(j - 1, k - Util.INT_TO_CHAR - 1, UGrid.SUNK_SHIP_CHARACTER);
        }
      }
    }
  }

  /**
   * <h3> win </h3>
   * <p>
   * Il metodo win controlla se tutte le navi sono state affondate.
   * </p>
   *
   * @return true se tutte le navi sono state affondate, false altrimenti.
   */
  public boolean win() {
    for (int i = 0; i < UShip.MAX_SHIP; i++) {
      if (ships[i].getHp() != 0) {
        return false;
      }
    }
    return true;
  }
}
