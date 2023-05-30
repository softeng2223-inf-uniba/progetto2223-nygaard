package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> UnveilGridCommand </h2>
 * <p>
 *     La classe UnveilGridCommand rappresenta il comando per mostrare la griglia.
 * </p>
 * @see CommandInterface
 */
final class UnveilGridCommand implements CommandInterface {
  /**
   * <h3> instance </h3>
   * <p>
   *     Istanza di UnveilGridCommand.
   * </p>
   */
  private static UnveilGridCommand instance = new UnveilGridCommand();
  /**
   * <h3> Costruttore </h3>
   * <p>
   *     Costruttore della classe UnveilGridCommand.
   * </p>
   */
  private UnveilGridCommand() {
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *     Esegue il comando.
   * </p>
   */
  public void executeCommand(final String[] command) {
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
   *    Restituisce l'istanza di UnveilGridCommand.
   * </p>
   */
  static UnveilGridCommand getInstance() {
    return instance;
  }
}
