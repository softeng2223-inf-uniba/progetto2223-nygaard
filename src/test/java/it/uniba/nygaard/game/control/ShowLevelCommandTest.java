package it.uniba.nygaard.game.control;

class ShowLevelCommandTest {

  private static ShowLevelCommand showLevelCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      GameManager.setMatch(new Match());
      Method getInstance = ShowLevelCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      showLevelCommand = (ShowLevelCommand) getInstance.invoke(null);
      execute = showLevelCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /mostralivello");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
  }

}
