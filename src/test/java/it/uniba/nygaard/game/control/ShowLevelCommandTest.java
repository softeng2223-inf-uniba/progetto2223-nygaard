package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.entity.Match;
import it.uniba.nygaard.game.utility.UColor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ShowLevelCommandTest {

  private static ShowLevelCommand showLevelCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      GameManager.setMatch(new Match());
      Method getInstance = ShowLevelCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      showLevelCommand = (ShowLevelCommand) getInstance.invoke(null);
      execute = showLevelCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /mostralivello");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
  }

  @Test
  @DisplayName("/mostralivello con troppi argomenti")
  void testShowLevelCommandWithTooManyArgument() {
    String[] args = new String[]{"/mostralivello", "stringa"};
    try {
      execute.invoke(showLevelCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: /mostralivello" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/mostralivello corretto")
  void testShowLevelCommandCorrect() {
    String[] args = new String[]{"/mostralivello"};
    Match match = GameManager.getMatch();
    try {
      execute.invoke(showLevelCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = "Livello di difficoltà scelto: " + UColor.BOLD + UColor.YELLOW
        + match.getDifficultyNames(match.getDifficulty()) + UColor.RESET + "\nNumero massimo di tentativi falliti: "
        + UColor.BOLD + UColor.YELLOW + match.getAttempts(match.getDifficulty()) + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio corretto");
  }

}
