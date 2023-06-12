package it.uniba.nygaard.game.control;

class ParamControlTest {

  private static ByteArrayOutputStream outContent;
  private static Method initUI;

  @BeforeAll
  static void setUpAll() {
    try {
      initUI = ParamControl.class.getDeclaredMethod("initUI");
      initUI.setAccessible(true);
    } catch (NoSuchMethodException e) {
      fail("Impossibile testare la classe ParamControl");
    }
    outContent = new ByteArrayOutputStream();
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GeneralControl.setShutDown(UShutdown.NOT_TERMINATION_CODE);
  }

  @Test
  @DisplayName("Avvio del programma con troppi parametri, verifica che venga cambiato lo stato di shutDown")
  void testParamControlWithTooManyArgumentShutdown() {
    GameManager.setArgs(new String[]{"-h", "--help"});
    try {
      initUI.invoke(null);
    } catch (Exception e) {
      System.err.println("testParamControlWithTooManyArgumentShutdown:");
      System.err.println(e.getCause());
      System.err.println("Eccezione dovuta al fatto che dopo il test il metodo in esame aspetta altri input");
      System.err.println("Tale eccezione non compromette l'esito del test ed è stata considerata la sua presenza\n");
    }
    assertEquals(UShutdown.QUIT_TERMINATION_CODE, GeneralControl.getShutDown(),
        "Non è stato impostato il codice di terminazione corretto");
  }

  @Test
  @DisplayName("Avvio del programma con troppi parametri, verifica che venga stampato il messaggio di errore corretto")
  void testParamControlWithTooManyArgumentPrint() {
    GameManager.setArgs(new String[]{"-h", "--help"});
    try {
      initUI.invoke(null);
    } catch (Exception e) {
      System.err.println("testParamControlWithTooManyArgumentPrint:");
      System.err.println(e.getCause());
      System.err.println("Eccezione dovuta al fatto che dopo il test il metodo in esame aspetta altri input");
      System.err.println("Tale eccezione non compromette l'esito del test ed è stata considerata la sua presenza\n");
    }
    String expectedOutput = UColor.RED + "Troppi parametri inseriti.\n"
        + "Premere invio per uscire" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Avvio del programma con parametro non riconosciuto, verifica che venga cambiato lo stato di shutDown")
  void testParamControlWithInvalidArgumentShutdown() {
    GameManager.setArgs(new String[]{"ciao"});
    try {
      initUI.invoke(null);
    } catch (Exception e) {
      System.err.println("testParamControlWithInvalidArgumentShutdown:");
      System.err.println(e.getCause());
      System.err.println("Eccezione dovuta al fatto che dopo il test il metodo in esame aspetta altri input");
      System.err.println("Tale eccezione non compromette l'esito del test ed è stata considerata la sua presenza\n");
    }
    assertEquals(UShutdown.QUIT_TERMINATION_CODE, GeneralControl.getShutDown(),
        "Non è stato impostato il codice di terminazione corretto");
  }

  @Test
  @DisplayName("Avvio del programma con parametro non riconosciuto,"
      + "verifica che venga stampato il messaggio di errore corretto")
  void testParamControlWithInvalidArgumentPrint() {
    GameManager.setArgs(new String[]{"ciao"});
    try {
      initUI.invoke(null);
    } catch (Exception e) {
      System.err.println("testParamControlWithInvalidArgumentPrint:");
      System.err.println(e.getCause());
      System.err.println("Eccezione dovuta al fatto che dopo il test il metodo in esame aspetta altri input");
      System.err.println("Tale eccezione non compromette l'esito del test ed è stata considerata la sua presenza\n");
    }
    String expectedOutput = UColor.RED + "Parametro ciao non riconosciuto.\n"
        + "Premere invio per uscire" + UColor.RESET + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString(StandardCharsets.UTF_8),
        "Non è stato stampato il messaggio di errore corretto");
  }

  @Test
  @DisplayName("Avvio del programma con parametro -h, verifica che non venga cambiato lo stato di shutDown")
  void testParamControlWithArgumentH() {
    GameManager.setArgs(new String[]{"-h"});
    try {
      initUI.invoke(null);
    } catch (Exception e) {
      fail("Impossibile invocare il metodo initUI");
    }
    assertEquals(UShutdown.NOT_TERMINATION_CODE, GeneralControl.getShutDown(),
        "E' stato erroneamente settato il codice di terminazione");
  }

  @Test
  @DisplayName("Avvio del programma con parametro --help, verifica che non venga cambiato lo stato di shutDown")
  void testParamControlWithArgumentHelp() {
    GameManager.setArgs(new String[]{"--help"});
    try {
      initUI.invoke(null);
    } catch (Exception e) {
      fail("Impossibile invocare il metodo initUI");
    }
    assertEquals(UShutdown.NOT_TERMINATION_CODE, GeneralControl.getShutDown(),
        "E' stato erroneamente settato il codice di terminazione");
  }

}
