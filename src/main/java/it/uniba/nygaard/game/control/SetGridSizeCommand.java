package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.GridSizeBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> SetGridSizeCommand </h2>
 * <p>
 *     Classe che implementa il comando per impostare la dimensione della griglia.
 *     Il comando è disponibile solo se non si è in partita.
 *  </p>
 * @see Command
 */
final class SetGridSizeCommand extends Command {
    /**
     * Istanza della classe.
     */
    private static SetGridSizeCommand instance = new SetGridSizeCommand();
    /**
     * <h2> Costruttore </h2>
     * Costruttore della classe SetGridSizeCommand.
     */
    private SetGridSizeCommand() {
        setParamNumber(1);
    }
    /**
     * <h2> getInstance </h2>
     * <p>
     *     Ritorna l'istanza della classe.
     * </p>
     * @return Istanza della classe
     */
    public static SetGridSizeCommand getInstance() {
        return instance;
    }
    /**
     * <h2> executeCommand </h2>
     * <p>
     *     Esegue il comando per impostare la dimensione della griglia.
     * </p>
     * @param command Comando da eseguire
     */
    void executeCommand(final String[] command) {
        if (GameManager.getMatch().getInGame()) {
            GridSizeBoundary.inGameError();
            return;
        }

        if (invalidNumber(command)) {
            return;
        }

        Match p = GameManager.getMatch();
        int sizeCommand = this.getMappedCommand(command[0]);
        int currentSize = p.getGridSize();

        String choice;

        if (sizeCommand == currentSize) {
            GridSizeBoundary.sameSizeError();
            return;
        }

        do {
            choice = GridSizeBoundary.ask(sizeCommand);
            if (!choice.equals("n") && !choice.equals("y")) {
                GridSizeBoundary.invalidChoiceError();
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
    /**
     * <h2> getMappedCommand </h2>
     * <p>
     *     Ritorna la dimensione della griglia mappata al comando.
     * </p>
     * @param command Comando da mappare
     * @return griglia mappata al comando
     */
    private int getMappedCommand(final String command) {
        int size = 0;

        switch (command) {
            case "/standard" -> {
                size = Util.STANDARD_GRID_SIZE;
            }
            case "/large" -> {
                size = Util.LARGE_GRID_SIZE;
            }
            case "/extralarge" -> {
                size = Util.EXTRA_LARGE_GRID_SIZE;
            }
            default -> {
                size = Util.STANDARD_GRID_SIZE;
            }
        }

        return size;
    }
}
