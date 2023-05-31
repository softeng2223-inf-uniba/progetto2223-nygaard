package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.*;

public class HitCommand extends Command {

  private static HitCommand instance = new HitCommand();

  private HitCommand() {
    setParamNumber(1);
  }

  static HitCommand getInstance() {
    return instance;
  }

  boolean invalidNumber(final String[] command, final String... params) {
    if (command.length > this.getParamNumber()) {
      InputBoundary.howToUse("<lettera>-<numero>");
      return true;
    }
    return false;
  }

  public void executeCommand(final String[] command) {
    if (invalidNumber(command)) {
      return;
    }
    if (!GameManager.getMatch().getInGame()) {
      HitBoundary.notInGame();
      return;
    }
    String[] coordinates = command[0].split("-");
    int res;
    try {
      int y = coordinates[0].charAt(0) - 'a';
      int x = Integer.parseInt(coordinates[1]) - 1;
      res = GameManager.getMatch().hit(x, y);
    } catch (NumberFormatException | IndexOutOfBoundsException e) {
      HitBoundary.invalidCoordinates();
      return;
    }
    ShowGridBoundary.printGrid(GameManager.getMatch().getAttackGrid());
    switch (res) {
        case 0 -> HitBoundary.miss();
        case 1 -> HitBoundary.hit();
        case 2 -> HitBoundary.sunk();
        default -> {
        }
    }
    ShowAttemptsBoundary.showAttempts(GameManager.getMatch().getUsedAttempts(), GameManager.getMatch().getFailedAttempts(), GameManager.getMatch().getAttempts(GameManager.getMatch().getDifficulty()));
    if(GameManager.getMatch().getMaxTime() != Util.DEFAULT_TIME) {
        TimeBoundary.showTime(GameManager.getMatch().getStartTime());
    }else{
      TimeBoundary.infiniteTime();
    }

  }

}
