package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.DescriptionBoundary;
import it.uniba.nygaard.game.boundary.HelpBoundary;
import it.uniba.nygaard.game.boundary.LogoBoundary;
import it.uniba.nygaard.game.boundary.ParamsBoundary;

/**
 * << Control >>
 * <h2> ParamControl </h2>
 * <p>
 *     La classe ParamControl rappresenta il controllo dei parametri.
 * </p>
 * @see CommandInterface
 */
final class ParamControl implements CommandInterface {
  /**
   * <h3> instance </h3>
   * <p>
   *     Istanza di ParamControl.
   * </p>
   */
  private static ParamControl instance = new ParamControl();
  /**
   * <h3> Costruttore </h3>
   * <p>
   *     Costruttore della classe ParamControl.
   * </p>
   */
  private ParamControl() {
  }
  /**
   * <h3> getInstance </h3>
   * <p>
   *     Restituisce l'istanza di ParamControl.
   * </p>
   * @return Istanza di ParamControl.
   */
  static ParamControl getInstance() {
    return instance;
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *     Esegue il comando.
   * </p>
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    String[] args = GameManager.getArgs();
    if (args.length > 0) {
      if (args.length > 1) {
        ParamsBoundary.tooManyArgs();
        System.exit(0);
      }
      String argument = args[0].toLowerCase();
      if (argument.equals("--help") || argument.equals("-h")) {
        HelpBoundary.getHelp();
      } else {
        ParamsBoundary.notRecogniseArg(argument);
        System.exit(0);
      }
    } else {
      LogoBoundary.printLogo();
      DescriptionBoundary.getDescription();
    }
  }
}

