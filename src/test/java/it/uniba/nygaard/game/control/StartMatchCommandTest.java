package it.uniba.nygaard.game.control;

class StartMatchCommandTest {

  private static StartMatchCommand startMatchCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      Method getInstance = StartMatchCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      startMatchCommand = (StartMatchCommand) getInstance.invoke(null);
      execute = startMatchCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /gioca");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setInGame(false);
  }
}
