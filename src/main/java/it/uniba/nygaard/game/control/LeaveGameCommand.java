package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.LeaveGameBoundary;

public class LeaveGameCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di LeaveGameCommand.
   * </p>
   */
  private static LeaveGameCommand instance = new LeaveGameCommand();

  /**
   * <h2> Costruttore </h2>
   * <p>
   * Costruttore  della classe LeaveGameCommand.
   * </p>
   */
  private LeaveGameCommand() {
    setParamNumber(1);
  }

  /**
   * <h2> getInstance </h2>
   * <p>
   * Restituisce l'istanza di LeaveGameCommand.
   * </p>
   */
  public static LeaveGameCommand getInstance() {
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
      LeaveGameBoundary.notInGame();
      return;
    }
    if (invalidNumber(command)) {
      return;
    }
    String choice;
    do {
      choice = LeaveGameBoundary.ask();
      if (GeneralControl.getShutDown() != Util.NOT_TERMINATION_CODE) {
        return;
      }
      if (choice.equals("y")) {
        GeneralControl.setShutDown(Util.LEFT_TERMINATION_CODE);
        return;
      }
      if (choice.equals("n")) {
        LeaveGameBoundary.operationCancelled();
      } else {
        LeaveGameBoundary.invalidChoice();
      }
    } while (!choice.equals("n"));
  }
}
