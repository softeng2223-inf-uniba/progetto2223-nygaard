package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.SetDifficultyBoundary;
import it.uniba.nygaard.game.entity.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * << Control >>
 * <h2> SetDifficultyCommand </h2>
 * <p>
 *     La classe SetDifficultyCommand rappresenta il controllo per impostare la difficoltà.
 * </p>
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
    setParamNumber(2);
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
   *   Esegue il comando per impostare una difficoltà
   *   o un nuovo numero di tentativi per una delle difficoltà.
   * </p>
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {}
}
