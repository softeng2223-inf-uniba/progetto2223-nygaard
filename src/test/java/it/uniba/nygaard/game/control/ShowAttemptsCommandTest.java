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

}
