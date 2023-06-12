package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UColor;
import it.uniba.nygaard.game.utility.UTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StartMatchCommandTest {

  private static StartMatchCommand startMatchCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      Method getInstance = StartMatchCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      startMatchCommand = (StartMatchCommand) getInstance.invoke(null);
      execute = startMatchCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /gioca");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setInGame(false);
  }

  @Test
  @DisplayName("/gioca con troppi argomenti")
  void testStartMatchCommandTooManyArgs() {
    String[] args = new String[]{"/gioca", "parametro"};
    try {
      execute.invoke(startMatchCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: /gioca"
        + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/gioca in partita")
  void testStartMatchCommandInGame() {
    String[] args = new String[]{"/gioca"};
    GameManager.getMatch().setInGame(true);
    try {
      execute.invoke(startMatchCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Partita in corso\nPer cominciare una nuova partita abbandona la corrente"
        + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/gioca dopo aver impostato il tempo massimo, controlla che il tempo massimo sia stato impostato")
  void testStartMatchCommandStartTime() {
    String[] args = new String[]{"/gioca"};
    GameManager.getMatch().setMaxTime(1);
    try {
      execute.invoke(startMatchCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    assertNotEquals(UTime.DEFAULT_TIME, GameManager.getMatch().getStartTime(),
        "Il tempo di default non è stato cambiato");
  }
}
