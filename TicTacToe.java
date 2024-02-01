import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printBoard();
        System.out.println("this is my only lo3ba attentcione la copyrayti ");

        System.out.println("le voila la referencia -->  ");
        System.out.println("-------------------");
        System.out.println("| 0 0 | 0 1 | 0 2 |");
        System.out.println("-------------------");
        System.out.println("| 1 0 | 1 1 | 1 2 |");
        System.out.println("-------------------");
        System.out.println("| 2 0 | 2 1 | 2 2 |");
        System.out.println("-------------------");
        System.out.println("Let's start the lo3ba:");

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (isWinner()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean isWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
