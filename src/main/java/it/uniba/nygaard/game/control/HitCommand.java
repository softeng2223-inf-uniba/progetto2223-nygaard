package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.TimeBoundary;
import it.uniba.nygaard.game.boundary.HitBoundary;
import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.ShowAttemptsBoundary;
import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;

final class HitCommand extends Command {

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
      HitBoundary.invalidCoordinates();
      return;
    }
    ShowGridBoundary.printGrid(p.getAttackGrid());
    switch (res) {
      case 0 -> HitBoundary.miss();
      case 1 -> HitBoundary.hit();
      case 2 -> HitBoundary.sunk();
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
      GeneralControl.setShutDown(1);
      return;
    }
    if (p.getFailedAttempts() == p.getAttempts(p.getDifficulty())) {
      GeneralControl.setShutDown(2);
      return;
    }
  }

}
