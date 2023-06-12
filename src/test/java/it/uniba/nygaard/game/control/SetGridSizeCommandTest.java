package it.uniba.nygaard.game.control;

class SetGridSizeCommandTest {

  private static SetGridSizeCommand setGridSizeCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;
  private static InputStream inBackup;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    inBackup = System.in;
    try {
      GameManager.setMatch(new Match());
      Method getInstance = SetGridSizeCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      setGridSizeCommand = (SetGridSizeCommand) getInstance.invoke(null);
      execute = setGridSizeCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare i comandi /standard, /large ed /extralarge");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setGridSize(UGrid.STANDARD_GRID_SIZE);
    GameManager.getMatch().setInGame(false);
  }
}
