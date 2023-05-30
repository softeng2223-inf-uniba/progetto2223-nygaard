package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> GameManager </h2>
 * <p>
 * La classe GameManager rappresenta il gestore del gioco.
 * </p>
 */
final class GameManager {
    /**
     * <h3> match </h3>
     * <p>
     * Partita in corso.
     * </p>
     */
    private static Match match;
    /**
     * <h3> nextDifficulty </h3>
     * <p>
     * Difficoltà della prossima partita.
     * </p>
     */
    private static int nextDifficulty;
    /**
     * <h3> args </h3>
     * <p>
     * Argomenti passati al programma.
     * </p>
     */
    private static String[] args;
    /**
     * <h3> Costruttore </h3>
     * <p>
     * Costruttore della classe GameManager.
     * </p>
     */
    private GameManager() {
    }

    /**
     * <h3> getMatch </h3>
     * <p>
     * Restituisce la partita in corso.
     * </p>
     * @return Partita in corso.
     */
    static Match getMatch() {
        return match;
    }

    /**
     * <h3> setMatch </h3>
     * <p>
     *Imposta la partita in corso.
     *</p>
     * @param newMatch
     */
    static void setMatch(final Match newMatch) {
        GameManager.match = newMatch;
    }

    /**
     * <h3> getNextDifficulty </h3>
     * <p>
     * Restituisce la difficoltà della prossima partita.
     * </p>
     * @return Difficoltà della prossima partita.
     */
    static int getNextDifficulty() {
        return nextDifficulty;
    }

    /**
     * <h3> setNextDifficulty </h3>
     * <p>
     * Imposta la difficoltà della prossima partita.
     * </p>
     * @param newNextDifficulty Difficoltà della prossima partita.
     */
    static void setNextDifficulty(final int newNextDifficulty) {
        GameManager.nextDifficulty = newNextDifficulty;
    }
    /**
     * <h3> getArgs </h3>
     * <p>
     * Restituisce gli argomenti passati al programma.
     * </p>
     * @return Argomenti passati al programma.
     */
    static String[] getArgs() {
        return args;
    }
    /**
     * <h3> setArgs </h3>
     * <p>
     * Imposta gli argomenti passati al programma.
     * </p>
     * @param actualArgs Argomenti passati al programma.
     */
    static void setArgs(final String[] actualArgs) {
        GameManager.args = actualArgs;
    }
}
