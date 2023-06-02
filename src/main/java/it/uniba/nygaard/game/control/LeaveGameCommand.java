package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.ExitBoundary;
import it.uniba.nygaard.game.boundary.LeaveGameBoundary;
import it.uniba.nygaard.game.boundary.MatchBoundary;

public class LeaveGameCommand extends Command {
  /**
   *
   */
  private static LeaveGameCommand instance = new LeaveGameCommand();

  /**
   *
   */
  private LeaveGameCommand() {
    setParamNumber(1);
  }

  /**
   *
   */
  public static LeaveGameCommand getInstance() {
    return instance;
  }

  void executeCommand(final String[] command) {
    if (!GameManager.getMatch().getInGame()) {
      LeaveGameBoundary.notInGame();
      return;
    }
    if (invalidNumber(command)) {
      return;
    }
    String choice;
    do {
      choice = LeaveGameBoundary.ask();
      if (GeneralControl.getShutDown() != Util.NOT_TERMINATION_CODE) {
        return;
      }
      if (choice.equals("y")) {
        //MatchBoundary.leave();
        GeneralControl.setShutDown(Util.LEFT_TERMINATION_CODE);
        return;
      }
      if (choice.equals("n")) {
        LeaveGameBoundary.operationCancelled();
      } else {
        LeaveGameBoundary.invalidChoice();
      }
    } while (!choice.equals("n"));
  }
}
