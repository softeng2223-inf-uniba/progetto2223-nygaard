package it.uniba.nygaard.game.entity;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.control.GameManager;
import it.uniba.nygaard.game.control.GeneralControl;

public class TimeCounter extends Thread{
  public void run() {
    while (true) {
      if (GameManager.getMatch().getInGame()) {
        if(System.currentTimeMillis() - GameManager.getMatch().getStartTime() > GameManager.getMatch().getMaxTime() * Util.ONE_MINUTE){
          GeneralControl.setShutDown(3);
          break;
        }
      }else{
        break;
      }
    }
  }

}
