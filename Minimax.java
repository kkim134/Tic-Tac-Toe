import java.util.ArrayList;

class Minimax extends Ai {
  Minimax(char marker)
  {
    this.marker = marker;
  }

  public void makeMove(Board boardstate) {
    char[] board = boardstate.getBoard();
    double v = Double.NEGATIVE_INFINITY;
    int bestMove = 0;
    ArrayList<Integer> possibleMoves = new ArrayList<Integer>();

    for (int i = 0; i < 9; i++)
    {
      if (board[i] == '-')
      {
        possibleMoves.add(i);
      }
    }

    double current;
    for (int i = 0; i < possibleMoves.size(); i++)
    {
      char[] nextState = board.clone();
      nextState[possibleMoves.get(i)] = marker;
      current = bestMove(nextState, false);
      System.out.println("EV of " + current + " at " + possibleMoves.get(i));
      if (current > v)
      {
        v = current;
        bestMove = possibleMoves.get(i);
      }
    }
    
    boardstate.setPiece(bestMove, this.marker);
    
  }

  public double bestMove(char[] board, boolean max) {
    ArrayList<Integer> possibleMoves = new ArrayList<Integer>();

    for (int i = 0; i < 9; i++)
    {
      if (board[i] == '-')
        possibleMoves.add(i);
    }

    if (checkWin(board, this.marker))
    {
      return 10.0;
    }
    if (checkWin(board, 'o'))
      return -10.0;
    if (possibleMoves.size() == 0)
    {
      return 0;
    }

    if (max)
    {
      double v = Double.NEGATIVE_INFINITY;
      for (int i = 0; i < possibleMoves.size(); i++)
      {
        char[] nextState = board.clone();
        nextState[possibleMoves.get(i)] = marker;
        v = Math.max(v, bestMove(nextState, false));
        
      }
      return v;
    }

    else
    {
      double v = Double.POSITIVE_INFINITY;
      // double v = 0.0;
      // double p = 1/possibleMoves.size();

      for (int i = 0; i < possibleMoves.size(); i++)
      {
        char[] nextState = board.clone();
        nextState[possibleMoves.get(i)] = 'o';
        v = Math.min(v, bestMove(nextState, true));
        // v += p*bestMove(nextState, true);
      }
      return v;
    }

    
  }
}