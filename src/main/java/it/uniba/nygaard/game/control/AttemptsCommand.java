package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.AttemptsBoundary;
import it.uniba.nygaard.game.boundary.InputBoundary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * << Control >>
 * <h2> AttemptsCommand </h2>
 * <p>
 * La classe AttemptsCommand rappresenta il controllo per impostare
 * il numero di tentativi indipendentemente dalla difficoltà.
 * </p>
 */
public final class AttemptsCommand extends Command {

    /**
     * <h3> instance </h3>
     * <p>
     * Istanza di SetEasy.
     * </p>
     */
    private static AttemptsCommand instance = new AttemptsCommand();

    /**
     * <h3> Costruttore </h3>
     * <p>
     * Costruttore della classe AttemptsCommand.
     * </p>
     */
    private AttemptsCommand() {
        setParamNumber(2);
    }

    /**
     * <h3> getInstance </h3>
     * <p>
     * Restituisce l'istanza di SetEasy.
     * </p>
     */
    static AttemptsCommand getInstance() {
        return instance;
    }

    /**
     * <h3> executeCommand </h3>
     * <p>
     * Esegue il comando per impostare un numero di tentativi
     * indipendentemente dalla difficoltà.
     * </p>
     *
     * @param command Comando da eseguire.
     */
    void executeCommand(final String[] command) {

    }
}
