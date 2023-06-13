package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UTime;
import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.TimeBoundary;

/**
 * <<Control>>
 * <h2>ShowTimeCommand</h2>
 * <p>
 * La classe ShowTimeCommand rappresenta il comando di visualizzazione del tempo.
 * </p>
 *
 * @see Command
 */
final class ShowTimeCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di ShowShipCommand.
   * </p>
   */
  private static ShowTimeCommand instance = new ShowTimeCommand();

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe ShowTimeCommand.
   * </p>
   */
  private ShowTimeCommand() {
    setMinParamNumber(1);
    setMaxParamNumber(1);
  }

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di ShowTimeCommand.
   * </p>
   */
  static ShowTimeCommand getInstance() {
    return instance;
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Il comando è disponibile solo se non si è in partita.
   * Se viene passato un numero sbagliato di parametri, viene stampato il come usare il comando.
   * Se si è in partita, viene stampato il tempo trascorso dall'inizio della partita.
   * * </p>
   *
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse(command[0]);
      return;
    }
    if (!GameManager.getMatch().getInGame()) {
      TimeBoundary.notInGame();
      return;
    }
    if (GameManager.getMatch().getMaxTime() == UTime.DEFAULT_TIME) {
      TimeBoundary.infiniteTime();
    } else {
      TimeBoundary.showTime(GameManager.getMatch().getStartTime());
    }
  }
}
