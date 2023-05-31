package it.uniba.nygaard.game;

/**
 * <h2> Util </h2>
 * <p>
 * La classe Util contiene tutte le costanti globali
 * e funzioni di servizio.
 * </p>
 */
public final class Util {
  public static final int COLUMNS_EDGE_WIDTH = 13;
  public static final int ROWS_EDGE_WIDTH = 8;
  public static final int MIN_SHIP = 1;
  public static final int MAX_SHIP = 10;
  public static final int AIRCRAFT_CARRIER_HP = 5;
  public static final int BATTLESHIP_HP = 4;
  public static final int CRUISER_HP = 3;
  public static final int DESTROYER_HP = 2;
  public static final int DIFFICULTY_EASY = 0;
  public static final int DIFFICULTY_MEDIUM = 1;
  public static final int DIFFICULTY_HARD = 2;
  public static final int EASY_ATTEMPTS = 50;
  public static final int MEDIUM_ATTEMPTS = 30;
  public static final int HARD_ATTEMPTS = 10;
  public static final String EASY_NAME = "Facile";
  public static final String MEDIUM_NAME = "Medio";
  public static final String HARD_NAME = "Difficile";
  public static final int AIRCRAFT_NO = 1;
  public static final int BATTLESHIP_NO = 2;
  public static final int CRUISER_NO = 3;
  public static final int DESTROYER_NO = 4;
  public static final int MIN_GENERATIONS = 1;
  public static final int MAX_GENERATIONS = 50;
  public static final int SEA_INDEX = -1;
  public static final char SEA_CHARACTER = '~';
  public static final char SHIP_CHARACTER = '*';
  public static final char HITTED_SEA_CHARACTER = 'O';
  public static final char HITTED_SHIP_CHARACTER = 'X';
  public static final char SUNK_SHIP_CHARACTER = '#';
  public static final int FIRST_TWO_DIGITS = 10;
  public static final boolean VERTICAL = true;
  public static final boolean HORIZONTAL = false;
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String RESET = "\u001B[0m";
  public static final String BOLD = "\u001B[1m";
  public static final String ITALIC = "\u001B[3m";
  public static final int  DEFAULT_TIME = -1;
  public static final long ONE_MINUTE = 60000;

  public static final int STANDARD_GRID_SIZE = 10;
  public static final int LARGE_GRID_SIZE = 18;
  public static final int EXTRA_LARGE_GRID_SIZE = 26;


  public static final int MIN_ROWS = 1;
  public static final char MIN_COLUMN = 'A';

  public static final int INT_TO_CHAR = 64;
  public static final int BORDER_ADDER = 9;


  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe Util.
   * </p>
   */
  private Util() {
  }
}

