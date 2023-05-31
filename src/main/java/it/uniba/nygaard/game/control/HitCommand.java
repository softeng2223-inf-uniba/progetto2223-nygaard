package it.uniba.nygaard.game.control;

public class HitCommand extends Command{

    private static HitCommand instance = new HitCommand();

    private HitCommand() {
        setParamNumber(1);
    }

    static HitCommand getInstance() {
        return instance;
    }

}
