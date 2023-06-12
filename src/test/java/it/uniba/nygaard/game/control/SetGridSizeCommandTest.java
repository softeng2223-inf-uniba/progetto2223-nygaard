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

  @Test
  @DisplayName("Imposta la dimensione già impostata")
  void testSetGridSizeCommandSameSize() {
    String[] args = new String[]{"/standard"};
    try {
      execute.invoke(setGridSizeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Questa dimensione è stata già impostata" + UColor.RESET
        + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio dimensione griglia non confermato")
  void testSetGridSizeCommandNegativeAnswer() {
    ByteArrayInputStream in = new ByteArrayInputStream("n\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    String[] args = new String[]{"/large"};
    try {
      execute.invoke(setGridSizeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Cambio dimensioni della griglia annullato"
        + UColor.RESET + System.lineSeparator();
    assertTrue(outContent.toString(StandardCharsets.UTF_8).contains(expectedOutput),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio dimensione griglia con conferma non valida")
  void testSetGridSizeCommandInvalidAnswer() {
    ByteArrayInputStream in = new ByteArrayInputStream("yn\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    String[] args = new String[]{"/large"};
    try {
      execute.invoke(setGridSizeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      System.err.println("testSetGridSizeCommandInvalidAnswer:");
      System.err.println(e.getCause());
      System.err.println("Eccezione dovuta al fatto che dopo il test il metodo in esame aspetta altri input");
      System.err.println("Tale eccezione non compromette l'esito del test ed è stata considerata la sua presenza\n");
    }
    String expectedOutput = UColor.RED + "Scelta non valida" + UColor.RESET + System.lineSeparator();
    assertTrue(outContent.toString(StandardCharsets.UTF_8).contains(expectedOutput),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Cambio dimensione griglia confermato, verifica l'output")
  void testSetGridSizeCommandAffirmativeAnswerPrint() {
    ByteArrayInputStream in = new ByteArrayInputStream("y\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    String[] args = new String[]{"/large"};
    try {
      execute.invoke(setGridSizeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      System.err.println("testSetGridSizeCommandAffirmativeAnswerPrint:");
      System.err.println(e.getCause());
      System.err.println("Eccezione dovuta al fatto che dopo il test il metodo in esame aspetta altri input");
      System.err.println("Tale eccezione non compromette l'esito del test ed è stata considerata la sua presenza\n");
    }
    String expectedOutput = UColor.GREEN + "OK" + UColor.RESET + System.lineSeparator();
    assertTrue(outContent.toString(StandardCharsets.UTF_8).contains(expectedOutput),
        "Non è stato stampato il messaggio di operazione completata");
  }

  @Test
  @DisplayName("Cambio dimensione griglia confermato, verifica che sia stata impostata la nuova dimensione")
  void testSetGridSizeCommandAffirmativeAnswerSet() {
    ByteArrayInputStream in = new ByteArrayInputStream("y\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    String[] args = new String[]{"/large"};
    try {
      execute.invoke(setGridSizeCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      System.err.println("testSetGridSizeCommandAffirmativeAnswerSet:");
      System.err.println(e.getCause());
      System.err.println("Eccezione dovuta al fatto che dopo il test il metodo in esame aspetta altri input");
      System.err.println("Tale eccezione non compromette l'esito del test ed è stata considerata la sua presenza\n");
    }
    assertEquals(UGrid.LARGE_GRID_SIZE, GameManager.getMatch().getGridSize(),
        "Le dimensioni della griglia non sono state impostate correttamente");
  }
}
