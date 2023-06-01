package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.MatchBoundary;

class TimeCounter extends Thread {
  public void run() {
    while (true) {
      if (GameManager.getMatch().getInGame()) {
        if (System.currentTimeMillis() - GameManager.getMatch().getStartTime() > GameManager.getMatch().getMaxTime() * Util.ONE_MINUTE) {
          GeneralControl.setShutDown(4);
          MatchBoundary.timeOut();
          break;
        }
      } else {
        break;
      }
    }
  }

}
