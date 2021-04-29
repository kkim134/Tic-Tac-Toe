public abstract class Ai {
  char marker;
  public boolean checkWin(char[] board, char marker) {
      int[][] ind = 
      {{0, 1, 2}, 
      {3, 4, 5}, 
      {6, 7, 8},
      {0, 3, 6},
      {1, 4, 7},
      {2, 5, 8},  
      {0, 4, 8},
      {2, 4, 6}};

      for (int i = 0; i < 8; i++)
      {
        if (board[ind[i][0]] == board[ind[i][1]] && board[ind[i][1]] == board[ind[i][2]])
        {
          if (board[ind[i][0]] == marker)
            return true;
          else
            return false;
        }
    }
    return false;
  }
  abstract void makeMove(Board boardstate);
}