package it.uniba.nygaard.game.boundary;

/**
 * <<Boundary>>
 * <h2> ShowLevelBoundary </h2>
 * <p>
 * La classe ShowLevelBoundary stampa il livello di difficoltà
 * scelto dall'utente.
 * </p>
 */
public final class ShowLevelBoundary {
    /**
     * <h3> Costruttore </h3>
     * <p>
     * Costruttore della classe ShowLevelBoundary.
     * </p>
     */
    private ShowLevelBoundary() {
    }
    /**
     * <h3> printActualDifficulty </h3>
     * <p>
     * Stampa il livello di difficoltà scelto dall'utente.
     * </p>
     * @param s Livello di difficoltà
     */
    public static void printActualDifficulty(final String s) {
        System.out.println(s);
    }
}
