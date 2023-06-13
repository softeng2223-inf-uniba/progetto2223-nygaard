package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UDifficulty;
import it.uniba.nygaard.game.boundary.AttemptsBoundary;
import it.uniba.nygaard.game.boundary.InputBoundary;

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
   * Setta il numero minimo e massimo di parametri che rendono valido il comando.
   * </p>
   */
  private AttemptsCommand() {
    setMinParamNumber(2);
    setMaxParamNumber(2);
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
   * Il comando è disponibile solo se non si è in partita.
   * Se viene passato un numero sbagliato di parametri, viene stampato il come usare il comando.
   * </p>
   *
   * @param command Comando da eseguire.
   */
  void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse(command[0], " <numero tentativi>");
      return;
    }
    if (GameManager.getMatch().getInGame()) {
      AttemptsBoundary.alreadyInGame();
      return;
    }
    int newAttempts;
    if (command[1].matches("^[1-9][0-9]*$")) {
      try {
        newAttempts = Integer.parseInt(command[1]);
      } catch (NumberFormatException e) {
        AttemptsBoundary.invalidChoice();
        return;
      }
      for (int i = UDifficulty.DIFFICULTY_EASY; i <= UDifficulty.DIFFICULTY_HARD; i++) {
        GameManager.getMatch().setAttempts(i, newAttempts);
      }
      AttemptsBoundary.operationDone();
    } else {
      AttemptsBoundary.invalidChoice();
    }
  }
}
