package it.uniba.nygaard.game.control;

class ExitCommandTest {

  private static ExitCommand exitCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;
  private static InputStream inBackup;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    inBackup = System.in;
    try {
      Method getInstance = ExitCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      exitCommand = (ExitCommand) getInstance.invoke(null);
      execute = exitCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /esci");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GeneralControl.setShutDown(UShutdown.NOT_TERMINATION_CODE);
  }

  @Test
  @DisplayName("/esci con troppi argomenti")
  void testExitCommandWithTooManyArgument() {
    String[] args = new String[]{"/esci", "stringa", "inutile"};
    try {
      execute.invoke(exitCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.CYAN + "Il comando dovrebbe essere usato come segue: "
        + "/esci" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/esci non confermato")
  void testExitCommandNegativeAnswer() {
    ByteArrayInputStream in = new ByteArrayInputStream("n\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    String[] args = new String[]{"/esci"};
    try {
      execute.invoke(exitCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Uscita dall'applicazione annullata" + UColor.RESET
        + System.lineSeparator();
    assertTrue(outContent.toString(StandardCharsets.UTF_8).contains(expectedOutput),
        "Non è stata stampata la frase prevista per l'operazione annullata");
  }

  @Test
  @DisplayName("/esci confermato, verifica l'output")
  void testExitCommandAffirmativeAnswerOutput() {
    ByteArrayInputStream in = new ByteArrayInputStream("y\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    String[] args = new String[]{"/esci"};
    try {
      execute.invoke(exitCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.YELLOW + UColor.BOLD + "GRAZIE PER AVER GIOCATO!" + UColor.RESET
        + System.lineSeparator();
    assertTrue(outContent.toString(StandardCharsets.UTF_8).contains(expectedOutput),
        "Non è stata stampata la frase prevista per l'uscita dal gioco");
  }
}
