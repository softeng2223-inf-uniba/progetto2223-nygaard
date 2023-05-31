package it.uniba.nygaard.game.control;

/**
 * << Control >>
 *
 */
final public class SetGridSizeCommand extends Command {

    private static SetGridSizeCommand instance = new SetGridSizeCommand();

    private SetGridSizeCommand() {
        setParamNumber(0);
    }

    public static SetGridSizeCommand getInstance() {
        return instance;
    }


    void executeCommand(String[] command) {

    }
}
