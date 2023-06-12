package it.uniba.nygaard.game.control;

class SetTimeCommandTest {

  private static SetTimeCommand setTimeCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      GameManager.setMatch(new Match());
      Method getInstance = SetTimeCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      setTimeCommand = (SetTimeCommand) getInstance.invoke(null);
      execute = setTimeCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /tempo");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setInGame(false);
  }

  @Test
  @DisplayName("/tempo senza argomenti")
  void testSetTimeCommandWithoutArgument() {
    String[] args = new String[]{"/tempo"};
    try {
      execute.invoke(setTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: "
        + "/tempo <tempo in minuti>" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tempo con troppi argomenti")
  void testSetTimeCommandWithTooManyArgument() {
    String[] args = new String[]{"/tempo", "2", "stringa"};
    try {
      execute.invoke(setTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: "
        + "/tempo <tempo in minuti>" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tempo con un argomento di tipo stringa")
  void testSetTimeCommandWithStringArgument() {
    String[] args = new String[]{"/tempo", "stringaqualsiasi"};
    try {
      execute.invoke(setTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Tempo inserito non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tempo con un argomento negativo")
  void testSetTimeCommandNegativeArgument() {
    String[] args = new String[]{"/tempo", "-10"};
    try {
      execute.invoke(setTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Tempo inserito non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tempo con un numero più grande di Integer.MAX_VALUE come argomento")
  void testSetTimeCommandOverflowArgument() {
    String[] args = new String[]{"/tempo", String.valueOf((long) Integer.MAX_VALUE + 1)};
    try {
      execute.invoke(setTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Tempo inserito non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tempo con un argomento con zeri iniziali")
  void testSetTimeCommandWithLeadingZeros() {
    String[] args = new String[]{"/tempo", "001"};
    try {
      execute.invoke(setTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Tempo inserito non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tempo in partita")
  void testSetTimeCommandInGame() {
    String[] args = new String[]{"/tempo", "10"};
    GameManager.getMatch().setInGame(true);
    try {
      execute.invoke(setTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Non puoi cambiare il tempo di gioco durante una partita" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tempo con un argomento corretto, controlla output")
  void testSetTimeCommandCorrectOutput() {
    String[] args = new String[]{"/tempo", "10"};
    try {
      execute.invoke(setTimeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.GREEN + "OK" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di operazione effettuata con successo");
  }
}
