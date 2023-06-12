package it.uniba.nygaard.game.control;

class GeneralControlTest {

  private static Method initCommands;
  private static Method startGame;
  private static ByteArrayOutputStream outContent;
  private static InputStream inBackup;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    inBackup = System.in;
    try {
      Method method = GeneralControl.class.getDeclaredMethod("getInstance");
      method.setAccessible(true);
      GeneralControl generalControl = (GeneralControl) method.invoke(null);
      initCommands = generalControl.getClass().getDeclaredMethod("initCommands");
      initCommands.setAccessible(true);
      startGame = generalControl.getClass().getDeclaredMethod("startGame", String[].class);
      startGame.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare la classe GeneralControl");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
  }

  @Test
  @DisplayName("Controlla dell'esistenza dell'HashMap dei comandi")
  void testAvailableCommand() {
    Object r = null;
    try {
      r = initCommands.invoke(null);
    } catch (IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile invocare il metodo initCommands");
    }
    assertNotNull(r, "La lista dei comandi non è stata inizializzata correttamente");
  }

  @ParameterizedTest(name = "Inserimento del comando {0} nell'HashMap")
  @ValueSource(strings = {"/esci", "/facile", "/medio", "/difficile", "/mostralivello", "/mostranavi",
      "/gioca", "/svelagriglia", "/help", "/tempo", "/mostratempo", "/mostratentativi", "/standard",
      "/large", "/extralarge", "/tentativi", "/abbandona", "/mostragriglia"})
  @DisplayName("Inserimento dei comandi nell'HashMap")
  void testCommandList(final String command) {
    HashMap<?, ?> r = null;
    try {
      r = ((HashMap<?, ?>) initCommands.invoke(null));
    } catch (Exception e) {
      fail("Impossibile invocare il metodo initCommands");
    }
    assumeTrue(r != null, "La lista dei comandi non è stata inizializzata correttamente");
    try {
      assertNotNull(r.get(command), "Il comando " + command + " non è stato inizializzato");
    } catch (Exception e) {
      fail("Il comando" + command + " non è stato inizializzato");
    }
  }

  @Test
  @DisplayName("Esecuzione di un comando non presente nell'HashMap")
  void testGeneralControlInvalidCommand() {
    ByteArrayInputStream in = new ByteArrayInputStream("/ciao\n".getBytes(StandardCharsets.UTF_8));
    System.setIn(in);
    try {
      startGame.invoke(null, (Object) new String[]{});
    } catch (IllegalAccessException | InvocationTargetException e) {
      System.err.println("testGeneralControlInvalidCommand:");
      System.err.println(e.getCause());
      System.err.println("Eccezione dovuta al fatto che dopo il test il metodo in esame aspetta altri input");
      System.err.println("Tale eccezione non compromette l'esito del test ed è stata considerata la sua presenza\n");
    }
    String expectedOutput = UColor.RED + "Comando non riconosciuto: /ciao" + UColor.RESET + System.lineSeparator();
    assertTrue(outContent.toString(StandardCharsets.UTF_8).contains(expectedOutput),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @AfterEach
  void tearDown() {
    System.setIn(inBackup);
  }

}
