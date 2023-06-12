package it.uniba.nygaard.game.control;

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
}
