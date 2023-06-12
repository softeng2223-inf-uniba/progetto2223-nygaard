package it.uniba.nygaard.game.control;

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
}
