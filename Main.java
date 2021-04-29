import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String userInput;
    int userMove;
    Board boardstate = new Board();
    Minimax agent = new Minimax('x');

    while(!boardstate.checkTerminal())
    {
      System.out.println("Make a move: ");
      userMove = scan.nextInt();
      boardstate.setPiece(userMove, 'o');
      boardstate.printBoard();
      agent.makeMove(boardstate);
      boardstate.printBoard();
    }
  }
}