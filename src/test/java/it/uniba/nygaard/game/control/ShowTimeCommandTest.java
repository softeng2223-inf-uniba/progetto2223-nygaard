package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.entity.Match;
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

class ShowTimeCommandTest {

  private static ShowTimeCommand showTimeCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() throws NoSuchMethodException {
    outContent = new ByteArrayOutputStream();
    try {
      GameManager.setMatch(new Match());
      Method getInstance = ShowTimeCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      showTimeCommand = (ShowTimeCommand) getInstance.invoke(null);
      execute = showTimeCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile testare il comando /mostratempo");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setInGame(true);
  }

  @Test
  @DisplayName("/mostratempo con troppi argomenti")
  void testShowTimeCommandWithTooManyArgument() {
    String[] args = new String[]{"/mostratempo", "stringa"};
    try {
      execute.invoke(showTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: /mostratempo" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/mostratempo non in gioco")
  void testShowTimeCommandNotInGame() {
    String[] args = new String[]{"/mostratempo"};
    GameManager.getMatch().setInGame(false);
    try {
      execute.invoke(showTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Non puoi visualizzare il tempo rimanente se non sei in partita" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/mostratempo con tempo illimitato")
  void testShowTimeCommandInfiniteTime() {
    String[] args = new String[]{"/mostratempo"};
    GameManager.getMatch().setMaxTime(UTime.DEFAULT_TIME);
    try {
      execute.invoke(showTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il tempo è illimitato" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di tempo illimitato");
  }

  @Test
  @DisplayName("/mostratempo con tempo non illimitato")
  void testShowTimeCommandNotInfiniteTime() {
    String[] args = new String[]{"/mostratempo"};
    GameManager.getMatch().setStartTime(System.currentTimeMillis());
    GameManager.getMatch().setMaxTime(1);
    try {
      execute.invoke(showTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il tempo trascorso è di 0 minuti" + System.lineSeparator()
        + "Il tempo rimanente è di 1 minuti" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di tempo corretto");
  }
}
