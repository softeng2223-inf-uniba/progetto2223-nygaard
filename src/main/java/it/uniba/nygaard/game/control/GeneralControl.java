package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.MatchBoundary;
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
  private static int shutDown = 0;
  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe GeneralControl.
   * </p>
   */
  private GeneralControl() {
  }

  /**
   * <h3> setShutDown </h3>
   * <p>
   * Imposta il valore di shutDown.
   * </p>
   *
   * @param  value Nuovo valore di shutDown.
   */
  public static void setShutDown(final int value) {
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
  public static void startGame(String[] args) {
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
    String regex = "^[a-z]-[1-9][0-9]*$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher;
    GameManager.setArgs(args);
    ParamControl.initUI();
    do {
      GameManager.setMatch(new Match());
      GameManager.setMatchDifficulty(Util.DIFFICULTY_MEDIUM);
      GameManager.setNextGridSizeName(Util.STANDARD_GRID_SIZE);
      shutDown = 0;
      while (shutDown == 0) {
        String[] command = InputBoundary.getCommand().trim().replaceAll(" +", " ").split(" ");
        InputBoundary.resetColor();
        if(shutDown != 0) {
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
        case 1 -> MatchBoundary.win();
        case 2 -> MatchBoundary.outOfAttempts();
        case 3 -> {/*todo: implementare abbandona partita*/}
        default -> {}
      }
      if(shutDown != -1) {
        MatchBoundary.playAgain();
      }
    } while (shutDown != -1);
  }
}
