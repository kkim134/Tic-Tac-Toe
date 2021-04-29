class Board {
  private char board[];

  public Board() {
    this.board = new char[] 
    {'-','-','-',
     '-','-','-',
     '-','-','-'};
  }

  public char[] getBoard() {
    return this.board;
  }

  public void setPiece(int ind, char marker) {
    this.board[ind] = marker;
  }

  public void printBoard() {
    for (int i = 0; i < 3; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        System.out.print(this.board[3*i+j] + "\t");
      }
      System.out.print("\n");
    }
  }

  public boolean checkTerminal() {
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
          if (board[ind[i][0]] == 'x' || board[ind[i][0]] == 'o')
          {
            return true;
          }
        }
    }
    
    for (int i = 0; i < 9; i++)
    {
      if (this.board[i] == '-')
        return false;
    }

    return true;
  }

  

  // public int[] getValidMoves() {
  //   for (int i = 0; i < 8; i++)
  //   {
  //     if (this.board[i] == '-') {
        
  //     }
  //   }
  // }
}