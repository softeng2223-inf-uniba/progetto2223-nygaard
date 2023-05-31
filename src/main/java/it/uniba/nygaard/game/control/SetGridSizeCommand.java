package it.uniba.nygaard.game.control;

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

        //TODO: Imposta dimensioni
        GridSizeBoundary.operationDone();
    }
}
