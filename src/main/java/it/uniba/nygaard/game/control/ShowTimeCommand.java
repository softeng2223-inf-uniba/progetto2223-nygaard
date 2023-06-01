package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.TimeBoundary;

/**
 * <<Control>>
 * <h2>ShowTimeCommand</h2>
 * <p>
 *     La classe ShowTimeCommand rappresenta il comando di visualizzazione del tempo.
 * </p>
 * @see Command
 */
final class ShowTimeCommand extends Command {
    private static ShowTimeCommand instance = new ShowTimeCommand();
    /**
     * <h3> Costruttore </h3>
     * <p>
     *     Costruttore della classe ShowTimeCommand.
     * </p>
     */
    private ShowTimeCommand() {
        setParamNumber(1);
    }
    /**
     * <h3> getInstance </h3>
     * <p>
     *     Restituisce l'istanza di ShowTimeCommand.
     * </p>
     */
    static ShowTimeCommand getInstance() {
        return instance;
    }
    /**
     * <h3> executeCommand </h3>
     * <p>
     *     Esegue il comando di visualizzazione del tempo se si è in partita.
     * </p>
     * @param command Comando da eseguire.
     */
    public void executeCommand(final String[] command) {
        if (invalidNumber(command)) {
            return;
        }
        if (!GameManager.getMatch().getInGame()) {
            TimeBoundary.mustBeInGame();
            return;
        }
        if (GameManager.getMatch().getMaxTime() == Util.DEFAULT_TIME) {
            TimeBoundary.infiniteTime();
        } else {
            TimeBoundary.showTime(GameManager.getMatch().getStartTime());
        }
    }
}
