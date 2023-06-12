package it.uniba.nygaard.game.control;

class SetGridSizeCommandTest {

  private static SetGridSizeCommand setGridSizeCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;
  private static InputStream inBackup;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    inBackup = System.in;
    try {
      GameManager.setMatch(new Match());
      Method getInstance = SetGridSizeCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      setGridSizeCommand = (SetGridSizeCommand) getInstance.invoke(null);
      execute = setGridSizeCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare i comandi /standard, /large ed /extralarge");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setGridSize(UGrid.STANDARD_GRID_SIZE);
    GameManager.getMatch().setInGame(false);
  }

  @Test
  @DisplayName("Cambio dimensione griglia con troppi argomenti")
  void testSetGridSizeCommandWithTooManyArgument() {
    String[] args = new String[]{"/large", "stringa"};
    try {
      execute.invoke(setGridSizeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: "
        + "/large" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio dimensione griglia in partita")
  void testSetGridSizeCommandInGame() {
    String[] args = new String[]{"/large"};
    GameManager.getMatch().setInGame(true);
    try {
      execute.invoke(setGridSizeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Non puoi cambiare le dimensioni della griglia durante una partita"
        + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }
}
