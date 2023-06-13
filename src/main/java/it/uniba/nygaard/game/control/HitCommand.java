package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UResult;
import it.uniba.nygaard.game.utility.UShutdown;
import it.uniba.nygaard.game.utility.UTime;
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
   * Setta il numero minimo e massimo di parametri che rendono valido il comando.
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
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando per colpire una nave.
   * Il comando è disponibile solo se non si è in partita.
   * Se viene passato un numero sbagliato di parametri, viene stampato il come usare il comando.
   * </p>
   *
   * @param command comando da eseguire
   */
  public void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse("<lettera>-<numero>");
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
      case UResult.WATER_CODE -> HitBoundary.miss();
      case UResult.HITTED_CODE -> HitBoundary.hit();
      case UResult.SANK_CODE -> HitBoundary.sunk();
      default -> {
      }
    }
    ShowAttemptsBoundary.showAttempts(p.getUsedAttempts(), p.getFailedAttempts(), p.getAttempts(p.getDifficulty()));
    if (p.getMaxTime() != UTime.DEFAULT_TIME) {
      TimeBoundary.showTime(p.getStartTime());
    } else {
      TimeBoundary.infiniteTime();
    }
    if (p.win()) {
      GeneralControl.setShutDown(UShutdown.WIN_TERMINATION_CODE);
      return;
    }
    if (p.getFailedAttempts() == p.getAttempts(p.getDifficulty())) {
      GeneralControl.setShutDown(UShutdown.OUT_OF_ATTEMPTS_TERMINATION_CODE);
    }
  }

}
