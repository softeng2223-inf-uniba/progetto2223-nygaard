package it.uniba.nygaard.game;

import it.uniba.nygaard.game.grids.*;
import it.uniba.nygaard.game.ships.*;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * <p>
 * La classe Match si occupa della partita.
 * Contiene tutte le informazioni relative alla partita
 * e tutti i metodi per settarli e modificarli.
 * </p>
 */
public final class Match {
  private boolean inGame;
  private int difficulty;
  private String[] difficultyNames;
  private final int[] attempts;
  private final Ship[] ships;
  private final CellsGrid defenseGrid;
  private final CharactersGrid attackGrid;

  /**
   * Metodo costruttore di Match.
   * Inizializza tutti i suoi attributi ai valori di default prefissati.
   */
  public Match() {
    this.inGame = false;
    this.difficulty = Util.DIFFICULTY_NOT_SETTED;
    this.difficultyNames = new String[]
        {Util.EASY_NAME, Util.MEDIUM_NAME, Util.HARD_NAME};
    this.attempts = new int[]
        {Util.EASY_ATTEMPTS, Util.MEDIUM_ATTEMPTS, Util.HARD_ATTEMPTS};
    this.ships = new Ship[Util.MAX_SHIP];
    for (int i = Util.MIN_SHIP; i <= Util.MAX_SHIP; i++) {
      switch (i) {
        case 1 -> this.ships[i - 1] = new AircraftCarrier();
        case 2, 3 -> this.ships[i - 1] = new Battleship();
        case 4, 5, 6 -> this.ships[i - 1] = new Cruiser();
        case 7, 8, 9, 10 -> this.ships[i - 1] = new Destroyer();
        default -> this.ships[i - 1].setHp(0);
      }
    }
    this.defenseGrid = new CellsGrid(Util.MAX_ROWS);
    this.attackGrid = new CharactersGrid(Util.MAX_ROWS);
  }

  /**
   * Settaggio difficoltà della partita.
   *
   * @param newDifficulty Parametro di ingresso per impostare
   *                      la difficoltà della partita
   */
  public void setDifficulty(final int newDifficulty) {
    if (this.inGame) {
      System.out.println("Non puoi cambiare difficoltà "
          + "durante una partita");
      return;
    }
    if (this.difficulty == newDifficulty) {
      System.out.println("Hai già impostato questa difficoltà");
      return;
    }
    if (this.difficulty != Util.DIFFICULTY_NOT_SETTED) {
      String choice;
      Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
      do {
        System.out.print("Il livello attuale è "
            + difficultyNames[this.difficulty]
            + ". Confermare cambio in "
            + difficultyNames[newDifficulty]
            + "? (y/n) ");
        choice = in.nextLine().toLowerCase();
        if (!choice.equals("y") && !choice.equals("n")) {
          System.out.println("Scelta non valida");
        }
      } while (!choice.equals("y") && !choice.equals("n"));
      if (choice.equals("n")) {
        System.out.println("Operazione annullata");
        return;
      }
    }
    this.difficulty = newDifficulty;
    System.out.println("OK");
  }

  /**
   * Il metodo showLevel mostra il livello di gioco impostato
   * e il numero massimo di tentativi che possono essere falliti.
   */
  public void showLevel() {
    if (this.difficulty != Util.DIFFICULTY_NOT_SETTED) {
      System.out.println(
          "Livello di difficoltà scelto: "
              + this.difficultyNames[this.difficulty]
              + "\n"
              + "Numero massimo di tentativi falliti: "
              + this.attempts[this.difficulty]);
    } else {
      System.out.println(
          "Difficoltà non ancora scelta"
              + "\n"
              + "Per scegliere la difficoltà utilizzare "
              + "il comando /facile, /medio o /difficile");
    }
  }

  /**
   * Il metodo showShips mostra, per ogni tipo di nave presente nel gioco,
   * la dimensione in quadrati e il numero di esemplari da affondare.
   */
  public void showShips() {
    System.out.println("\tCacciatorpediniere \t■■ \tEsemplari: " + Util.DESTROYER_NO);
    System.out.println("\tIncrociatore \t\t■■■ \tEsemplari: " + Util.CRUISER_NO);
    System.out.println("\tCorazzata \t\t■■■■ \tEsemplari: " + Util.BATTLESHIP_NO);
    System.out.println("\tPortaerei \t\t■■■■■ \tEsemplari: " + Util.AIRCRAFT_NO);
  }

  void play() {
    if (this.difficulty == Util.DIFFICULTY_NOT_SETTED) {
      System.out.println("Non hai ancora impostato il livello");
      return;
    } else {
      if (this.inGame) {
        System.out.println("Sei gia in partita");
        return;
      }
    }
    this.inGame = true;
    initializeShips(Util.MIN_SHIP);
    System.out.println(attackGrid);
  }

  private boolean initializeShips(int i) {
    if (i > Util.MAX_SHIP) {
      return true;
    }
    boolean direction;
    Coordinate coord = new Coordinate();
    for (int j = Util.MIN_GENERATIONS; j <= Util.MAX_GENERATIONS; j++) {
      direction = ((int) (Math.random() * 2)) == 1;
      coord.setRow((int) (Math.random() * 10 + 1));
      coord.setColumn((char) ((int) (Math.random() * 10 + 'A')));
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

  void placeShip(int i) {
    if (ships[i].getDirection()) {
      for (int j = 0; j < ships[i].getHp(); j++) {
        defenseGrid.setCellCharacter(ships[i].getCoord().getRow() - 1 + j,
            ships[i].getCoord().getColumn() - Util.MIN_COLUMN, Util.SHIP_CHARACTER);
        defenseGrid.setCellShipIndex(ships[i].getCoord().getRow() - 1 + j,
            ships[i].getCoord().getColumn() - Util.MIN_COLUMN, i);
      }
    } else {
      for (int j = 0; j < ships[i].getHp(); j++) {
        defenseGrid.setCellCharacter(ships[i].getCoord().getRow() - 1,
            ships[i].getCoord().getColumn() - Util.MIN_COLUMN + j, Util.SHIP_CHARACTER);
        defenseGrid.setCellShipIndex(ships[i].getCoord().getRow() - 1,
            ships[i].getCoord().getColumn() - Util.MIN_COLUMN + j, i);
      }
    }
  }

}
