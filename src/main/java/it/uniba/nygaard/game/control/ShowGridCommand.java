package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;

final class ShowGridCommand extends Command {

  private static ShowGridCommand instance = new ShowGridCommand();

  private ShowGridCommand() {
    setParamNumber(1);
  }

  static ShowGridCommand getInstance() {
    return instance;
  }

  public void executeCommand(final String[] command) {
    if (invalidNumber(command)) {
      return;
    }
    Match p = GameManager.getMatch();
    if (!p.getInGame()) {
      ShowGridBoundary.notInGame();
      return;
    }
    ShowGridBoundary.printGrid(p.getAttackGrid());
  }


}
