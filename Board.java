class Board {
  char board[][];

  public Board() {
    this.board = new char[][] 
    {{'-','-','-'},
     {'-','-','-'},
     {'-','-','-'}};
  }

  public void printBoard() {
    for (int i = 0; i < 3; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        System.out.print(this.board[i][j] + "\t");
      }
      System.out.print("\n");
    }
  }
}