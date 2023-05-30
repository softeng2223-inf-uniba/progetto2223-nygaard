package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.ShowShipsBoundary;

/**
 * << Control >>
 * <h2> ShowShipCommand </h2>
 * <p>
 *     La classe ShowShipCommand rappresenta il comando di visualizzazione delle navi.
 * </p>
 * @see CommandInterface
 */
final class ShowShipCommand implements CommandInterface {
  /**
   * <h3> instance </h3>
   * <p>
   *     Istanza di ShowShipCommand.
   * </p>
   */
  private static ShowShipCommand instance = new ShowShipCommand();
  /**
   * <h3> Costruttore </h3>
   * <p>
   *     Costruttore della classe ShowShipCommand.
   * </p>
   */
  private ShowShipCommand() {
  }
  /**
   * <h3> getInstance </h3>
   * <p>
   *    Restituisce l'istanza di ShowShipCommand.
   * </p>
   */
  static ShowShipCommand getInstance() {
    return instance;
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *     Esegue il comando.
   * </p>
   */
  public  void executeCommand(final String[] command) {
    ShowShipsBoundary.showShips();
  }
}
