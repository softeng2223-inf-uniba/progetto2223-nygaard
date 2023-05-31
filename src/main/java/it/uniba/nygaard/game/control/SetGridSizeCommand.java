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
        if (GameManager.getMatch().getInGame()) {
            //TODO: Sei in game, quindi non puoi cambiare le dimensioni della griglia
            return;
        }

        if (command.length > 1) {
            //TODO: Il comando non accetta parametri
            return;
        }

        //TODO: Imposta dimensioni
    }
}
