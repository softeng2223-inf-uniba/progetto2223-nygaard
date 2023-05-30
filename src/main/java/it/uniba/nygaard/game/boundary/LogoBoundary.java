package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

public class LogoBoundary {
    private LogoBoundary() {
    }
    public static void printLogo() {
        String logo = Util.BOLD + Util.RED
                + "    ____   ___   ______ ______ __     ______ _____  __  __ ____ ____ \n"
                + "   / __ ) /   | /_  __//_  __// /    / ____// ___/ / / / //  _// __ \\\n"
                + "  / __  |/ /| |  / /    / /  / /    / __/   \\__ \\ / /_/ / / / / /_/ /\n"
                + Util.BLUE
                + " / /_/ // ___ | / /    / /  / /___ / /___  ___/ // __  /_/ / / ____/ \n"
                + "/_____//_/  |_|/_/    /_/  /_____//_____/ /____//_/ /_//___//_/      \n"
                + Util.RESET;
        System.out.println(logo);
    }
}
