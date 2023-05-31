package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.InputBoundary;

public class HitCommand extends Command{

    private static HitCommand instance = new HitCommand();

    private HitCommand() {
        setParamNumber(1);
    }

    static HitCommand getInstance() {
        return instance;
    }

    boolean invalidNumber(final String[] command, final String... params) {
        if(command.length>this.getParamNumber()){
            InputBoundary.howToUse("<lettera>-<numero>");
            return true;
        }
        return false;
    }

}
