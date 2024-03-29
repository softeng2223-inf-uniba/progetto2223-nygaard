package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UShutdown;
import it.uniba.nygaard.game.utility.UTime;
import it.uniba.nygaard.game.boundary.MatchBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> TimeCounter </h2>
 * <p>
 * La classe TimeCounter rappresenta il contatore del tempo di gioco.
 * </p>
 *
 * @see Thread
 */
class TimeCounter extends Thread {

  /**
   * <h3> run </h3>
   * <p>
   * Avvia il contatore del tempo di gioco.
   * Se il tempo di gioco è scaduto, viene stampato un messaggio di timeout.
   * </p>
   */
  public void run() {
    Match p = GameManager.getMatch();
    while (GeneralControl.getShutDown() == UShutdown.NOT_TERMINATION_CODE) {
      if (System.currentTimeMillis() - p.getStartTime() > p.getMaxTime() * UTime.ONE_MINUTE) {
        GeneralControl.setShutDown(UShutdown.OUT_OF_TIME_TERMINATION_CODE);
        MatchBoundary.timeOut();
        break;
      }
    }
  }

}
