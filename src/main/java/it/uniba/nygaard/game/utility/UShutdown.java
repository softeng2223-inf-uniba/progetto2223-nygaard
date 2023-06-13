package it.uniba.nygaard.game.utility;

/**
 * <h2> UShutdown </h2>
 * <p>
 *   La classe UShutdown contiene delle costanti utili
 *   per la gestione della terminazione del gioco.
 * </p>
 *
 */
public final class UShutdown {
  /**
   * <h3> Costanti </h3>
   * <p>
   *   Costanti per la gestione della terminazione del gioco.
   * </p>
   */
  public static final int NOT_TERMINATION_CODE = 0;
  public static final int WIN_TERMINATION_CODE = 1;
  public static final int OUT_OF_ATTEMPTS_TERMINATION_CODE = 2;
  public static final int LEFT_TERMINATION_CODE = 3;
  public static final int OUT_OF_TIME_TERMINATION_CODE = 4;
  public static final int QUIT_TERMINATION_CODE = -1;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe UShutdown.
   * </p>
   */
  private UShutdown() {
  }
}
