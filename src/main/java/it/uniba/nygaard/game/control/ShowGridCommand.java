package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> ShowGridCommand </h2>
 * <p>
 * La classe ShowGridCommand rappresenta il comando per mostrare la griglia di attacco.
 * </p>
 *
 * @see Command
 */
final class ShowGridCommand extends Command {
  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di ShowGridCommand.
   * </p>
   */

  private static ShowGridCommand instance = new ShowGridCommand();

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe ShowGridCommand.
   * Setta il numero minimo e massimo di parametri che rendono valido il comando.
   * </p>
   */
  private ShowGridCommand() {
    setMinParamNumber(1);
    setMaxParamNumber(1);
  }

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di ShowGridCommand.
   * </p>
   */
  static ShowGridCommand getInstance() {
    return instance;
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando per mostrare la griglia di attacco.
   * Il comando è disponibile solo se si è in partita.
   * Se viene passato un numero sbagliato di parametri, viene stampato il come usare il comando.
   * </p>
   *
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse(command[0]);
      return;
    }
    Match p = GameManager.getMatch();
    if (!p.getInGame()) {
      ShowGridBoundary.notInGame();
      return;
    }
    if (command[0].equals("/svelagriglia")) {
      ShowGridBoundary.printGrid(p.getDefenseGrid());
    } else {
      ShowGridBoundary.printGrid(p.getAttackGrid());
    }

  }
}
