package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UColor;
import it.uniba.nygaard.game.utility.UShutdown;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class HitCommandTest {

  private static HitCommand hitCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;
  private static InputStream inBackup;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    inBackup = System.in;
    try {
      Method getInstance = HitCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      hitCommand = (HitCommand) getInstance.invoke(null);
      execute = hitCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando colpo");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GeneralControl.setShutDown(UShutdown.NOT_TERMINATION_CODE);
    GameManager.getMatch().setInGame(true);
  }

  @Test
  @DisplayName("Colpo con troppi argomenti")
  void testHitCommandWithTooManyArgs() {
    String[] args = new String[]{"B-4", "altro parametro"};
    try {
      execute.invoke(hitCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: "
        + "<lettera>-<numero>" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Colpo non in partita")
  void testHitCommandNotInGame() {
    String[] args = new String[]{"B-4"};
    GameManager.getMatch().setInGame(false);
    try {
      execute.invoke(hitCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Non puoi eseguire colpi se non sei in partita"
        + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Colpo con riga maggiore di Integer.MAX_VALUE")
  void testHitCommandNumberFormatException() {
    String[] args = new String[]{"B-" + ((long) Integer.MAX_VALUE + 1)};
    try {
      execute.invoke(hitCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Coordinate non valide" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @AfterEach
  void tearDown() {
    System.setIn(inBackup);
  }
}
