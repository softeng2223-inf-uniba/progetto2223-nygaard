package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.MatchBoundary;
import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;
import it.uniba.nygaard.game.utility.UShutdown;

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
   * <h3> instance </h3>
   * <p>
   * Istanza di GeneralControl.
   * </p>
   */
  private static GeneralControl instance = new GeneralControl();

  /**
   * <h3> shutDown </h3>
   * <p>
   * Termina il gioco se true.
   * </p>
   */
  private static volatile int shutDown = UShutdown.NOT_TERMINATION_CODE;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe GeneralControl.
   * </p>
   */
  private GeneralControl() {
  }

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di GeneralControl.
   * </p>
   */
  private static GeneralControl getInstance() {
    return instance;
  }

  /**
   * <h3> getShutDown </h3>
   * <p>
   * Restituisce il valore di shutDown.
   * </p>
   *
   * @return Valore di shutDown.
   */
  public static int getShutDown() {
    return GeneralControl.shutDown;
  }

  /**
   * <h3> setShutDown </h3>
   * <p>
   * Imposta il valore di shutDown.
   * </p>
   *
   * @param value Nuovo valore di shutDown.
   */
  public static void setShutDown(final int value) {
    GeneralControl.shutDown = value;
  }

  private static HashMap<String, Command> initCommands() {
    HashMap<String, Command> availableCommands = new HashMap<>();
    availableCommands.put("/esci", ExitCommand.getInstance());
    availableCommands.put("/facile", SetDifficultyCommand.getInstance());
    availableCommands.put("/medio", SetDifficultyCommand.getInstance());
    availableCommands.put("/difficile", SetDifficultyCommand.getInstance());
    availableCommands.put("/mostralivello", ShowLevelCommand.getInstance());
    availableCommands.put("/mostranavi", ShowShipCommand.getInstance());
    availableCommands.put("/gioca", StartMatchCommand.getInstance());
    availableCommands.put("/svelagriglia", ShowGridCommand.getInstance());
    availableCommands.put("/help", HelpCommand.getInstance());
    availableCommands.put("/tempo", SetTimeCommand.getInstance());
    availableCommands.put("/mostratempo", ShowTimeCommand.getInstance());
    availableCommands.put("/mostratentativi", ShowAttemptsCommand.getInstance());
    availableCommands.put("/standard", SetGridSizeCommand.getInstance());
    availableCommands.put("/large", SetGridSizeCommand.getInstance());
    availableCommands.put("/extralarge", SetGridSizeCommand.getInstance());
    availableCommands.put("/tentativi", AttemptsCommand.getInstance());
    availableCommands.put("/abbandona", LeaveMatchCommand.getInstance());
    availableCommands.put("/mostragriglia", ShowGridCommand.getInstance());
    return availableCommands;
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
    HashMap<String, Command> availableCommands = initCommands();
    GameManager.setArgs(args);
    ParamControl.initUI();
    while (shutDown != UShutdown.QUIT_TERMINATION_CODE) {
      GameManager.setMatch(new Match());
      shutDown = UShutdown.NOT_TERMINATION_CODE;
      while (shutDown == UShutdown.NOT_TERMINATION_CODE) {
        String[] command = InputBoundary.getCommand().trim().replaceAll(" +", " ").split(" ");
        String inputCommand = command[0];
        InputBoundary.resetColor();
        if (shutDown != UShutdown.NOT_TERMINATION_CODE) {
          break;
        }
        if (inputCommand.matches("^[a-z]-[1-9][0-9]*$")) {
          HitCommand.getInstance().executeCommand(command);
          continue;
        }
        if (availableCommands.containsKey(inputCommand)) {
          availableCommands.get(inputCommand).executeCommand(command);
        } else {
          InputBoundary.notRecognisedCommand(command);
        }
      }
      switch (shutDown) {
        case UShutdown.WIN_TERMINATION_CODE -> MatchBoundary.win();
        case UShutdown.OUT_OF_ATTEMPTS_TERMINATION_CODE -> MatchBoundary.outOfAttempts();
        case UShutdown.LEFT_TERMINATION_CODE -> MatchBoundary.leave();
        default -> {
        }
      }
      if (shutDown != UShutdown.QUIT_TERMINATION_CODE) {
        if (shutDown != UShutdown.WIN_TERMINATION_CODE) {
          MatchBoundary.printSolution();
          ShowGridBoundary.printGrid(GameManager.getMatch().getDefenseGrid());
        }
        MatchBoundary.endMatch();
      }
    }
  }
}
