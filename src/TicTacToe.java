import javax.sound.midi.spi.SoundbankReader;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void printBoard(String[] board){
        for(int i =0; i< board.length; i++){
            if(i%3 == 0){
                System.out.println();
                System.out.println("|---|---|---|");

            }
            System.out.print("| " + board[i] + " ");
            if((i+1)%3 == 0){
                System.out.print("|");

            }
        }
    }
    public static boolean addMove(String[] board, String mark, String move){
        if(Integer.parseInt(move) < 10) {
            if (!board[Integer.parseInt(move) - 1].equals(mark)) {
                board[Integer.parseInt(move) - 1] = mark;
                return true;
            } else {
                System.out.println("INCORRECT MOVE, THAT POSITION HAVE ALREADY BEEN TAKEN!");
                System.out.println("PLEASE, TRY AGAIN");
                return false;

            }
        }
        else{
            System.out.println("INCORRECT MOVE, THAT POSITION HAVE ALREADY BEEN TAKEN!");
            System.out.println("PLEASE, TRY AGAIN");
            return false;
        }
    }
    public static void computerMove(String[] board, String mark, String compMark){
        Random r = new Random();
        while(true) {
            int value = r.nextInt(9);
            if (board[value] != mark) {
                board[value] = compMark;
                System.out.print("COMPUTER MOVE: " + (value +1));
                break;
            }
        }

    }
    public static void printMessage(String boardMark, String mark){
        if(boardMark.equals(mark)){
            System.out.println("YOU WIN!");
        }
        else{
            System.out.println("COMPUTER WINS!");
        }
    }
    public static boolean checkWinner(String[] board, int counter, String mark){
        boolean win = true;
        if(board[0] == board[1] && board[1] == board[2]){
            printMessage(board[1],mark);
        }
        else if(board[3] == board[4] && board[4] == board[5]){
            printMessage(board[4],mark);
        }
        else if(board[6] == board[7] && board[7] == board[8]){
            printMessage(board[7],mark);
        }
        else if(board[0] == board[3] && board[3] == board[6]){
            printMessage(board[3],mark);
        }
        else if(board[0] == board[3] && board[3] == board[6]){
            printMessage(board[3],mark);
        }
        else if(board[1] == board[4] && board[4] == board[7]){
            printMessage(board[1],mark);
        }
        else if(board[2] == board[5] && board[5] == board[8]){
            printMessage(board[5],mark);
        }
        else if(board[0] == board[4] && board[4] == board[8]){
            printMessage(board[4],mark);
        }
        else if(board[2] == board[4] && board[4] == board[6]){
            printMessage(board[4],mark);
        }
        else if(counter == 9){
            System.out.println("IT'S A TIE!!!");
        }
        else{
            win = false;
        }

        if(win){
            printBoard(board);
        }
        return win;
    }
    public static void main(String[] args) {
        String[] board = new String[9];
        int counter = 0;
        for(int i=0; i<board.length; i++){
            board[i] = String.valueOf(i+1);
        }
        System.out.println("WELCOME TO TICTACTOE GAME");
        System.out.print("CHOOSE YOUR MARK: ");
        Scanner sc = new Scanner(System.in);
        String mark = sc.nextLine();
        System.out.print("CHOOSE COMPUTER'S MARK: ");
        String compMark = sc.nextLine();
        String move;
        System.out.println("YOU CHOSE: " + mark + "!");
        System.out.println("HERE IS YOUR BOARD, IN ORDER TO MAKE A MOVE ");
        System.out.print("TYPE A NUMBER RESPONDING TO THE POSITION ON THE BOARD");
        while(true){
            printBoard(board);
            System.out.println();
            System.out.print("YOUR MOVE: ");
            move = sc.nextLine();
            if(addMove(board,mark,move)){
                counter++;
                System.out.println("COUNTER=" + counter);
                if(!checkWinner(board,counter,mark)) {
                    if (counter < 9) {
                        computerMove(board, mark, compMark);
                        counter++;
                        System.out.println("COUNTER=" + counter);
                        if(checkWinner(board,counter,mark)){
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                else{
                    break;
                }
            }


        }


    }
}
