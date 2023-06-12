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

  @Test
  @DisplayName("/tentativi con un numero negativo come argomento")
  void testAttemptsCommandWithNegativeArgument() {
    String[] args = new String[]{"/tentativi", "-10"};
    try {
      execute.invoke(attemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Numero di tentativi non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tentativi con un numero più grande di Integer.MAX_VALUE come argomento")
  void testAttemptsCommandWithOverflowArgument() {
    String[] args = new String[]{"/tentativi", String.valueOf((long) Integer.MAX_VALUE + 1)};
    try {
      execute.invoke(attemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Numero di tentativi non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tentativi con un numero che inizia con zeri come argomento")
  void testSetTimeCommandWithLeadingZeros() {
    String[] args = new String[]{"/tentativi", "001"};
    try {
      execute.invoke(attemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Numero di tentativi non valido" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tentativi in partita")
  void testAttemptsCommandInGame() {
    String[] args = new String[]{"/tentativi", "10"};
    GameManager.getMatch().setInGame(true);
    try {
      execute.invoke(attemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.RED + "Non puoi cambiare il numero di tentativi durante una partita"
        + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("/tentativi corretto, verifica l'output")
  void testAttemptsCommandCorrectOutput() {
    String[] args = new String[]{"/tentativi", "10"};
    try {
      execute.invoke(attemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    String expectedOutput = UColor.GREEN + "OK" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di operazione andata a buon fine");
  }

  @Test
  @DisplayName("/tentativi corretto, verifica che i tentativi di tutte le difficoltà siano stati modificati")
  void testAttemptsCommandModifiedAttempts() {
    String[] args = new String[]{"/tentativi", String.valueOf(UDifficulty.EASY_ATTEMPTS)};
    try {
      execute.invoke(attemptsCommand, (Object) args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo executeCommand");
    }
    int[] actualAttempts = {GameManager.getMatch().getAttempts(UDifficulty.DIFFICULTY_EASY),
        GameManager.getMatch().getAttempts(UDifficulty.DIFFICULTY_MEDIUM),
        GameManager.getMatch().getAttempts(UDifficulty.DIFFICULTY_HARD)};
    int[] expectedAttempts = {UDifficulty.EASY_ATTEMPTS, UDifficulty.EASY_ATTEMPTS, UDifficulty.EASY_ATTEMPTS};
    assertArrayEquals(expectedAttempts, actualAttempts,
        "Il numero di tentativi non è stato modificato correttamente");
  }
}
