package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.LeaveGameBoundary;

public class LeaveGameCommand extends Command {
    /**
     */
    private static LeaveGameCommand instance = new LeaveGameCommand();

    /**
     */
    private LeaveGameCommand() {
        setParamNumber(1);
    }

    /**
     */
    public static LeaveGameCommand getInstance() {
        return instance;
    }

    void executeCommand(String[] command) {

    }
}

