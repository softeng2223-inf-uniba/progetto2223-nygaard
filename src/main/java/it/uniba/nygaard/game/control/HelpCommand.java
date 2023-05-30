package it.uniba.nygaard.game.control;
import it.uniba.nygaard.game.boundary.HelpBoundary;
import it.uniba.nygaard.game.boundary.InputBoundary;

/**
 * << Control >>
 * <h2> HelpCommand </h2>
 * <p>
 *     La classe HelpCommand rappresenta il comando di aiuto.
 * </p>
 * @see Command
 */
public final class HelpCommand extends Command {
  /**
   * <h3> instance </h3>
   * <p>
   *     Istanza di HelpCommand.
   * </p>
   */
  private static HelpCommand instance = new HelpCommand();
  /**
   * <h3> Costruttore </h3>
   * <p>
   *     Costruttore della classe HelpCommand.
   * </p>
   */
  private HelpCommand() {
    setParamNumber(1);
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *     Esegue il comando di aiuto.
   * </p>
   */
  public void executeCommand(final String[] command) {
    if (command.length > getParamNumber()) {
      InputBoundary.howToUse(command[0]);
      return;
    }
    HelpBoundary.getHelp();
  }
  /**
   * <h3> getInstance </h3>
   * <p>
   *     Restituisce l'istanza di HelpCommand.
   * </p>
   * @return Istanza di HelpCommand.
   */
  static HelpCommand getInstance() {
    return instance;
  }
}
