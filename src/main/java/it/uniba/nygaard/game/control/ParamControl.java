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
 * @see Command
 */
final class ParamControl {
  /**
   * <h3> ParamaControl </h3>
   * <p>
   *     Cosruttore della classe ParamControl.
   * </p>
   */
  private ParamControl() {
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *     Esegue il comando.
   * </p>
   */
  public static void executeCommand() {
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

