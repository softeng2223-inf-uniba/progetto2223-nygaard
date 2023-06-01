package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.AttemptsBoundary;
import it.uniba.nygaard.game.boundary.InputBoundary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * << Control >>
 * <h2> AttemptsCommand </h2>
 * <p>
 * La classe AttemptsCommand rappresenta il controllo per impostare
 * il numero di tentativi indipendentemente dalla difficoltà.
 * </p>
 */
final class AttemptsCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di AttemptsCommand.
   * </p>
   */
  private static AttemptsCommand instance = new AttemptsCommand();

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe AttemptsCommand.
   * </p>
   */
  private AttemptsCommand() {
    setParamNumber(2);
  }

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di AttemptsCommand.
   * </p>
   */
  static AttemptsCommand getInstance() {
    return instance;
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando per impostare un numero di tentativi
   * indipendentemente dalla difficoltà.
   * </p>
   *
   * @param command Comando da eseguire.
   */
  void executeCommand(final String[] command) {
    if (invalidNumber(command, " <numero intero positivo>")) {
      return;
    }
    if (command.length < 2) {
      InputBoundary.howToUse(command[0], " <numero intero positivo>");
      return;
    }
    if (GameManager.getMatch().getInGame()) {
      AttemptsBoundary.alreadyInGame();
      return;
    }
    String regex = "^[1-9][0-9]*$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(command[1]);
    int newAttempts = 0;
    if (matcher.matches()) {
      try {
        newAttempts = Integer.parseInt(command[1]);
      } catch (NumberFormatException e) {
        AttemptsBoundary.notValidChoice();
        return;
      }
      for (int i = Util.DIFFICULTY_EASY; i <= Util.DIFFICULTY_HARD; i++) {
        GameManager.getMatch().setAttempts(i, newAttempts);
      }
      AttemptsBoundary.operationDone();
    } else {
      AttemptsBoundary.notValidChoice();
    }
  }
}
