import java.util.Scanner;
/*
 TicTacToe - Linyun Yu - CIS 35A
 */
//stalemate method
//cross check easier ways with play and won method

public class TicTacToe {
    private char[][] board = new char[4][4];
    private char player; // 'X' or 'O'

    /*
     * Instantiate board to be a 3 by 3 char array of spaces.
     * Set player to be 'X'.
     */
    public TicTacToe() {
        // set initial player value to an 'X'
        player = 'X' ;

        //loop through each index of 3x3 arr to set equal to a space
		for (int rows=0; rows < board.length; rows++){
		    for (int columns=0; columns < board[rows].length; columns++){
		        board[rows][columns] = ' ';
            }
        }
        //board[0][0] = ' ';
        //board [1][1] = ' ';
        //board [2][2] = ' ';
    }

    /*
     * If s represents a valid move, add the current player's symbol to the board and return true.
     * Otherwise return false.
     */
    public boolean play(String s) {
        //convert our String "ABC" into two sets of integers: 123 (ABC) and 123(for 123 char)
        int ABC = (int)(s.charAt(0) - 65);  //convert letter ABC into number
        int valueOfInt = (int)(s.charAt(1) - 49);//convert letter 123 into number

        System.out.println(ABC + " " + valueOfInt);

        if (ABC < 0 & ABC > 2 & valueOfInt < 0 & valueOfInt > 2){
            return false;
        }
        else if (board[ABC][valueOfInt] != ' '){
            return false;
        }

            board[ABC][valueOfInt] = player;
            return true;

    }

    /*
     * Switches the current player from X to O, or O to X.
     */
    public void switchTurn() {
        //Logic: if my player's value is set to 'x', change it to O and vice versa
        if (player == 'O') {
            player = 'X';
        } else {
            player = 'O';
        }
    }

    /*
     * Returns true if the current player has won the game.
     * Three in a row, column or either diagonal.
     * Otherwise, return false.
     */
    public boolean won() {
		/* Step 5: Fill in the code for the won method. This method
        * should return true if the current player has 3 in-a-row
		* in any row, column or diagonal. Otherwise, return false.
		*/
        //do column win first:
        for (int col = 0; col < board.length; col ++ ) {
            if (player != ' ' & board[0][col] == player & board[1][col] == player & board[2][col] == player)
            return true;
         }
        //do row win
        for (int row = 0; row < board.length; row ++ ) {
            if (player != ' ' & board[row][0] == player & board[row][1] == player & board[row][2] == player)
                return true;
        }

        //ASK AN EASIER WAY TO DO THIS
        //do diagonal win top left to bottom right
        for (int row = 0; row < board.length; row ++ ) {
            for (int col= 0 ; col < board[row].length; col++){
                //top left to bottom right
            if (player != ' ' & board[0][0] == player & board[1][1] == player & board[2][2] == player)
                return true;
             //top right to bottom left
            else if (player != ' ' & board[0][2] == player & board[1][1] == player & board[2][0] == player)
                return true;
            }
        }
        return false; // TODO: replace with your own return statement.
    }

        /*
		 * Logic: use a for loop to go through each and every
		 * spot in the table. If it doesn't have space, return false with an error
*/      //  boolean isFull = true;
    /*
     * Returns true if there are no places left to move
     *///
    public boolean stalemate() {
        for (int rows = 0; rows < board.length; rows ++ ) {
            for (int col = 0; col < board[rows].length; col++) {
                if (board[rows][col] == ' ') {
                    return false; //return false if there is space available
                }
            }
        }
        return true;   // return true if stalemate
        }

    public char getPlayer()
        {
        return player;
    }
    public void print() {
        System.out.println();
        System.out.println("\t  1 2 3");
        System.out.println();
        System.out.println("\tA "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
        System.out.println("\t  -----");
        System.out.println("\tB "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
        System.out.println("\t  "+"-----");
        System.out.println("\tC "+board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
        System.out.println();
    }

	/*
	 * Step 6: Main Method for Final Step - Delete your main method
	 * and uncomment this one.
	 * Runs the game by getting input from the user, making the
	 * appropriate moves, and prints who won or if it was a stalemate.
	*/

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		System.out.println("Welcome to tic-tac-toe");
		System.out.println("Enter coordinates for your move following the X and O prompts");

		while(!game.stalemate()) {
			//Print the game
            game.print();


            //Prompt player for their move
            System.out.print(game.getPlayer() + ": ");
            String move = input.nextLine();
            move = move.toUpperCase();

            //Loop while the method play does not return true when given their move.
            //Body of loop should ask for a different move
            while (!game.play(move)) {
                System.err.print("That is an invalid move. Enter another one: ");
                move = input.nextLine();
               move = move.toUpperCase();
            }
            //If the game is won, call break;
         //   if (game.won())
           //     break;

            //Switch the turn
            game.switchTurn();
		}
		game.print();
		//if(game.won()){
			//System.out.println("Player "+game.getPlayer()+" Wins!!!!");
		//} else {
			System.out.println("Stalemate");
		}
	}



