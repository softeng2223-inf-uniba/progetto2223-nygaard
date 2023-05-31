package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.GridSizeBoundary;

/**
 * << Control >>
 *
 */
final public class SetGridSizeCommand extends Command {

    private static SetGridSizeCommand instance = new SetGridSizeCommand();

    private SetGridSizeCommand() {
        setParamNumber(0);
    }

    public static SetGridSizeCommand getInstance() {
        return instance;
    }


    void executeCommand(String[] command) {
        if (GameManager.getMatch().getInGame()) {
            GridSizeBoundary.inGameError();
            return;
        }

        if (command.length > getParamNumber() + 1) {
            GridSizeBoundary.tooManyArgs();
            return;
        }

        int sizeCommand = this.getMappedCommand(command[0]);
        int currentSize = GameManager.getGridSize();

        if (sizeCommand == currentSize) {
            GridSizeBoundary.sameSizeError();
            return;
        }


        //TODO: Aggiungere messaggio per segnalare il cambio di dimensioni
        // e chiede la conferma




        //TODO: Imposta dimensioni
        GridSizeBoundary.operationDone();
    }

    private int getMappedCommand(String command) {
        int size = Util.STANDARD_GRID_SIZE;

        switch (command) {
            case "/standard" -> size = Util.STANDARD_GRID_SIZE;
            case "/large" -> size = Util.LARGE_GRID_SIZE;
            case "/extralarge" -> size = Util.EXTRA_LARGE_GRID_SIZE;
        }

        return size;
    }
}
