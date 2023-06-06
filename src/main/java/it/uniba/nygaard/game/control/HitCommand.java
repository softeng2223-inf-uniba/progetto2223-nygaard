package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.TimeBoundary;
import it.uniba.nygaard.game.boundary.HitBoundary;
import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.ShowAttemptsBoundary;
import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> HitCommand </h2>
 * <p>
 * La classe HitCommand rappresenta il comando per colpire una nave.
 * </p>
 *
 * @see Command
 */
final class HitCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di HitCommand.
   * </p>
   */
  private static HitCommand instance = new HitCommand();

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe HitCommand.
   * </p>
   */
  private HitCommand() {
    setMinParamNumber(1);
    setMaxParamNumber(1);
  }

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di HitCommand.
   * </p>
   */
  static HitCommand getInstance() {
    return instance;
  }

  /**
   * <h3> invalidNumber </h3>
   * <p>
   * Controlla se il numero di parametri è valido.
   * </p>
   *
   * @param command comando da eseguire
   * @param params  parametri del comando
   * @return true se il numero di parametri è invalido, false altrimenti
   */
  boolean invalidNumber(final String[] command, final String... params) {
    if (command.length > this.getParamNumber()) {
      InputBoundary.howToUse("<lettera>-<numero>");
      return true;
    }
    return false;
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando per colpire una nave.
   * </p>
   *
   * @param command comando da eseguire
   */
  public void executeCommand(final String[] command) {
    if (invalidNumber(command)) {
      return;
    }
    Match p = GameManager.getMatch();
    if (!p.getInGame()) {
      HitBoundary.notInGame();
      return;
    }
    String[] coordinates = command[0].split("-");
    int res;
    try {
      int y = coordinates[0].charAt(0) - 'a';
      int x = Integer.parseInt(coordinates[1]) - 1;
      res = p.hit(x, y);
    } catch (NumberFormatException | IndexOutOfBoundsException e) {
      HitBoundary.invalidChoice();
      return;
    }
    ShowGridBoundary.printGrid(p.getAttackGrid());
    switch (res) {
      case Util.WATER_CODE -> HitBoundary.miss();
      case Util.HITTED_CODE -> HitBoundary.hit();
      case Util.SANK_CODE -> HitBoundary.sunk();
      default -> {
      }
    }
    ShowAttemptsBoundary.showAttempts(p.getUsedAttempts(), p.getFailedAttempts(), p.getAttempts(p.getDifficulty()));
    if (p.getMaxTime() != Util.DEFAULT_TIME) {
      TimeBoundary.showTime(p.getStartTime());
    } else {
      TimeBoundary.infiniteTime();
    }
    if (p.win()) {
      GeneralControl.setShutDown(Util.WIN_TERMINATION_CODE);
      return;
    }
    if (p.getFailedAttempts() == p.getAttempts(p.getDifficulty())) {
      GeneralControl.setShutDown(Util.OUT_OF_ATTEMPTS_TERMINATION_CODE);
    }
  }

}
