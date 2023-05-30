package it.uniba.nygaard.game.control;

/**
 * <h2> CommandInterface </h2>
 * <p>
 * L'interfaccia CommandInterface rappresenta un generico comando.
 * </p>
 */
interface CommandInterface {
    /**
     * <h3> executeCommand </h3>
     * <p>
     *     Esegue il comando.
     * </p>
     * @param command Comando da eseguire.
     */
    void executeCommand(String[] command);
}
