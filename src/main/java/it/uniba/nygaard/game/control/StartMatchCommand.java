package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.MatchBoundary;
import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;


/**
 * << Control >>
 * <h2> StartMatchCommand </h2>
 * <p>
 *     La classe StartMatchCommand rappresenta il comando per iniziare la partita.
 * </p>
 * @see Command
 */
final class StartMatchCommand extends Command {
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
    setParamNumber(1);
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
   *     Esegue il comando per iniziare la partita.
   * </p>
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (invalidNumber(command)) {
      return;
    }
    Match p = GameManager.getMatch();
    if (p.getInGame()) {
      MatchBoundary.alreadyInGame();
      return;
    }
    p.setStartTime(System.currentTimeMillis());
    p.setInGame(true);
    p.initializeShips(Util.MIN_SHIP);
    ShowGridBoundary.printGrid(p.getAttackGrid());
  }
}
