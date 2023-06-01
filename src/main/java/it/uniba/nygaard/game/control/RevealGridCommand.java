package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> RevealGridCommand </h2>
 * <p>
 * La classe RevealGridCommand rappresenta il comando per mostrare la griglia.
 * </p>
 *
 * @see Command
 */
final class RevealGridCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di RevealGridCommand.
   * </p>
   */
  private static RevealGridCommand instance = new RevealGridCommand();

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe RevealGridCommand.
   * </p>
   */
  private RevealGridCommand() {
    setParamNumber(1);
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando per mostrare la griglia di difesa.
   * </p>
   *
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (invalidNumber(command)) {
      return;
    }
    Match p = GameManager.getMatch();
    if (!p.getInGame()) {
      ShowGridBoundary.notInGame();
      return;
    }
    ShowGridBoundary.printGrid(p.getDefenseGrid());
  }

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di RevealGridCommand.
   * </p>
   */
  static RevealGridCommand getInstance() {
    return instance;
  }
}
