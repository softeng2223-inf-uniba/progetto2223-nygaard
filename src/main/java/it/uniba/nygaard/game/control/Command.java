package it.uniba.nygaard.game.control;

/**
 * <h2> Command </h2>
 * <p>
 * La classe Command rappresenta un generico comando.
 * </p>
 */
abstract class Command {
    /**
     * <h3> paramNumber </h3>
     * <p>
     *     Numero di parametri del comando.
     * </p>
     */
    private int paramNumber;
    /**
     * <h3> getParamNumber </h3>
     * <p>
     *     Restituisce il numero di parametri del comando.
     * </p>
     * @return Numero di parametri del comando.
     */
    int getParamNumber() {
        return paramNumber;
    }
    /**
     * <h3> setParamNumber </h3>
     * <p>
     *     Imposta il numero di parametri del comando.
     * </p>
     * @param newParamNumber Numero di parametri del comando.
     */
    void setParamNumber(final int newParamNumber) {
        this.paramNumber = newParamNumber;
    }
/**
     * <h3> executeCommand </h3>
     * <p>
     *     Esegue il comando.
     * </p>
     * @param command Comando da eseguire.
     */
    abstract void executeCommand(String[] command);
}
