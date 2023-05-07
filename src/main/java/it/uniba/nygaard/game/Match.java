package it.uniba.nygaard.game;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * <p>
 *   La classe Match si occupa della partita.
 *   Contiene tutte le informazioni relative alla partita
 *   e tutti i metodi per settarli e modificarli.
 * </p>
 */
public final class Match {
    private boolean inGame;
    private int difficulty;
    private String[] difficultyNames;

    private final int[] attempts;
    /**
     * Metodo costruttore di Match.
     * Inizializza tutti i suoi attributi ai valori di default prefissati.
     *
     */
    public Match() {
        this.inGame = false;
        this.difficulty = Util.DIFFICULTY_NOT_SETTED;
        this.difficultyNames = new String[]
                {Util.EASY_NAME, Util.MEDIUM_NAME, Util.HARD_NAME};
        this.attempts = new int[]
                {Util.EASY_ATTEMPTS, Util.MEDIUM_ATTEMPTS, Util.HARD_ATTEMPTS};
    }

    /**
     * Punto di ingresso dell'applicazione.
     *
     * @param difficulty1 Parametro di ingresso per imposatere
     *                    la difficoltà della partita
     */
    public void setDifficulty(final int difficulty1) {
        if (this.inGame) {
            System.out.println("Non puoi cambiare difficoltà "
                   + "durante una partita");
            return;
        }
        if (this.difficulty == difficulty1) {
            System.out.println("Hai già impostato questa difficoltà");
            return;
        }
        if (this.difficulty != Util.DIFFICULTY_NOT_SETTED) {
            boolean repeat;
            String choice;
            Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
            do {
                System.out.print("Il livello attuale è "
                        + difficultyNames[this.difficulty]
                        + ". Confermare cambio in "
                        + difficultyNames[difficulty1]
                        + "? (y/n)");
                repeat = false;
                choice = in.nextLine().toLowerCase();
                if (choice.equals("y")) {
                    this.difficulty = difficulty1;
                } else if (choice.equals("n")) {
                    return;
                } else {
                    System.out.println("Scelta non valida");
                    repeat = true;
                }
            }
            while (repeat);
        } else {
            this.difficulty = difficulty1;
        }
        System.out.println("OK");
    }
}
