package it.uniba.nygaard.game.control;

public class ShowAttemptsCommand implements Command {

    private static final ShowAttemptsCommand instance = new ShowAttemptsCommand();

    private ShowAttemptsCommand() {
        setParamNumber(1);
    }

}
