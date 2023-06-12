package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UColor;
import it.uniba.nygaard.game.utility.UShip;
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

class ShowShipCommandTest {

  private static ShowShipCommand showShipCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      Method getInstance = ShowShipCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      showShipCommand = (ShowShipCommand) getInstance.invoke(null);
      execute = showShipCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /mostranavi");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
  }

  @Test
  @DisplayName("/mostranavi con troppi argomenti")
  void testShowShipCommandWithTooManyArgument() {
    String[] args = new String[]{"/mostranavi", "stringa"};
    try {
      execute.invoke(showShipCommand, (Object) args);
    } catch (Exception e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: /mostranavi" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/mostranavi corretto")
  void testShowShipCommandCorrect() {
    String[] args = new String[]{"/mostranavi"};
    try {
      execute.invoke(showShipCommand, (Object) args);
    } catch (Exception e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + UColor.ITALIC + "\tCacciatorpediniere \t" + UColor.RESET
        + "■■" + "\t" + UColor.CYAN + UColor.BOLD
        + "Esemplari: " + UShip.DESTROYER_NO + UColor.RESET + System.lineSeparator()
        + UColor.CYAN + UColor.ITALIC + "\tIncrociatore \t\t" + UColor.RESET
        + "■■■" + "\t" + UColor.CYAN + UColor.BOLD
        + "Esemplari: " + UShip.CRUISER_NO + UColor.RESET + System.lineSeparator()
        + UColor.CYAN + UColor.ITALIC + "\tCorazzata \t\t" + UColor.RESET
        + "■■■■" + "\t" + UColor.CYAN + UColor.BOLD
        + "Esemplari: " + UShip.BATTLESHIP_NO + UColor.RESET + System.lineSeparator()
        + UColor.CYAN + UColor.ITALIC + "\tPortaerei \t\t" + UColor.RESET
        + "■■■■■" + "\t" + UColor.CYAN + UColor.BOLD
        + "Esemplari: " + UShip.AIRCRAFT_NO + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio corretto");
  }
}
