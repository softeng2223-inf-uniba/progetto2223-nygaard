package it.uniba.nygaard.game.entity;

class MatchTest {

  private static Match match;
  private CellsGrid defenseGrid;
  private Ship[] ships;

  @BeforeAll
  static void setUpAll() {
    match = new Match();
  }

  @BeforeEach
  void setUp() {
    defenseGrid = new CellsGrid(UGrid.STANDARD_GRID_SIZE);
    CharactersGrid attackGrid = new CharactersGrid(UGrid.STANDARD_GRID_SIZE);
    ships = new Ship[UShip.MAX_SHIP];
    int n = UShip.MIN_SHIP;
    for (ShipType ship : ShipType.values()) {
      for (int j = 0; j < ship.getNumShips(); j++) {
        ships[n - 1] = new Ship(ship.getHp());
        n++;
      }
    }
    try {
      Field f1 = match.getClass().getDeclaredField("defenseGrid");
      f1.setAccessible(true);
      f1.set(match, defenseGrid);
      Field f2 = match.getClass().getDeclaredField("attackGrid");
      f2.setAccessible(true);
      f2.set(match, attackGrid);
      Field f3 = match.getClass().getDeclaredField("ships");
      f3.setAccessible(true);
      f3.set(match, ships);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      fail("Impossibile testare la classe Match");
    }
  }

  @RepeatedTest(value = UShip.MAX_SHIP, name = "{displayName}: Test {currentRepetition} di {totalRepetitions}")
  @DisplayName("Piazzamento delle navi nella griglia")
  void testInitializeShip() {
    assertTrue(match.initializeShips(UShip.MIN_SHIP), "Le navi non sono state piazzate correttamente");
  }

}
