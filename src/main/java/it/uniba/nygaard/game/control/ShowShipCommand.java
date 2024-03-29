package it.uniba.nygaard.game.control;


import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.ShowShipsBoundary;

/**
 * << Control >>
 * <h2> ShowShipCommand </h2>
 * <p>
 * La classe ShowShipCommand rappresenta il comando di visualizzazione delle navi.
 * </p>
 *
 * @see Command
 */
final class ShowShipCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di ShowShipCommand.
   * </p>
   */
  private static ShowShipCommand instance = new ShowShipCommand();

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe ShowShipCommand.
   * Setta il numero minimo e massimo di parametri che rendono valido il comando.
   * </p>
   */
  private ShowShipCommand() {
    setMinParamNumber(1);
    setMaxParamNumber(1);
  }

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di ShowShipCommand.
   * </p>
   */
  static ShowShipCommand getInstance() {
    return instance;
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando di visualizzazione delle navi.
   * Se viene passato un numero sbagliato di parametri, viene stampato il come usare il comando.
   * </p>
   *
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse(command[0]);
      return;
    }
    ShowShipsBoundary.showShips();
  }
}
