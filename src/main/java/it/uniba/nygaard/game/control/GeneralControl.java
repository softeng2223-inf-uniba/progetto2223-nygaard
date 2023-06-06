package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.MatchBoundary;
import it.uniba.nygaard.game.boundary.ShowGridBoundary;
import it.uniba.nygaard.game.entity.Match;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
  private static volatile int shutDown = 0;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe GeneralControl.
   * </p>
   */
  private GeneralControl() {
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
    availableCommands.put("/svelagriglia", RevealGridCommand.getInstance());
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
    String regex = "^[a-z]-[1-9][0-9]*$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher;
    GameManager.setArgs(args);
    ParamControl.initUI();
    do {
      GameManager.setMatch(new Match());
      GameManager.setMatchDifficulty(Util.DIFFICULTY_MEDIUM);
      GameManager.setNextGridSizeName(Util.STANDARD_GRID_SIZE);
      shutDown = Util.NOT_TERMINATION_CODE;
      while (shutDown == Util.NOT_TERMINATION_CODE) {
        String[] command = InputBoundary.getCommand().trim().replaceAll(" +", " ").split(" ");
        InputBoundary.resetColor();
        if (shutDown != Util.NOT_TERMINATION_CODE) {
          break;
        }
        matcher = pattern.matcher(command[0]);
        if (matcher.matches()) {
          HitCommand.getInstance().executeCommand(command);
          continue;
        }
        if (availableCommands.containsKey(command[0])) {
          availableCommands.get(command[0]).executeCommand(command);
        } else {
          InputBoundary.notRecognisedCommand(command);
        }
      }
      switch (shutDown) {
        case Util.WIN_TERMINATION_CODE -> MatchBoundary.win();
        case Util.OUT_OF_ATTEMPTS_TERMINATION_CODE -> MatchBoundary.outOfAttempts();
        case Util.LEFT_TERMINATION_CODE -> MatchBoundary.leave();
        default -> {
        }
      }
      if (shutDown != Util.QUIT_TERMINATION_CODE) {
        if (shutDown != Util.WIN_TERMINATION_CODE) {
          MatchBoundary.printSolution();
          ShowGridBoundary.printGrid(GameManager.getMatch().getDefenseGrid());
        }
        MatchBoundary.playAgain();
      }
    } while (shutDown != Util.QUIT_TERMINATION_CODE);
  }
}
