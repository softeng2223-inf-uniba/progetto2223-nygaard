package it.uniba.nygaard.game;

public class Match {
  private boolean inGame;
  private int difficulty;
  private String[] difficultyNames;

  private final int[] attempts;

  Match()
  {
    this.inGame=false;
    this.difficulty=Util.DIFFICULTY_NOT_SETTED;
    this.difficultyNames=new String[]{Util.EASY_NAME,Util.MEDIUM_NAME,Util.HARD_NAME};
    this.attempts = new int[]{Util.EASY_ATTEMPTS, Util.MEDIUM_ATTEMPTS, Util.HARD_ATTEMPTS};
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
