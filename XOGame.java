import java.util.Scanner;

public class XOGame {

    char[][] board;
    int size;
    char PlayerX;

    char PlayerO;
    int row;
    int col;

    public XOGame() {
        size = 3;
        board = new char[size][size];
        PlayerX = 'X';
        PlayerO = 'O';
        row = 0;
        col = 0;
    }

    public  void PrintBoard() {
        for (int i = 0; i < size; i++) {
            System.out.println("-------------");
            for (int j = 0; j < size; j++)
                System.out.print(("|") + board[i][j] + ("|") + ("\t"));
            System.out.println();
        }
        System.out.println("-------------");
    }

    public boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '\u0000') && (c1 == c2) && (c2 == c3));
    }


    public boolean RowsWinnerCheck() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean ColumnsWinnerCheck() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }


    public boolean DiangonalWinnerCheck() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }

    public boolean WinnerCheck() {
        return (RowsWinnerCheck() || ColumnsWinnerCheck() || DiangonalWinnerCheck());

    }

    public boolean isDraw() {
        boolean IsDraw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\u0000') {
                    IsDraw = false;
                }
            }
        }
        return IsDraw;
    }

    public void PlayersEntry() {
        System.out.println("PlayerX Enter position to play row and column");
        Scanner input = new Scanner(System.in);
        row = input.nextInt() - 1;
        col = input.nextInt() - 1;
        board[row][col] = PlayerX;
        PrintBoard();
        if (isDraw() && !WinnerCheck()) {
            return;
        } else if (WinnerCheck()) {
            System.out.println("The Winner is PlayerX");
            return;
        }

        System.out.println("PlayerO Enter position to play row and column");
        row = input.nextInt() - 1;
        col = input.nextInt() - 1;
        board[row][col] = PlayerO;
        PrintBoard();
        if (WinnerCheck()) {
            System.out.println("The Winner is PlayerO");
            return;
        }
    }


    public static void main(String[] args) {
        boolean PlayAgain=false;
        Scanner input=new Scanner(System.in);
        do {
            System.out.println("New Game Starting");
            XOGame G1 = new XOGame();
            G1.PrintBoard();
            do {
                G1.PlayersEntry();
            } while (!G1.WinnerCheck() && !G1.isDraw());
            if (G1.isDraw() && !G1.WinnerCheck()) {
                System.out.println("The game was a tie!");
            }
            System.out.println("If you want to play again enter 1 or Enter any number to Exit");
            int Again=input.nextInt();
            if (Again==1) {
                PlayAgain = true;
            }else {PlayAgain=false;
            break;}
        }while (PlayAgain=true);
    }
}