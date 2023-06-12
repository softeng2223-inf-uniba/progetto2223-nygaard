package it.uniba.nygaard.game.control;

class AttemptsCommandTest {

  private static AttemptsCommand attemptsCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      GameManager.setMatch(new Match());
      Method getInstance = AttemptsCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      attemptsCommand = (AttemptsCommand) getInstance.invoke(null);
      execute = attemptsCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /tentativi");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setInGame(false);
  }

  @Test
  @DisplayName("/tentativi senza argomenti")
  void testAttemptsCommandWithoutArgument() {
    String[] args = new String[]{"/tentativi"};
    try {
      execute.invoke(attemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: "
        + "/tentativi <numero tentativi>" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tentativi con troppi argomenti")
  void testAttemptsCommandWithTooManyArgument() {
    String[] args = new String[]{"/tentativi", "stringa", "stringa"};
    try {
      execute.invoke(attemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: "
        + "/tentativi <numero tentativi>" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tentativi con una stringa come argomento")
  void testAttemptsCommandWithStringArgument() {
    String[] args = new String[]{"/tentativi", "stringaqualsiasi"};
    try {
      execute.invoke(attemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Numero di tentativi non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }
}
