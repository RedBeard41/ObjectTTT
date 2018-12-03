package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main  {

    /*@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String statement = "";
        gameState state = gameState.PLAYING;
        Player player1 = new Player("Player 1", new GamePiece(Seed.PLAYER1));
        Player player2 = new Player("Player 2", new GamePiece(Seed.PLAYER2));

        while(state == gameState.PLAYING){
        System.out.println("Enter the size of board that you would like");
        int size = keyboard.nextInt();
        Board board = new Board(size, size);
        board.init();
        player1.init(board);
        player2.init(board);

        int maxTurns = board.getRows() * board.getCols();


        Player currentPlayer;
        Cell cell;

        int currentturn = 0;

        do {
            currentPlayer = currentturn % 2 == 0 ? player1 : player2;
            int row = -1, col = -1;
            boolean goodMove = false;
            boolean movePossible = false;

            board.print();

            while (!goodMove || !movePossible) {

                System.out.println(currentPlayer.getName() + " make your selection (row, column)");
                System.out.print("Row: ");
                row = keyboard.nextInt();
                row--;
                System.out.print("Column: ");
                col = keyboard.nextInt();
                col--;

                if (!board.validMove(row, col)) {
                    System.out.println("That is not a valid move");
                    goodMove = false;
                } else {
                    goodMove = true;

                    if (!board.isAvailable(row, col)) {
                        System.out.println("That position is already taken");
                        movePossible = false;
                    } else {
                        movePossible = true;
                    }
                }

                //System.out.println("Good move: "+ goodMove+ " Possible Move: "+ movePossible);


            }


            cell = board.cells[row][col];
            board.placePiece(row, col, currentPlayer.getPiece());

            currentturn++;

            if (board.checkWin(cell)) {
                statement = "The winner is " + currentPlayer.getName();
                currentPlayer.setScore(2);
            } else if (board.isDraw()) {
                statement = "The cat won";
                player1.setScore(1);
                player2.setScore(1);

            }


            System.out.println("\n\n\n\ncurrent turns: "+ currentturn + " statement: "+ statement + " cat: "+ board.isDraw() + " winner: "+ board.checkWin(cell));
            System.out.println("player 1 score: "+ player1.getScore() + " player 2 score: "+ player2.getScore()+"\n" +
                    (currentturn < maxTurns && !board.checkWin(cell) && !board.isDraw())+"\n\n\n");

        } while (currentturn < maxTurns && !board.checkWin(cell) && !board.isDraw());

        System.out.println(statement);
        System.out.println("Current Score");
        System.out.println("Player 1: " + player1.getScore());
        System.out.println("Player 2: " + player2.getScore());

        System.out.println("Would you like to play again (Y/N)\n\n");
        String answer = keyboard.nextLine();
        keyboard.nextLine();

        state = answer.equalsIgnoreCase("y") ? gameState.PLAYING : gameState.DONE;


    }

    }


}
