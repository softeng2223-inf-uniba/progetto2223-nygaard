package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.LeaveMatchBoundary;

/**
 * << Control >>
 * <h2> LeaveMatchCommand </h2>
 * <p>
 * La classe LeaveMatchCommand rappresenta il comando per decidere se abbandonare la partita.
 * </p>
 *
 * @see Command
 */
public final class LeaveMatchCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di LeaveMatchCommand.
   * </p>
   */
  private static LeaveMatchCommand instance = new LeaveMatchCommand();

  /**
   * <h2> Costruttore </h2>
   * <p>
   * Costruttore  della classe LeaveMatchCommand.
   * </p>
   */
  private LeaveMatchCommand() {
    setParamNumber(1);
  }

  /**
   * <h2> getInstance </h2>
   * <p>
   * Restituisce l'istanza di LeaveMatchCommand.
   * </p>
   */
  public static LeaveMatchCommand getInstance() {
    return instance;
  }

  /**
   * <h2> executeCommand </h2>
   * <p>
   * Esegue il comando per decidere se abbandonare la partita.
   * </p>
   *
   * @param command comando da eseguire
   */

  void executeCommand(final String[] command) {
    if (!GameManager.getMatch().getInGame()) {
      LeaveMatchBoundary.notInGame();
      return;
    }
    if (invalidNumber(command)) {
      return;
    }
    String choice;
    do {
      choice = LeaveMatchBoundary.ask();
      if (GeneralControl.getShutDown() != Util.NOT_TERMINATION_CODE) {
        return;
      }
      if (choice.equals("y")) {
        GeneralControl.setShutDown(Util.LEFT_TERMINATION_CODE);
        return;
      }
      if (choice.equals("n")) {
        LeaveMatchBoundary.operationCancelled();
      } else {
        LeaveMatchBoundary.invalidChoice();
      }
    } while (!choice.equals("n"));
  }
}
