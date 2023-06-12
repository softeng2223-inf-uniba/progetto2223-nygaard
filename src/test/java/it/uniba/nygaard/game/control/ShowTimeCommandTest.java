package it.uniba.nygaard.game.control;

class ShowTimeCommandTest {

  private static ShowTimeCommand showTimeCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() throws NoSuchMethodException {
    outContent = new ByteArrayOutputStream();
    try {
      GameManager.setMatch(new Match());
      Method getInstance = ShowTimeCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      showTimeCommand = (ShowTimeCommand) getInstance.invoke(null);
      execute = showTimeCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      fail("Impossibile testare il comando /mostratempo");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setInGame(true);
  }
}
