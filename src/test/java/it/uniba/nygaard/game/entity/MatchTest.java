package it.uniba.nygaard.game.entity;

import it.uniba.nygaard.game.entity.grids.CellsGrid;
import it.uniba.nygaard.game.entity.grids.CharactersGrid;
import it.uniba.nygaard.game.entity.ships.Ship;
import it.uniba.nygaard.game.entity.ships.ShipType;
import it.uniba.nygaard.game.utility.UGrid;
import it.uniba.nygaard.game.utility.UResult;
import it.uniba.nygaard.game.utility.UShip;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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

  @Test
  @DisplayName("Colpo fuori dalle righe della griglia")
  void testHitRowOutOfBound() {
    assertThrows(IndexOutOfBoundsException.class, () -> match.hit(UGrid.EXTRA_LARGE_GRID_SIZE, 0),
        "Effettuato colpo fuori dalle righe della griglia");
  }

  @Test
  @DisplayName("Colpo fuori dalle colonne della griglia")
  void testHitColumnOutOfBound() {
    assertThrows(IndexOutOfBoundsException.class, () -> match.hit(0, UGrid.EXTRA_LARGE_GRID_SIZE),
        "Effettuato colpo fuori dalle colonne della griglia");
  }

  @Test
  @DisplayName("Colpo con una riga negativa")
  void testHitNegativeRow() {
    assertThrows(IndexOutOfBoundsException.class, () -> match.hit(-1, 0),
        "Effettuato colpo con una riga negativa");
  }

  @Test
  @DisplayName("Colpo con una colonna negativa")
  void testHitNegativeColumn() {
    assertThrows(IndexOutOfBoundsException.class, () -> match.hit(0, -1),
        "Effettuato colpo con una colonna negativa");
  }

  @Test
  @DisplayName("Colpo su acqua, verifica l'esito del colpo")
  void testHitWater() {
    assumeTrue(match.initializeShips(UShip.MIN_SHIP));
    for (int i = 0; i < UGrid.STANDARD_GRID_SIZE; i++) {
      for (int j = 0; j < UGrid.STANDARD_GRID_SIZE; j++) {
        if (defenseGrid.getCellCharacter(i, j) == UGrid.SEA_CHARACTER) {
          assertEquals(UResult.WATER_CODE, match.hit(i, j), "Colpo in acqua non rilevato");
          i = UGrid.STANDARD_GRID_SIZE;
          j = UGrid.STANDARD_GRID_SIZE;
        }
      }
    }
  }

  @Test
  @DisplayName("Colpo su acqua, verifica l'incremento dei tentativi falliti")
  void testHitFailedWater() {
    assumeTrue(match.initializeShips(UShip.MIN_SHIP));
    for (int i = 0; i < UGrid.STANDARD_GRID_SIZE; i++) {
      for (int j = 0; j < UGrid.STANDARD_GRID_SIZE; j++) {
        if (defenseGrid.getCellCharacter(i, j) == UGrid.SEA_CHARACTER) {
          int previous = match.getFailedAttempts();
          match.hit(i, j);
          assertEquals(previous + 1, match.getFailedAttempts(),
              "Tentativo fallito per acqua non rilevato");
          i = UGrid.STANDARD_GRID_SIZE;
          j = UGrid.STANDARD_GRID_SIZE;
        }
      }
    }
  }

  @Test
  @DisplayName("Colpo doppio sulla stessa cella di una nave, verifica l'esito del colpo")
  void testDoubleHitShip() {
    assumeTrue(match.initializeShips(UShip.MIN_SHIP));
    for (int i = 0; i < UGrid.STANDARD_GRID_SIZE; i++) {
      for (int j = 0; j < UGrid.STANDARD_GRID_SIZE; j++) {
        if (defenseGrid.getCellCharacter(i, j) == UGrid.SHIP_CHARACTER) {
          match.hit(i, j);
          assertEquals(UResult.WATER_CODE, match.hit(i, j), "Tentativo fallito per colpo doppio non rilevato");
          i = UGrid.STANDARD_GRID_SIZE;
          j = UGrid.STANDARD_GRID_SIZE;
        }
      }
    }
  }

  @Test
  @DisplayName("Colpo doppio sulla stessa cella di una nave, verifica l'incremento dei tentativi falliti")
  void testHitFailedDouble() {
    assumeTrue(match.initializeShips(UShip.MIN_SHIP));
    for (int i = 0; i < UGrid.STANDARD_GRID_SIZE; i++) {
      for (int j = 0; j < UGrid.STANDARD_GRID_SIZE; j++) {
        if (defenseGrid.getCellCharacter(i, j) == UGrid.SHIP_CHARACTER) {
          int previous = match.getFailedAttempts();
          match.hit(i, j);
          match.hit(i, j);
          assertEquals(previous + 1, match.getFailedAttempts(),
              "Tentativi falliti non aggiornati correttamente");
          i = UGrid.STANDARD_GRID_SIZE;
          j = UGrid.STANDARD_GRID_SIZE;
        }
      }
    }
  }

  @Test
  @DisplayName("Colpo su una nave")
  void testHitShip() {
    assumeTrue(match.initializeShips(UShip.MIN_SHIP));
    for (int i = 0; i < UGrid.STANDARD_GRID_SIZE; i++) {
      for (int j = 0; j < UGrid.STANDARD_GRID_SIZE; j++) {
        if (defenseGrid.getCellCharacter(i, j) == UGrid.SHIP_CHARACTER) {
          assertEquals(UResult.HITTED_CODE, match.hit(i, j), "Nave colpita non rilevata");
          i = UGrid.STANDARD_GRID_SIZE;
          j = UGrid.STANDARD_GRID_SIZE;
        }
      }
    }
  }

  @Test
  @DisplayName("Colpo che affonda una nave")
  void testHitSank() {
    assumeTrue(match.initializeShips(UShip.MIN_SHIP));
    for (int i = 0; i < UGrid.STANDARD_GRID_SIZE; i++) {
      for (int j = 0; j < UGrid.STANDARD_GRID_SIZE; j++) {
        if (defenseGrid.getCellCharacter(i, j) == UGrid.SHIP_CHARACTER) {
          if (ships[defenseGrid.getCellShipIndex(i, j)].getHp() == 1) {
            assertEquals(UResult.SANK_CODE, match.hit(i, j), "Nave affondata non rilevata");
          } else {
            match.hit(i, j);
          }
        }
      }
    }
  }

  @Test
  @DisplayName("Controlla che una partita vinta sia rilevata come vittoria")
  void testWin() {
    int sankedShips = 0;
    assumeTrue(match.initializeShips(UShip.MIN_SHIP));
    for (int i = 0; i < UGrid.STANDARD_GRID_SIZE; i++) {
      for (int j = 0; j < UGrid.STANDARD_GRID_SIZE; j++) {
        if (defenseGrid.getCellCharacter(i, j) == UGrid.SHIP_CHARACTER) {
          if (match.hit(i, j) == UResult.SANK_CODE) {
            sankedShips++;
            if (sankedShips == UShip.MAX_SHIP) {
              assertTrue(match.win(), "Vittoria non rilevata");
            }
          }
        }
      }
    }
  }

  @Test
  @DisplayName("Controlla che una partita non vinta non sia rilevata come vittoria")
  void testNotWin() {
    assertFalse(match.win(), "Vittoria rilevata erroneamente");
  }

}
