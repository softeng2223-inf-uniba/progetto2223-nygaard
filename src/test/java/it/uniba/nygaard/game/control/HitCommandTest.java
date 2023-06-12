package it.uniba.nygaard.game.control;

class HitCommandTest {

  private static HitCommand hitCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;
  private static InputStream inBackup;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    inBackup = System.in;
    try {
      Method getInstance = HitCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      hitCommand = (HitCommand) getInstance.invoke(null);
      execute = hitCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando colpo");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GeneralControl.setShutDown(UShutdown.NOT_TERMINATION_CODE);
    GameManager.getMatch().setInGame(true);
  }
}
