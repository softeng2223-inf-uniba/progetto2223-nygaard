package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

public class ShowAttemptsBoundary {

    private ShowAttemptsBoundary() {
    }

    public static void showAttempts(int usedAttempts, int failedAttempts, int maxAttempts) {
        System.out.println("Hai già effettuato " + Util.BOLD + Util.GREEN + usedAttempts + " tentativi " + Util.RESET
                + "di cui " + Util.BOLD + Util.RED + failedAttempts + " falliti." + Util.RESET);
        System.out.println("Puoi fallire al massimo " + Util.BOLD + Util.RED + maxAttempts + " tentativi" + Util.RESET
                + " prima di perdere la partita.");
    }

}
