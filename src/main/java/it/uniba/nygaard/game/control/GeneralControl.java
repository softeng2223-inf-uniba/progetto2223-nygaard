package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.entity.Match;
import java.util.HashMap;

/**
 * << Control >>
 * <h2> GeneralControl </h2>
 * <p>
 * La classe GeneralControl rappresenta il controllo generale del gioco.
 * </p>
 */
public final class GeneralControl {

  /**
   * <h3> shutDown </h3>
   * <p>
   * Termina il gioco se true.
   * </p>
   */
  private static boolean shutDown = false;
  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe GeneralControl.
   * </p>
   */
  private GeneralControl() {
  }

  /**
   * <h3> SetShutDown </h3>
   * <p>
   * Imposta il valore di shutDown.
   * </p>
   *
   * @param  value Nuovo valore di shutDown.
   */
  static void setShutDown(final boolean value) {
    GeneralControl.shutDown = value;
  }
  /**
   * <h3> startGame </h3>
   * <p>
   * Avvia il gioco.
   * </p>
   *
   * @param args Argomenti passati al programma.
   */
  public static void startGame(final String[] args) {
    GameManager.setMatch(new Match());
    GameManager.setNextDifficulty(Util.DIFFICULTY_NOT_SETTED);
    GameManager.setArgs(args);
    HashMap<String, Command> availableCommands = new HashMap<>();
    availableCommands.put("/esci", ExitCommand.getInstance());
    availableCommands.put("/facile", SetEasy.getInstance());
    availableCommands.put("/medio", SetMedium.getInstance());
    availableCommands.put("/difficile", SetHard.getInstance());
    availableCommands.put("/mostralivello", ShowLevelCommand.getInstance());
    availableCommands.put("/mostranavi", ShowShipCommand.getInstance());
    availableCommands.put("/gioca", StartMatchCommand.getInstance());
    availableCommands.put("/svelagriglia", UnveilGridCommand.getInstance());
    availableCommands.put("/help", HelpCommand.getInstance());
    ParamControl.executeCommand();
    while (true) {
      String[] command = InputBoundary.getCommand().split(" ");
      InputBoundary.reset();
      if (availableCommands.containsKey(command[0])) {
        availableCommands.get(command[0]).executeCommand(command);
        if (shutDown) {
          return;
        }
      } else {
        InputBoundary.notRecognisedCommand(command);
      }
    }
  }
}
