package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.TimeBoundary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <<Control>>
 * <h2>SetTimeCommand</h2>
 * <p>
 * La classe SetTimeCommand rappresenta il comando di impostazione del tempo.
 * </p>
 *
 * @see Command
 */
final class SetTimeCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di SetTimeCommand.
   * </p>
   */
  private static SetTimeCommand instance = new SetTimeCommand();

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe SetTimeCommand.
   * </p>
   */
  private SetTimeCommand() {
    setMinParamNumber(2);
    setMaxParamNumber(2);
  }

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di SetTimeCommand.
   * </p>
   */
  public static SetTimeCommand getInstance() {
    return instance;
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando di impostazione del tempo se non si è in partita.
   * Se il tempo non è valido verrà mostrato un messaggio di errore.
   * </p>
   *
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse("/tempo", " <tempo in minuti>");
      return;
    }
    if (GameManager.getMatch().getInGame()) {
      TimeBoundary.alreadyInGame();
      return;
    }
    int maxTime;
    String regex = "^[1-9][0-9]*$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(command[1]);
    if (matcher.matches()) {
      try {
        maxTime = Integer.parseInt(command[1]);
      } catch (NumberFormatException e) {
        TimeBoundary.errorTime();
        return;
      }
    } else {
      TimeBoundary.errorTime();
      return;
    }
    GameManager.getMatch().setMaxTime(maxTime);
    TimeBoundary.operationDone();
  }
}
