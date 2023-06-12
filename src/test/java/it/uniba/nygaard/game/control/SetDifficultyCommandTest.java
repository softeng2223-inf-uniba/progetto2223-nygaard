package it.uniba.nygaard.game.control;

class SetDifficultyCommandTest {

  private static SetDifficultyCommand setDifficultyCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;
  private static InputStream inBackup;


  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    inBackup = System.in;
    try {
      GameManager.setMatch(new Match());
      Method getInstance = SetDifficultyCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      setDifficultyCommand = (SetDifficultyCommand) getInstance.invoke(null);
      execute = setDifficultyCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare i comandi /facile, /medio e /difficile");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
    GameManager.getMatch().setDifficulty(UDifficulty.DIFFICULTY_MEDIUM);
    GameManager.getMatch().setInGame(false);
  }
}
