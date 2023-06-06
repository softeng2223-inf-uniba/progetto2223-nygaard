package it.uniba.nygaard.game.control;

/**
 * <h2> Command </h2>
 * <p>
 * La classe Command rappresenta un generico comando.
 * </p>
 */
abstract class Command {

  /**
   * <h3> minParam </h3>
   * <p>
   * Numero minimo di parametri del comando.
   * </p>
   */
  private int minParamNumber;
  /**
   * <h3> maxParam </h3>
   * <p>
   * Numero massimo di parametri del comando.
   * </p>
   */
  private int maxParamNumber;

  /**
   * <h3> getMinParamNumber </h3>
   * <p>
   * Restituisce il numero minimo di parametri per accettare il comando.
   * </p>
   *
   * @return Numero minimo di parametri per accettare il comando.
   */
  int getMinParamNumber() {
    return minParamNumber;
  }

  /**
   * <h3> getMaxParamNumber </h3>
   * <p>
   * Restituisce il numero massimo di parametri passabili al comando.
   * </p>
   *
   * @return Numero massimo di parametri passabili al comando.
   */
  int getMaxParamNumber() {
    return maxParamNumber;
  }

  /**
   * <h3> setParamNumber </h3>
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
   * <h3> invalidNumber </h3>
   * <p>
   * Controlla se il numero di parametri è valido.
   * </p>
   *
   * @param command Comando da eseguire.
   * @return true se il numero di parametri è valido, false altrimenti.
   */
  boolean invalidNumber(final String[] command, final String... params) {
    if (command.length > paramNumber) {
      if (params.length == 0) {
        InputBoundary.howToUse(command[0]);
      } else {
        InputBoundary.howToUse(command[0], String.join(" ", params));
      }
      return true;
    }
    return false;
  }
}
