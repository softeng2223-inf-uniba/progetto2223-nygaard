package it.uniba.nygaard.game.control;

class ShowGridCommandTest {

  private static ShowGridCommand revealGridCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      GameManager.setMatch(new Match());
      Method getInstance = ShowGridCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      revealGridCommand = (ShowGridCommand) getInstance.invoke(null);
      execute = revealGridCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare i comandi /mostragriglia e /svelagriglia");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setInGame(true);
  }

}
