package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.DescriptionBoundary;
import it.uniba.nygaard.game.boundary.HelpBoundary;
import it.uniba.nygaard.game.boundary.LogoBoundary;
import it.uniba.nygaard.game.boundary.ParamsBoundary;
import it.uniba.nygaard.game.utility.UShutdown;
import it.uniba.nygaard.game.utility.Util;

/**
 * << Control >>
 * <h2> ParamControl </h2>
 * <p>
 * La classe ParamControl rappresenta il controllo dei parametri.
 * </p>
 *
 * @see Command
 */
final class ParamControl {

  /**
   * <h3> ParamControl </h3>
   * <p>
   * Costruttore della classe ParamControl.
   * </p>
   */
  private ParamControl() {
  }

  /**
   * <h3> initUI </h3>
   * <p>
   * Inizializza l'interfaccia utente.
   * Se il parametro è --help o -h stampa l'help,
   * altrimenti se il parametro è diverso da --help o -h stampa
   * un messaggio di errore e poi termina il programma.
   * Se non ci sono parametri stampa il logo e la descrizione.
   * </p>
   */
  public static void initUI() {
    String[] args = GameManager.getArgs();
    if (args.length > Util.MIN_ARGS) {
      if (args.length > Util.MAX_ARGS) {
        GeneralControl.setShutDown(UShutdown.QUIT_TERMINATION_CODE);
        ParamsBoundary.tooManyArgs();
      }
      String argument = args[0].toLowerCase();
      if (argument.equals("--help") || argument.equals("-h")) {
        HelpBoundary.getHelp();
      } else {
        GeneralControl.setShutDown(UShutdown.QUIT_TERMINATION_CODE);
        ParamsBoundary.notRecognisedArg(argument);
      }
    } else {
      LogoBoundary.printLogo();
      DescriptionBoundary.getDescription();
    }
  }
}

