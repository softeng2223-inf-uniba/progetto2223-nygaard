package it.uniba.nygaard.game.entity;
import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.entity.ships.Ship;
import it.uniba.nygaard.game.entity.ships.AircraftCarrier;
import it.uniba.nygaard.game.entity.ships.Battleship;
import it.uniba.nygaard.game.entity.ships.Cruiser;
import it.uniba.nygaard.game.entity.ships.Destroyer;
import it.uniba.nygaard.game.entity.grids.CellsGrid;
import it.uniba.nygaard.game.entity.grids.CharactersGrid;


/**
 * <<Entity>>
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
    /**
     * <h3> ships </h3>
     * <p>
     *     Navi della partita.
     * </p>
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
     * <h3> instance </h3>
     * <p>
     *     Istanza di Match.
     * </p>
     */
  private static Match instance = new Match();

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Metodo costruttore di Match.
   * Inizializza tutti i suoi attributi ai valori di default prefissati.
   * </p>
   */
  private Match() {
    this.inGame = false;
    this.difficulty = Util.DIFFICULTY_NOT_SETTED;
    this.difficultyNames = new String[]{Util.EASY_NAME, Util.MEDIUM_NAME, Util.HARD_NAME};
    this.attempts = new int[]{Util.EASY_ATTEMPTS, Util.MEDIUM_ATTEMPTS, Util.HARD_ATTEMPTS};
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
  }

  /**
   * <h3>getInstance</h3>
   * <p>
   * Metodo che restituisce l'istanza di Match.
   * </p>
   * @return instance Istanza di Match.
   */
  public static Match getInstance() {
    return instance;
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
   * @return difficultyNames Nomi delle difficoltà.
   */
  public String[] getDifficultyNames() {
    return this.difficultyNames;
  }
    /**
     * <h3> getAttempts </h3>
     * <p>
     *     Restituisce il numero di tentativi per ogni difficoltà.
     * </p>
     * @return attempts Tentativi per ogni difficoltà.
     */
  public int[] getAttempts() {
    return this.attempts;
  }
    /**
     * <h3> getDefenseGrid </h3>
     * <p>
     *     Restituisce la griglia di difesa della partita.
     * </p>
     * @return defenseGrid Griglia di difesa della partita.
     */
  public CellsGrid getDefenseGrid() {
    return this.defenseGrid;
  }
    /**
     * <h3> getAttackGrid </h3>
     * <p>
     *     Restituisce la griglia di attacco della partita.
     * </p>
     * @return attackGrid Griglia di attacco della partita.
     */
  public CharactersGrid getAttackGrid() {
    return this.attackGrid;
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

}
