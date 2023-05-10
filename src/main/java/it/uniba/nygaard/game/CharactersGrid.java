package it.uniba.nygaard.game;

public class CharactersGrid extends Grid {

  char[][] grid;

  public CharactersGrid(int dimension) {
    super(dimension);
    grid = new char[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        grid[i][j] = '~';
      }
    }
  }

  void setCharacter(int row, int column, char character) {
    grid[row][column] = character;
  }

  char getCharacter(int row, int column) {
    return grid[row][column];
  }

}
