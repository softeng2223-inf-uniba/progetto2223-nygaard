package it.uniba.nygaard.game.entity.ships;

class ShipTest {

  private Ship ship;
  private CellsGrid grid;
  private static Coordinate coord;
  private static Random rnd;

  @BeforeAll
  static void setUpAll() {
    coord = new Coordinate();
    rnd = new Random();
  }

  @BeforeEach
  void setUp() {
    ship = new Ship(rnd.nextInt(UShip.BATTLESHIP_HP) + UShip.DESTROYER_HP);
    grid = new CellsGrid(UGrid.STANDARD_GRID_SIZE);
    rnd.setSeed(System.currentTimeMillis());
  }

  @RepeatedTest(value = UShip.MAX_SHIP, name = "{displayName}: Test {currentRepetition} di {totalRepetitions}")
  @DisplayName("Nave orizzontale fuori dalla griglia")
  void testOutOfMapHorizontal() {
    ship.setDirection(UShip.HORIZONTAL);
    coord.setRow(UGrid.MIN_ROWS);
    coord.setColumn((char) (UGrid.MIN_COLUMN + UGrid.STANDARD_GRID_SIZE - ship.getHp() + 1));
    ship.setCoord(coord);
    assertTrue(ship.outOfMap(grid), "Nave orizzontale fuori dalle colonne non rilevata");
  }

  @RepeatedTest(value = UShip.MAX_SHIP, name = "{displayName}: Test {currentRepetition} di {totalRepetitions}")
  @DisplayName("Nave verticale fuori dalla griglia")
  void testOutOfMapVertical() {
    ship.setDirection(UShip.VERTICAL);
    coord.setRow(UGrid.MIN_ROWS + UGrid.STANDARD_GRID_SIZE - ship.getHp() + 1);
    coord.setColumn(UGrid.MIN_COLUMN);
    ship.setCoord(coord);
    assertTrue(ship.outOfMap(grid), "Nave verticale fuori dalle righe non rilevata");
  }

  @RepeatedTest(value = UShip.MAX_SHIP, name = "{displayName}: Test {currentRepetition} di {totalRepetitions}")
  @DisplayName("Nave orizzontale nella griglia")
  void testInMapHorizontal() {
    ship.setDirection(UShip.HORIZONTAL);
    coord.setRow(rnd.nextInt(UGrid.STANDARD_GRID_SIZE) + 1);
    coord.setColumn((char) (rnd.nextInt(UGrid.STANDARD_GRID_SIZE - ship.getHp()) + UGrid.MIN_COLUMN));
    ship.setCoord(coord);
    assertFalse(ship.outOfMap(grid), "Nave orizzontale nella griglia non rilevata");
  }

  @RepeatedTest(value = UShip.MAX_SHIP, name = "{displayName}: Test {currentRepetition} di {totalRepetitions}")
  @DisplayName("Nave verticale nella griglia")
  void testInMapVertical() {
    ship.setDirection(UShip.VERTICAL);
    coord.setRow(rnd.nextInt(UGrid.STANDARD_GRID_SIZE - ship.getHp()) + 1);
    coord.setColumn((char) (rnd.nextInt(UGrid.STANDARD_GRID_SIZE) + UGrid.MIN_COLUMN));
    ship.setCoord(coord);
    assertFalse(ship.outOfMap(grid), "Nave verticale nella griglia non rilevata");
  }

}
