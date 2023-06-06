package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UGrid;
import it.uniba.nygaard.game.boundary.GridSizeBoundary;
import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> SetGridSizeCommand </h2>
 * <p>
 * Classe che implementa il comando per impostare la dimensione della griglia.
 * Il comando è disponibile solo se non si è in partita.
 * </p>
 *
 * @see Command
 */
final class SetGridSizeCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di SetGridCommand.
   * </p>
   */
  private static SetGridSizeCommand instance = new SetGridSizeCommand();

  /**
   * <h2> Costruttore </h2>
   * Costruttore della classe SetGridSizeCommand.
   */
  private SetGridSizeCommand() {
    setMinParamNumber(1);
    setMaxParamNumber(1);
  }

  /**
   * <h2> getInstance </h2>
   * <p>
   * Ritorna l'istanza della classe.
   * </p>
   *
   * @return Istanza della classe
   */
  public static SetGridSizeCommand getInstance() {
    return instance;
  }

  /**
   * <h2> executeCommand </h2>
   * <p>
   * Esegue il comando per impostare la dimensione della griglia.
   * </p>
   *
   * @param command Comando da eseguire
   */
  void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse(command[0]);
      return;
    }

    if (GameManager.getMatch().getInGame()) {
      GridSizeBoundary.alreadyInGame();
      return;
    }

    Match p = GameManager.getMatch();
    int sizeCommand = this.getMappedCommand(command[0]);
    int currentSize = p.getGridSize();

    String choice;

    if (sizeCommand == currentSize) {
      GridSizeBoundary.sameSize();
      return;
    }

    do {
      choice = GridSizeBoundary.ask(sizeCommand);
      if (!choice.equals("n") && !choice.equals("y")) {
        GridSizeBoundary.invalidChoice();
      }
    }
    while (!choice.equals("y") && !choice.equals("n"));

    if (choice.equals("n")) {
      GridSizeBoundary.operationCancelled();
      return;
    }

    p.setGridSize(sizeCommand);
    p.resizeGrids(sizeCommand);
    GridSizeBoundary.operationDone();
  }
}
