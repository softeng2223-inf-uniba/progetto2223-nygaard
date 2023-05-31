package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.GridSizeBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 *
 */
public final class SetGridSizeCommand extends Command {

    private static SetGridSizeCommand instance = new SetGridSizeCommand();

    private SetGridSizeCommand() {
        setParamNumber(0);
    }

    public static SetGridSizeCommand getInstance() {
        return instance;
    }


    void executeCommand(final String[] command) {
        if (GameManager.getMatch().getInGame()) {
            GridSizeBoundary.inGameError();
            return;
        }

        if (command.length > getParamNumber() + 1) {
            GridSizeBoundary.tooManyArgs();
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
            choice = GridSizeBoundary.ask(p, sizeCommand);
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
        GridSizeBoundary.operationDone();
    }

    private int getMappedCommand(final String command) {
        int size = 0;

        switch (command) {
            case "/standard" -> size = Util.STANDARD_GRID_SIZE;
            case "/large" -> size = Util.LARGE_GRID_SIZE;
            case "/extralarge" -> size = Util.EXTRA_LARGE_GRID_SIZE;
            default -> size = Util.STANDARD_GRID_SIZE;
        }

        return size;
    }
}
