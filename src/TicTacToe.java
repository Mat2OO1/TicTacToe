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
    public static void computerMove(String[] board, String mark, String compMark,int counter){
        Random r = new Random();
        if(counter == 1){
            while(true) {
                int value = r.nextInt(4);
                int move;
                if(value ==0){
                    move =1;
                }
                else if(value==1){
                    move=3;
                }
                else if(value==2){
                    move = 5;
                }
                else{
                    move = 7;
                }
                if (board[move] != mark) {
                    board[move] = compMark;
                    System.out.print("COMPUTER MOVE: " + (value));
                    break;
                }
            }
        }
        else{
            // attack
            if(board[0] == board[1] && board[0] == compMark && !board[2].equals(mark)){
                board[2] = compMark;
                System.out.print("COMPUTER MOVE: 3");
            }
            else if(board[1] == board[2] && board[1] == compMark&& !board[0].equals(mark)){
                board[0] = compMark;
                System.out.print("COMPUTER MOVE: 1");
            }
            else if(board[2] == board[0] && board[0] == compMark && !board[1].equals(mark)){
                board[1] = compMark;
                System.out.print("COMPUTER MOVE: 2");
            }
            else if(board[3] == board[4] && board[3] == compMark && !board[5].equals(mark)){
                board[5] = compMark;
                System.out.print("COMPUTER MOVE: 6");
            }
            else if(board[4] == board[5] && board[4] == compMark && !board[3].equals(mark)){
                board[3] = compMark;
                System.out.print("COMPUTER MOVE: 4");
            }
            else if(board[3] == board[5] && board[3] == compMark&& !board[4].equals(mark)){
                board[4] = compMark;
                System.out.print("COMPUTER MOVE: 5");
            }
            else if(board[6] == board[7] && board[6] == compMark && !board[8].equals(mark)){
                board[8] = compMark;
                System.out.print("COMPUTER MOVE: 9");
            }
            else if(board[6] == board[8] && board[6] == compMark && !board[7].equals(mark)){
                board[7] = compMark;
                System.out.print("COMPUTER MOVE: 8");
            }
            else if(board[7] == board[8] && board[7] == compMark && !board[6].equals(mark)){
                board[6] = compMark;
                System.out.print("COMPUTER MOVE: 7");
            }
            else if(board[0] == board[3] && board[3] == compMark && !board[6].equals(mark)){
                board[6] = compMark;
                System.out.print("COMPUTER MOVE: 8");
            }
            else if(board[3] == board[6] && board[3] == compMark && !board[0].equals(mark)){
                board[0] = compMark;
                System.out.print("COMPUTER MOVE: 1");
            }
            else if(board[0] == board[6] && board[0] == compMark && !board[3].equals(mark)){
                board[3] = compMark;
                System.out.print("COMPUTER MOVE: 5");
            }
            else if(board[1] == board[4] && board[1] == compMark && !board[7].equals(mark)){
                board[7] = compMark;
                System.out.print("COMPUTER MOVE: 8");
            }
            else if(board[1] == board[7] && board[1] == compMark && !board[4].equals(mark)){
                board[4] = compMark;
                System.out.print("COMPUTER MOVE: 5");
            }
            else if(board[4] == board[7] && board[4] == compMark && !board[1].equals(mark)){
                board[1] = compMark;
                System.out.print("COMPUTER MOVE: 2");
            }
            else if(board[2] == board[5] && board[2] == compMark && !board[8].equals(mark)){
                board[8] = compMark;
                System.out.print("COMPUTER MOVE: 9");
            }
            else if(board[2] == board[8] && board[2] == compMark && !board[5].equals(mark)){
                board[5] = compMark;
                System.out.print("COMPUTER MOVE: 6");
            }
            else if(board[0] == board[4] && board[0] == compMark && !board[8].equals(mark)){
                board[8] = compMark;
                System.out.print("COMPUTER MOVE: 9");
            }
            else if(board[4] == board[8] && board[4] == compMark && !board[0].equals(mark)){
                board[0] = compMark;
                System.out.print("COMPUTER MOVE: 1");
            }
            else if(board[0] == board[8] && board[0] == compMark && !board[4].equals(mark)){
                board[4] = compMark;
                System.out.print("COMPUTER MOVE: 5");
            }
            else if(board[6] == board[4] && board[6] == compMark && !board[2].equals(mark)) {
                board[2] = compMark;
                System.out.print("COMPUTER MOVE: 3");
            }
            else if(board[6] == board[2] && board[2] == compMark && !board[4].equals(mark)){
                board[4] = compMark;
                System.out.print("COMPUTER MOVE: 5");
            }
            else if(board[2] == board[4] && board[2] == compMark && !board[6].equals(mark)){
                board[6] = compMark;
                System.out.print("COMPUTER MOVE: 7");
            }
            // defense
            else if(board[0] == board[1] && board[0] == mark && !board[2].equals(compMark)){
                board[2] = compMark;
                System.out.print("COMPUTER MOVE: 3");
            }
            else if(board[1] == board[2] && board[1] == mark&& !board[0].equals(compMark)){
                board[0] = compMark;
                System.out.print("COMPUTER MOVE: 1");
            }
            else if(board[2] == board[0] && board[0] == mark && !board[1].equals(compMark)){
                board[1] = compMark;
                System.out.print("COMPUTER MOVE: 2");
            }
            else if(board[3] == board[4] && board[3] == mark && !board[5].equals(compMark)){
                board[5] = compMark;
                System.out.print("COMPUTER MOVE: 6");
            }
            else if(board[4] == board[5] && board[4] == mark && !board[3].equals(compMark)){
                board[3] = compMark;
                System.out.print("COMPUTER MOVE: 4");
            }
            else if(board[3] == board[5] && board[3] == mark&& !board[4].equals(compMark)){
                board[4] = compMark;
                System.out.print("COMPUTER MOVE: 5");
            }
            else if(board[6] == board[7] && board[6] == mark && !board[8].equals(compMark)){
                board[8] = compMark;
                System.out.print("COMPUTER MOVE: 9");
            }
            else if(board[6] == board[8] && board[6] == mark && !board[7].equals(compMark)){
                board[7] = compMark;
                System.out.print("COMPUTER MOVE: 8");
            }
            else if(board[7] == board[8] && board[7] == mark && !board[6].equals(compMark)){
                board[6] = compMark;
                System.out.print("COMPUTER MOVE: 7");
            }
            else if(board[0] == board[3] && board[3] == mark && !board[6].equals(compMark)){
                board[6] = compMark;
                System.out.print("COMPUTER MOVE: 8");
            }
            else if(board[3] == board[6] && board[3] == mark && !board[0].equals(compMark)){
                board[0] = compMark;
                System.out.print("COMPUTER MOVE: 1");
            }
            else if(board[0] == board[6] && board[0] == mark && !board[3].equals(compMark)){
                board[3] = compMark;
                System.out.print("COMPUTER MOVE: 5");
            }
            else if(board[1] == board[4] && board[1] == mark && !board[7].equals(compMark)){
                board[7] = compMark;
                System.out.print("COMPUTER MOVE: 8");
            }
            else if(board[1] == board[7] && board[1] == mark && !board[4].equals(compMark)){
                board[4] = compMark;
                System.out.print("COMPUTER MOVE: 5");
            }
            else if(board[4] == board[7] && board[4] == mark && !board[1].equals(compMark)){
                board[1] = compMark;
                System.out.print("COMPUTER MOVE: 2");
            }
            else if(board[2] == board[5] && board[2] == mark && !board[8].equals(compMark)){
                board[8] = compMark;
                System.out.print("COMPUTER MOVE: 9");
            }
            else if(board[2] == board[8] && board[2] == mark && !board[5].equals(compMark)){
                board[5] = compMark;
                System.out.print("COMPUTER MOVE: 6");
            }
            else if(board[0] == board[4] && board[0] == mark && !board[8].equals(compMark)){
                board[8] = compMark;
                System.out.print("COMPUTER MOVE: 9");
            }
            else if(board[4] == board[8] && board[4] == mark && !board[0].equals(compMark)){
                board[0] = compMark;
                System.out.print("COMPUTER MOVE: 1");
            }
            else if(board[0] == board[8] && board[0] == mark && !board[4].equals(compMark)){
                board[4] = compMark;
                System.out.print("COMPUTER MOVE: 5");
            }
            else if(board[6] == board[4] && board[6] == mark && !board[2].equals(compMark)) {
                board[2] = compMark;
                System.out.print("COMPUTER MOVE: 3");
            }
            else if(board[6] == board[2] && board[2] == mark && !board[4].equals(compMark)){
                board[4] = compMark;
                System.out.print("COMPUTER MOVE: 5");
            }
            else if(board[2] == board[4] && board[2] == mark && !board[6].equals(compMark)){
                board[6] = compMark;
                System.out.print("COMPUTER MOVE: 7");
            }
            else{
                while(true) {
                    int value = r.nextInt(9);
                    if (board[value] != mark) {
                        board[value] = compMark;
                        System.out.print("COMPUTER MOVE: " + (value+1));
                        break;
                    }
                }
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
                        computerMove(board, mark, compMark,counter);
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
