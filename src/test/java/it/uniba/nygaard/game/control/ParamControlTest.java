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

}
