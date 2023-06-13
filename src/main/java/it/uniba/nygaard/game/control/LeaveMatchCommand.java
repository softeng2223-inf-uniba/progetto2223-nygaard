package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UShutdown;
import it.uniba.nygaard.game.boundary.InputBoundary;
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
final class LeaveMatchCommand extends Command {

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
    setMinParamNumber(1);
    setMaxParamNumber(1);
  }

  /**
   * <h2> getInstance </h2>
   * <p>
   * Restituisce l'istanza di LeaveMatchCommand.
   * </p>
   */
  static LeaveMatchCommand getInstance() {
    return instance;
  }

  /**
   * <h2> executeCommand </h2>
   * <p>
   * Esegue il comando per decidere se abbandonare la partita.
   * Il comando è disponibile solo se non si è in partita.
   * Se viene passato un numero sbagliato di parametri, viene stampato il come usare il comando.
   * </p>
   *
   * @param command comando da eseguire
   */

  void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse(command[0]);
      return;
    }
    if (!GameManager.getMatch().getInGame()) {
      LeaveMatchBoundary.notInGame();
      return;
    }
    String choice;
    do {
      choice = LeaveMatchBoundary.ask();
      if (GeneralControl.getShutDown() != UShutdown.NOT_TERMINATION_CODE) {
        return;
      }
      if (choice.equals("y")) {
        GeneralControl.setShutDown(UShutdown.LEFT_TERMINATION_CODE);
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
