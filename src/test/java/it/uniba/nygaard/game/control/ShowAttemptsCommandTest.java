package it.uniba.nygaard.game.control;

class ShowAttemptsCommandTest {

  private static ShowAttemptsCommand showAttemptsCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      Method getInstance = ShowAttemptsCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      showAttemptsCommand = (ShowAttemptsCommand) getInstance.invoke(null);
      execute = showAttemptsCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /mostratentativi");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.setMatch(new Match());
  }

  @Test
  @DisplayName("/mostratentativi con troppi argomenti")
  void testShowAttemptsCommandWithTooManyArgument() {
    String[] args = new String[]{"/mostratentativi", "stringa"};
    try {
      execute.invoke(showAttemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: /mostratentativi" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Il comando non ha stampato il numero di tentativi corretto");
  }

  @Test
  @DisplayName("/mostratentativi in gioco")
  void testShowAttemptsCommandInGame() {
    String[] args = new String[]{"/mostratentativi"};
    Match match = GameManager.getMatch();
    match.setInGame(true);
    try {
      execute.invoke(showAttemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Hai già effettuato " + UColor.BOLD + match.getUsedAttempts() + " tentativi "
        + UColor.RESET + UColor.CYAN + "di cui " + UColor.BOLD + match.getFailedAttempts() + " falliti." + UColor.RESET
        + System.lineSeparator() + UColor.CYAN + "Puoi fallire al massimo " + UColor.BOLD
        + match.getAttempts(match.getDifficulty()) + " tentativi" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio corretto");
  }

}
