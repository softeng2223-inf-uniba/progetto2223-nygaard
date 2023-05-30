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
   * <h3> ParamControl </h3>
   * <p>
   *     Costruttore della classe ParamControl.
   * </p>
   */
  private ParamControl() {
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *     Controlla se l'applicazione è stava avviata con dei parametri.
   *     In caso positivo controlla se i parametri sono validi e, se lo sono,
   *     esegue i comandi corrispondenti.
   * </p>
   */
  public static void initUI() {
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
        ParamsBoundary.notRecognisedArg(argument);
        System.exit(0);
      }
    } else {
      LogoBoundary.printLogo();
      DescriptionBoundary.getDescription();
    }
  }
}

