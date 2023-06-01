package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.MatchBoundary;
import it.uniba.nygaard.game.entity.Match;

class TimeCounter extends Thread {
  public void run() {
    Match p = GameManager.getMatch();
    while (true) {
      if (p.getInGame()) {
        if (System.currentTimeMillis() - p.getStartTime() > p.getMaxTime() * Util.ONE_MINUTE) {
          GeneralControl.setShutDown(Util.OUT_OF_TIME_TERMINATION_CODE);
          MatchBoundary.timeOut();
          break;
        }
      } else {
        break;
      }
    }
  }

}
