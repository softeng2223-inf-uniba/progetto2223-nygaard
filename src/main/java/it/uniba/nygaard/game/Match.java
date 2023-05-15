package it.uniba.nygaard.game;

import it.uniba.nygaard.game.ships.Coordinate;
import it.uniba.nygaard.game.ships.Ship;
import it.uniba.nygaard.game.ships.AircraftCarrier;
import it.uniba.nygaard.game.ships.Battleship;
import it.uniba.nygaard.game.ships.Cruiser;
import it.uniba.nygaard.game.ships.Destroyer;
import it.uniba.nygaard.game.grids.CellsGrid;
import it.uniba.nygaard.game.grids.CharactersGrid;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

/**
 * <h2> Match </h2>
 * <p>
 * La classe Match si occupa della partita.
 * Contiene tutte le informazioni relative alla partita
 * e tutti i metodi per settarli e modificarli.
 * </p>
 */
public final class Match {
  private boolean inGame;
  private int difficulty;
  private final String[] difficultyNames;
  private final int[] attempts;
  private final Ship[] ships;
  private final CellsGrid defenseGrid;
  private final CharactersGrid attackGrid;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Metodo costruttore di Match.
   * Inizializza tutti i suoi attributi ai valori di default prefissati.
   * </p>
   */
  public Match() {
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
   * <h3> setDifficulty </h3>
   * <p>
   * Imposta la difficoltà della partita.
   * </p>
   *
   * @param newDifficulty Difficoltà della partita.
   */
  public void setDifficulty(final int newDifficulty) {
    if (this.inGame) {
      System.out.println(Util.RED + "Non puoi cambiare difficoltà durante una partita" + Util.RESET);
      return;
    }
    if (this.difficulty == newDifficulty) {
      System.out.println(Util.RED + "Hai già impostato questa difficoltà" + Util.RESET);
      return;
    }
    if (this.difficulty != Util.DIFFICULTY_NOT_SETTED) {
      String choice;
      Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
      do {
        System.out.print("Il livello attuale è " + Util.BOLD
                + difficultyNames[this.difficulty] + Util.RESET + ". Confermare cambio in "
                + Util.BOLD + difficultyNames[newDifficulty] + Util.RESET
                + "? (" + Util.GREEN + "y" + Util.RESET
                + "/" + Util.RED + "n" + Util.RESET + ") ");
        choice = in.nextLine().toLowerCase();
        if (!choice.equals("y") && !choice.equals("n")) {
          System.out.println(Util.RED + "Scelta non valida" + Util.RESET);
        }
      } while (!choice.equals("y") && !choice.equals("n"));
      if (choice.equals("n")) {
        System.out.println(Util.RED + "Operazione annullata" + Util.RESET);
        return;
      }
    }
    this.difficulty = newDifficulty;
    System.out.println(Util.GREEN + "OK" + Util.RESET);
  }

  /**
   * <h3> showLevel </h3>
   * <p>
   * Il metodo showLevel mostra il livello di gioco impostato
   * e il numero massimo di tentativi che possono essere falliti.
   * </p>
   */
  public void showLevel() {
    if (this.difficulty != Util.DIFFICULTY_NOT_SETTED) {
      System.out.print("Livello di difficoltà scelto: ");
      switch (this.difficultyNames[this.difficulty]) {
        case Util.EASY_NAME -> System.out.print(Util.GREEN);
        case Util.MEDIUM_NAME -> System.out.print(Util.YELLOW);
        case Util.HARD_NAME -> System.out.print(Util.RED);
        default -> System.out.print(Util.RESET);
      }
      System.out.print(this.difficultyNames[this.difficulty] + Util.RESET + "\n"
              + "Numero massimo di tentativi falliti: ");
      switch (this.difficultyNames[this.difficulty]) {
        case Util.EASY_NAME -> System.out.print(Util.GREEN);
        case Util.MEDIUM_NAME -> System.out.print(Util.YELLOW);
        case Util.HARD_NAME -> System.out.print(Util.RED);
        default -> System.out.print(Util.RESET);
      }
      System.out.println(this.attempts[this.difficulty] + Util.RESET);
    } else {
      System.out.println(Util.RED + "Difficoltà non ancora scelta\nPer scegliere la difficoltà utilizzare "
              + "il comando /facile, /medio o /difficile" + Util.RESET);
    }
  }

  /**
   * <h3> showShips </h3>
   * <p>
   * Il metodo showShips mostra, per ogni tipo di nave presente nel gioco,
   * la dimensione in quadrati e il numero di esemplari da affondare.
   * </p>
   */
  public void showShips() {
    System.out.println("\tCacciatorpediniere \t■■ \t" + Util.RED + "Esemplari: " + Util.DESTROYER_NO + Util.RESET);
    System.out.println("\tIncrociatore \t\t■■■ \t" + Util.YELLOW + "Esemplari: " + Util.CRUISER_NO + Util.RESET);
    System.out.println("\tCorazzata \t\t■■■■ \t" + Util.GREEN + "Esemplari: " + Util.BATTLESHIP_NO + Util.RESET);
    System.out.println("\tPortaerei \t\t■■■■■ \t" + Util.CYAN + "Esemplari: " + Util.AIRCRAFT_NO + Util.RESET);
  }

  /**
   * <h3> play </h3>
   * <p>
   * Il metodo play inizia una nuova partita.
   * </p>
   */
  public void play() {
    if (this.difficulty == Util.DIFFICULTY_NOT_SETTED) {
      System.out.println(Util.RED + "Non hai ancora impostato il livello" + Util.RESET);
      return;
    }
    if (this.inGame) {
      System.out.println(Util.RED + "Sei gia in partita" + Util.RESET);
      return;
    }
    this.inGame = true;
    initializeShips(Util.MIN_SHIP);
    System.out.println(attackGrid);
  }

  /**
   * <h3> showDefenseGrid </h3>
   * <p>
   * Il metodo effettua la stampa della griglia delle navi posizionate.
   * </p>
   */
  public void showDefenseGrid() {
    if (!this.inGame) {
      System.out.println(Util.RED + "Non sei in partita" + Util.RESET);
      return;
    }
    System.out.println(defenseGrid);
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
  private boolean initializeShips(final int i) {
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
