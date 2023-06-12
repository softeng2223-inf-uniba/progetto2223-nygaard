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

}
