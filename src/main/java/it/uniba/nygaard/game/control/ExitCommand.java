package it.uniba.nygaard.game.control;
import it.uniba.nygaard.game.boundary.ExitBoundary;
import it.uniba.nygaard.game.boundary.InputBoundary;

/**
 * << Control >>
 * <h2> ExitCommand </h2>
 * <p>
 *     La classe ExitCommand rappresenta il comando di uscita dal gioco.
 * </p>
 * @see Command
 */
final class ExitCommand extends Command {
    /**
     * <h3> instance </h3>
     * <p>
     *     Istanza di ExitCommand.
     * </p>
     */
    private static ExitCommand instance = new ExitCommand();
    /**
     * <h3> Costruttore </h3>
     * <p>
     *     Costruttore della classe ExitCommand.
     * </p>
     */
    private ExitCommand() {
        setParamNumber(1);
    }
    /**
     * <h3> getInstance </h3>
     * <p>
     *     Restituisce l'istanza di ExitCommand.
     * </p>
     * @return Istanza di ExitCommand.
     */
    static ExitCommand getInstance() {
        return instance;
    }
    /**
     * <h3> executeCommand </h3>
     * <p>
     *     Esegue il comando di uscita dal gioco
     *     chiedendo all'utente se è sicuro di voler uscire.
     *     Se l'utente conferma l'uscita, il gioco termina
     *     altrimenti viene annullata l'operazione.
     * </p>
     * @param command Comando da eseguire.
     */
    public void executeCommand(final String[] command) {
        if (invalidNumber(command)) {
            return;
        }
        String choice;
        do {
            choice = ExitBoundary.ask();
            if (choice.equals("y")) {
                ExitBoundary.exitString();
                GeneralControl.setShutDown(true);
                return;
            }
            if (choice.equals("n")) {
                ExitBoundary.operationCancelled();
            } else {
                ExitBoundary.invalidChoice();
            }
        } while (!choice.equals("n"));
    }
}
