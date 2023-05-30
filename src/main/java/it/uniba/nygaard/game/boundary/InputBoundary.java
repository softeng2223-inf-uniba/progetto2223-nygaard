package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputBoundary {
    private InputBoundary() {
    }

    public static String getCommand() {
        System.out.print("Inserire un comando: " + Util.CYAN);
        return new Scanner(System.in, StandardCharsets.UTF_8).nextLine().toLowerCase();

    }
}
