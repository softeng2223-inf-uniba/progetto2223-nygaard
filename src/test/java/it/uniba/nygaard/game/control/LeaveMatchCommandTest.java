package it.uniba.nygaard.game.control;

class LeaveMatchCommandTest {

  private static LeaveMatchCommand leaveMatchCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;
  private static InputStream inBackup;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    inBackup = System.in;
    try {
      Method getInstance = LeaveMatchCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      leaveMatchCommand = (LeaveMatchCommand) getInstance.invoke(null);
      execute = leaveMatchCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /abbandona");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GeneralControl.setShutDown(UShutdown.NOT_TERMINATION_CODE);
  }

  @Test
  @DisplayName("/abbandona con troppi argomenti")
  void testLeaveMatchCommandWithTooManyArgument() {
    String[] args = new String[]{"/abbandona", "stringa"};
    try {
      execute.invoke(leaveMatchCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: "
        + "/abbandona" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }
}
