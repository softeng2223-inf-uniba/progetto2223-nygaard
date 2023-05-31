package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.ShowAttemptsBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> ShowAttemptsCommand </h2>
 * <p>
 * La classe ShowAttemptsCommand rappresenta il comando per mostrare il numero di tentativi.
 * </p>
 *
 * @see Command
 */
public final class ShowAttemptsCommand extends Command {
    /**
     * <h3> instance </h3>
     * <p>
     *     Istanza di ShowAttemptsCommand.
     * </p>
     */
    private static ShowAttemptsCommand instance = new ShowAttemptsCommand();
    /**
     * <h3> Costruttore </h3>
     * <p>
     *     Costruttore della classe ShowAttemptsCommand.
     * </p>
     */
    private ShowAttemptsCommand() {
        setParamNumber(1);
    }
    /**
     * <h3> getInstance </h3>
     * <p>
     *    Restituisce l'istanza di ShowAttemptsCommand.
     * </p>
     */
    public static ShowAttemptsCommand getInstance() {
        return instance;
    }
    /**
     * <h3> executeCommand </h3>
     * <p>
     *     Esegue il comando per mostrare il numero di tentativi.
     * </p>
     * @param command comando da eseguire
     */
    public void executeCommand(final String[] command) {
        if (invalidNumber(command)) {
            return;
        }
        Match p = GameManager.getMatch();
        if (p.getInGame()) {
            if (p.getAttempts(Util.CUSTOM_DIFFICULTY) != -1) {
                ShowAttemptsBoundary.showAttempts(p.getUsedAttempts(), p.getFailedAttempts(),
                        p.getAttempts(Util.CUSTOM_DIFFICULTY));
            } else {
                ShowAttemptsBoundary.showAttempts(p.getUsedAttempts(), p.getFailedAttempts(),
                        p.getAttempts(p.getDifficulty()));
            }
        }
        //todo: altrimenti versione fuori dal gioco
    }

}
