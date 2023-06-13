package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.MatchBoundary;
import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;
import it.uniba.nygaard.game.utility.UShip;
import it.uniba.nygaard.game.utility.UTime;


/**
 * << Control >>
 * <h2> StartMatchCommand </h2>
 * <p>
 * La classe StartMatchCommand rappresenta il comando per iniziare la partita.
 * </p>
 *
 * @see Command
 */
final class StartMatchCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di StartMatchCommand.
   * </p>
   */
  private static StartMatchCommand instance = new StartMatchCommand();

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe StartMatchCommand.
   * </p>
   */
  private StartMatchCommand() {
    setMinParamNumber(1);
    setMaxParamNumber(1);
  }

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di StartMatchCommand.
   * </p>
   */
  static StartMatchCommand getInstance() {
    return instance;
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando per iniziare la partita.
   * </p>
   *
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse(command[0]);
      return;
    }
    Match p = GameManager.getMatch();
    if (p.getInGame()) {
      MatchBoundary.alreadyInGame();
      return;
    }
    if (p.getMaxTime() != UTime.DEFAULT_TIME) {
      p.setStartTime(System.currentTimeMillis());
      new TimeCounter().start();
    }
    p.setInGame(true);
    while (true) {
      if (p.initializeShips(UShip.MIN_SHIP)) {
        break;
      }
    }
    ShowGridBoundary.printGrid(p.getAttackGrid());
  }
}
