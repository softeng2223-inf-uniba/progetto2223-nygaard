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

}
