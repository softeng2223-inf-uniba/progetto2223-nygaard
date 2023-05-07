package it.uniba.nygaard.game;

public class Match {
  private boolean inGame;
  private int difficulty;

  Match()
  {
    this.inGame=false;
    this.difficulty=Util.DIFFICULTY_NOT_SETTED;
  }

  void setDifficuly(int difficulty)
  {
    if (this.inGame) {
      System.out.println("Non puoi cambiare difficoltà durante una partita");
      return;
    }
    if (this.difficulty==difficulty){
      System.out.println("Hai già impostato questa difficoltà");
      return;
    }
  }
}
