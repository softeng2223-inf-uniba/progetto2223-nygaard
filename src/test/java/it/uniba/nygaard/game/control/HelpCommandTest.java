package it.uniba.nygaard.game.control;

class HelpCommandTest {

  private static HelpCommand helpCommand;
  private static Method execute;
  private static ByteArrayOutputStream outContent;

  @BeforeAll
  static void setUpAll() {
    outContent = new ByteArrayOutputStream();
    try {
      Method getInstance = HelpCommand.class.getDeclaredMethod("getInstance");
      getInstance.setAccessible(true);
      helpCommand = (HelpCommand) getInstance.invoke(null);
      execute = helpCommand.getClass().getDeclaredMethod("executeCommand", String[].class);
      execute.setAccessible(true);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      fail("Impossibile testare il comando /help");
    }
  }

  @BeforeEach
  void setUp() {
    outContent.reset();
    System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
  }
}
