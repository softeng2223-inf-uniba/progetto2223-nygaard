package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.entity.Match;
import it.uniba.nygaard.game.utility.UColor;
import it.uniba.nygaard.game.utility.UDifficulty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class SetDifficultyCommandTest {

  private static SetDifficultyCommand setDifficultyCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;
  private static InputStream inBackup;


  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    inBackup = System.in;
    try {
      GameManager.setMatch(new Match());
      Method getInstance = SetDifficultyCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      setDifficultyCommand = (SetDifficultyCommand) getInstance.invoke(null);
      execute = setDifficultyCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare i comandi /facile, /medio e /difficile");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setDifficulty(UDifficulty.DIFFICULTY_MEDIUM);
    GameManager.getMatch().setInGame(false);
  }

  @Test
  @DisplayName("Cambio difficoltà con troppi argomenti")
  void testSetDifficultyCommandWithTooManyArgument() {
    String[] args = new String[]{"/facile", "stringa", "stringa"};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: "
        + "/facile [<numero tentativi>]" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio tentativi difficoltà con una stringa come argomento")
  void testSetDifficultyCommandWithStringArgument() {
    String[] args = new String[]{"/facile", "stringaqualsiasi"};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Numero di tentativi non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio tentativi difficoltà con un numero negativo come argomento")
  void testSetDifficultyCommandWithNegativeArgument() {
    String[] args = new String[]{"/facile", "-10"};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Numero di tentativi non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio tentativi difficoltà con un numero più grande di Integer.MAX_VALUE come argomento")
  void testSetDifficultyCommandWithOverflowArgument() {
    String[] args = new String[]{"/facile", String.valueOf((long) Integer.MAX_VALUE + 1)};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Numero di tentativi non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio tentativi difficoltà con un numero con zeri iniziali come argomento")
  void testSetDifficultyCommandWithLeadingZeros() {
    String[] args = new String[]{"/facile", "001"};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Numero di tentativi non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio difficoltà in partita")
  void testSetDifficultyCommandWithoutArgsInGame() {
    String[] args = new String[]{"/facile"};
    GameManager.getMatch().setInGame(true);
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Non puoi cambiare difficoltà durante una partita" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio tentativi difficoltà in partita")
  void testSetDifficultyCommandWithArgsInGame() {
    String[] args = new String[]{"/facile", "25"};
    GameManager.getMatch().setInGame(true);
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Non puoi cambiare il numero di tentativi durante una partita" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Reimposta la stessa difficoltà")
  void testSetDifficultyCommandSameDifficulty() {
    String[] args = new String[]{"/medio"};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Hai già impostato questa difficoltà" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio difficoltà non confermato")
  void testSetDifficultyCommandNegativeAnswer() {
    ByteArrayInputStream in = new ByteArrayInputStream("n\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    String[] args = new String[]{"/facile"};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Cambio difficoltà annullato" + UColor.RESET + System.lineSeparator();
    assertTrue(outContent.toString(StandardCharsets.UTF_8).contains(expectedOutput),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio difficoltà con conferma non valida")
  void testSetDifficultyCommandInvalidAnswer() {
    ByteArrayInputStream in = new ByteArrayInputStream("yn\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    String[] args = new String[]{"/facile"};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      System.err.println("testSetDifficultyCommandInvalidAnswer:");
      System.err.println(e.getCause());
      System.err.println("Eccezione dovuta al fatto che dopo il test il metodo in esame aspetta altri input");
      System.err.println("Tale eccezione non compromette l'esito del test ed è stata considerata la sua presenza\n");
    }
    String expectedOutput = UColor.RED + "Scelta non valida" + UColor.RESET + System.lineSeparator();
    assertTrue(outContent.toString(StandardCharsets.UTF_8).contains(expectedOutput),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio difficoltà confermato, controlla stampa messaggio di operazione completata")
  void testSetDifficultyCommandAffirmativeAnswerPrint() {
    ByteArrayInputStream in = new ByteArrayInputStream("y\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    String[] args = new String[]{"/facile"};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.GREEN + "OK" + UColor.RESET + System.lineSeparator();
    assertTrue(outContent.toString(StandardCharsets.UTF_8).contains(expectedOutput),
        "Non è stato stampato il messaggio di operazione completata");
  }

  @Test
  @DisplayName("Cambio difficoltà confermato, controlla che la difficoltà sia stata impostata correttamente")
  void testSetDifficultyCommandAffirmativeAnswerSet() {
    ByteArrayInputStream in = new ByteArrayInputStream("y\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    String[] args = new String[]{"/facile"};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    assertEquals(UDifficulty.DIFFICULTY_EASY, GameManager.getMatch().getDifficulty(),
        "La difficoltà non è stata impostata correttamente");
  }

  @Test
  @DisplayName("Cambio tentativi difficoltà, controlla stampa messaggio di operazione completata")
  void testSetDifficultyCommandAttemptsPrint() {
    String[] args = new String[]{"/medio", "50"};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.GREEN + "OK" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di operazione completata");
  }

  @Test
  @DisplayName("Cambio tentativi difficoltà, controlla che il numero di tentativi sia stato impostato correttamente")
  void testSetDifficultyCommandAttemptsSet() {
    String[] args = new String[]{"/medio", String.valueOf(UDifficulty.EASY_ATTEMPTS)};
    try {
      execute.invoke(setDifficultyCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    assertEquals(UDifficulty.EASY_ATTEMPTS, GameManager.getMatch().getAttempts(UDifficulty.DIFFICULTY_MEDIUM),
        "Il numero di tentativi non è stato impostato correttamente");
  }

  @AfterEach
  void tearDown() {
    System.setIn(inBackup);
  }
}
