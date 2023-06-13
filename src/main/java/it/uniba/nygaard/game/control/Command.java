package it.uniba.nygaard.game.control;

/**
 * <h2> Command </h2>
 * <p>
 * La classe Command rappresenta un generico comando.
 * </p>
 */
abstract class Command {

  /**
   * <h3> minParamNumber </h3>
   * <p>
   * Numero minimo di parametri del comando.
   * </p>
   */
  private int minParamNumber;
  /**
   * <h3> maxParamNumber </h3>
   * <p>
   * Numero massimo di parametri del comando.
   * </p>
   */
  private int maxParamNumber;

  /**
   * <h3> setMinParamNumber </h3>
   * <p>
   * Imposta il numero minimo di parametri del comando.
   * </p>
   *
   * @param newParamNumber Numero minimo di parametri del comando.
   */
  void setMinParamNumber(final int newParamNumber) {
    this.minParamNumber = newParamNumber;
  }

  /**
   * <h3> setParamNumber </h3>
   * <p>
   * Imposta il numero massimo di parametri del comando.
   * </p>
   *
   * @param newParamNumber Numero massimo di parametri del comando.
   */
  void setMaxParamNumber(final int newParamNumber) {
    this.maxParamNumber = newParamNumber;
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando.
   * </p>
   *
   * @param command Comando da eseguire.
   */
  abstract void executeCommand(String[] command);

  /**
   * <h3> checkNoParams </h3>
   * <p>
   * Controlla se il numero di parametri è valido.
   * </p>
   *
   * @param command Comando da eseguire.
   * @return true se il numero di parametri è valido, false altrimenti.
   */
  boolean checkNoParams(final String[] command) {
    return command.length > maxParamNumber || command.length < minParamNumber;
  }
}
