package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.ShowAttemptsBoundary;
import it.uniba.nygaard.game.entity.Match;

public class ShowAttemptsCommand implements Command {

    private static final ShowAttemptsCommand instance = new ShowAttemptsCommand();

    private ShowAttemptsCommand() {
        setParamNumber(1);
    }

    public static ShowAttemptsCommand getInstance() {
        return instance;
    }

    public void executeCommand(final String[] command) {
        if (invalidNumber(command)) {
            return;
        }
        Match p = GameManager.getMatch();
        if (p.getInGame()) {
            if (p.getAttempts(Util.CUSTOM_DIFFICULTY) != -1) {
                ShowAttemptsBoundary.showAttempts(p.getUsedAttempts(), p.getFailedAttempts(), p.getAttempts(Util.CUSTOM_DIFFICULTY));
            } else {
                ShowAttemptsBoundary.showAttempts(p.getUsedAttempts(), p.getFailedAttempts(), p.getAttempts(p.getDifficulty()));
            }
        } else {
            //TODO: Versione fuori dal gioco
        }
    }

}
