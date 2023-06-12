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
}
