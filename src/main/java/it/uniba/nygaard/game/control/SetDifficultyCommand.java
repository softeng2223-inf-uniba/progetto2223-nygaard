package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UDifficulty;
import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.SetDifficultyBoundary;
import it.uniba.nygaard.game.entity.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * << Control >>
 * <h2> SetDifficultyCommand </h2>
 * <p>
 * La classe SetDifficultyCommand rappresenta il controllo per impostare la difficoltà.
 * </p>
 *
 * @see Command
 */
final class SetDifficultyCommand extends Command {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe SetDifficultyCommand.
   * </p>
   */
  private SetDifficultyCommand() {
    setMinParamNumber(1);
    setMaxParamNumber(2);
  }

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di SetEasy.
   * </p>
   */
  private static SetDifficultyCommand instance = new SetDifficultyCommand();

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di SetEasy.
   * </p>
   */
  static SetDifficultyCommand getInstance() {
    return instance;
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando per impostare una difficoltà
   * o un nuovo numero di tentativi per una delle difficoltà.
   * </p>
   *
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse(command[0], " [<numero tentativi>]");
      return;
    }
    if (GameManager.getMatch().getInGame()) {
      SetDifficultyBoundary.alreadyInGame(command.length == 1);
      return;
    }
    int difficultyInvolved = command[0].equals("/facile") ? UDifficulty.DIFFICULTY_EASY
        : command[0].equals("/medio") ? UDifficulty.DIFFICULTY_MEDIUM
        : UDifficulty.DIFFICULTY_HARD;

    if (command.length == 1) {
      GameManager.setMatchDifficulty(difficultyInvolved);
      setNewMatchDifficulty();
    } else {
      String regex = "^[1-9][0-9]*$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(command[1]);

      if (matcher.matches()) {
        try {
          GameManager.setMatchAttempts(Integer.parseInt(command[1]));
        } catch (NumberFormatException e) {
          SetDifficultyBoundary.notValidChoice();
          return;
        }
        setNewDiffAttempts(difficultyInvolved);
      } else {
        SetDifficultyBoundary.notValidChoice();
      }
    }
  }

  /**
   * <h3> setDifficulty </h3>
   * <p>
   * Imposta la difficoltà se questa non è già impostata,
   * altrimenti chiede all'utente se vuole cambiare difficoltà.
   * </p>
   */
  private void setNewMatchDifficulty() {
    int actualDifficulty = GameManager.getMatchDifficulty();
    Match p = GameManager.getMatch();
    if (p.getDifficulty() == actualDifficulty) {
      SetDifficultyBoundary.sameDifficulty();
      return;
    }
    String choice;
    do {
      choice = SetDifficultyBoundary.ask(actualDifficulty);
      if (!choice.equals("n") && !choice.equals("y")) {
        SetDifficultyBoundary.notValidChoice();
      }
    }
    while (!choice.equals("y") && !choice.equals("n"));
    if (choice.equals("n")) {
      SetDifficultyBoundary.operationCancelled();
      return;
    }
    p.setDifficulty(actualDifficulty);
    SetDifficultyBoundary.operationDone();
  }

  private void setNewDiffAttempts(final int difficultyToModify) {
    int attempts = GameManager.getMatchAttempts();
    Match p = GameManager.getMatch();
    if (p.getAttempts(difficultyToModify) == attempts) {
      SetDifficultyBoundary.sameAttempts();
      return;
    }
    p.setAttempts(difficultyToModify, attempts);
    SetDifficultyBoundary.operationDone();
  }
}

