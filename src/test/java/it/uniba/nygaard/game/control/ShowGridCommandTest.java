package it.uniba.nygaard.game.control;

class ShowGridCommandTest {

  private static ShowGridCommand revealGridCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      GameManager.setMatch(new Match());
      Method getInstance = ShowGridCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      revealGridCommand = (ShowGridCommand) getInstance.invoke(null);
      execute = revealGridCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare i comandi /mostragriglia e /svelagriglia");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setInGame(true);
  }

  @Test
  @DisplayName("/mostragriglia con troppi argomenti")
  void testShowAttackGridCommandWithTooManyArgument() {
    String[] args = new String[]{"/mostragriglia", "stringa"};
    try {
      execute.invoke(revealGridCommand, (Object) args);
    } catch (Exception e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: /mostragriglia" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/svelagriglia con troppi argomenti")
  void testShowDefenseGridCommandWithTooManyArgument() {
    String[] args = new String[]{"/svelagriglia", "stringa"};
    try {
      execute.invoke(revealGridCommand, (Object) args);
    } catch (Exception e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: /svelagriglia" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

}
