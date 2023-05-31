package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> GameManager </h2>
 * <p>
 * La classe GameManager rappresenta il gestore del gioco.
 * </p>
 *
 */
public final class GameManager {
    /**
     * <h3> match </h3>
     * <p>
     * Partita in corso.
     * </p>
     */
    private static Match match;
    /**
     * <h3> matchDifficulty </h3>
     * <p>
     * Difficoltà della prossima partita.
     * </p>
     */
    private static int matchDifficulty;
    /**
     * <h3> matchAttempts </h3>
     * <p>
     * Numero di tentativi della prossima partita.
     * </p>
     */
    private static int matchAttempts;
    /**
     * <h3> nextGridSize </h3>
     * <p>
     * Dimensione della griglia della prossima partita.
     * </p>
     */
    private static int nextGridSize;
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
     * <h3> getMatchDifficulty </h3>
     * <p>
     * Restituisce la difficoltà della prossima partita.
     * </p>
     * @return Difficoltà della prossima partita.
     */
    static int getMatchDifficulty() {
        return matchDifficulty;
    }
    /**
     * <h3> setMatchDifficulty </h3>
     * <p>
     * Imposta la difficoltà della prossima partita.
     * </p>
     * @param newMatchDifficulty Difficoltà della prossima partita.
     */
    static void setMatchDifficulty(final int newMatchDifficulty) {
        GameManager.matchDifficulty = newMatchDifficulty;
    }

    /**
     * <h3> setMatchAttempts </h3>
     * <p>
     * Imposta il numero di tentativi della prossima partita.
     * </p>
     * @param newMatchAttempts Numero di tentativi della prossima partita.
     */
    static void setMatchAttempts(final int newMatchAttempts) {
        GameManager.matchAttempts = newMatchAttempts;
    }

    static int getMatchAttempts() {
        return matchAttempts;
    }

    /**
     * <h3> setNextGridSizeName </h3>
     * <p>
     * Imposta la difficoltà della prossima partita.
     * </p>
     * @param newNextDifficulty Difficoltà della prossima partita.
     */
    static void setNextGridSizeName(final int newNextDifficulty) {
        GameManager.nextGridSize = newNextDifficulty;
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
    /**
     * <h3> actualDifficultyName </h3>
     * <p>
     * Restituisce il nome della difficoltà attuale.
     * </p>
     * @return Nome della difficoltà attuale.
     */
    public static String actualDifficultyName() {
        return match.getDifficultyNames(match.getDifficulty());
    }
    /**
     * <h3> newDifficultyName </h3>
     * <p>
     * Restituisce il nome della difficoltà passata come parametro.
     * </p>
     * @param newDifficulty Difficoltà della prossima partita.
     * @return Nome della difficoltà della prossima partita.
     */
    public static String newDifficultyName(final int newDifficulty) {
        return match.getDifficultyNames(newDifficulty);
    }
    /**
     * <h3> currentGridSize </h3>
     * <p>
     * Restituisce le dimensioni attuali della griglia.
     * </p>
     * @return dimensione attuale.
     */
    public static int currentGridSize() {
        return match.getGridSize();
    }
    /**
     * <h3> getMatchTime </h3>
     * <p>
     * Restituisce il tempo massimo della partita in corso.
     * </p>
     * @return Tempo massimo della partita.
     */
    public static long getMatchTime() {
        return match.getMaxTime();
    }

}
