import java.util.Random;
import java.util.Scanner;
import java.awt.Toolkit;

public class App {

    public int sizeBoard = 5;

    public void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if( board[i][j] == 'B'){
                    System.out.print("[B]");
                } else{
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    public static void shuffleBombs(int[][] board, int nBombs) {
        Random rand = new Random();
        int installedBombs = 0;
        while (installedBombs < nBombs) {
            int row = rand.nextInt(board.length);
            int column = rand.nextInt(board[0].length);
            if (board[row][column] != 'B') {
                board[row][column] = 'B';
                installedBombs++;
            }
        }
        System.out.println("Installed bombs "+ installedBombs);
    }
    public static void awaitBomb() throws InterruptedException{
        Toolkit.getDefaultToolkit().beep();
        System.out.println("...");
        Thread.sleep(500);
        Toolkit.getDefaultToolkit().beep();
        System.out.println("..");
        Thread.sleep(500);
        Toolkit.getDefaultToolkit().beep();
        System.out.println(".");
    }

    public static void boombTrue() throws InterruptedException{
        System.out.println("BOOM!!!");
        Toolkit.getDefaultToolkit().beep();
        Thread.sleep(50);
        Toolkit.getDefaultToolkit().beep();
        Thread.sleep(50);
        Toolkit.getDefaultToolkit().beep();
        Thread.sleep(50);
        Toolkit.getDefaultToolkit().beep();
        Thread.sleep(50);
        Toolkit.getDefaultToolkit().beep();
        Thread.sleep(1000);
        System.out.println("GAME OVER!!!");
        Thread.sleep(1000);
    }

    public static void menuGame() {
        System.out.println("Welcome to the game of beards");
        System.out.println("Choose your level");
        System.out.println("1 - For first beards (Easy)");
        System.out.println("2 - For mustaches (Medium)");
        System.out.println("3 - For beard of develop (Hard)");
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        try (Scanner scanner = new Scanner(System.in)) {
            int[][] board = new int[app.sizeBoard][app.sizeBoard];
            int nBombs = 10;
            int level = 0;
            menuGame();
            level = scanner.nextInt();
            switch (level) {
                case 1:
                    nBombs = 10;
                    break;
                case 2:
                    nBombs = 15;
                    break;
                case 3:
                    nBombs = 20;
                    break;
                default:
                    System.out.println("Good, for beard of highlander, level 4");
                    nBombs = 24;
                    break;
            }
            shuffleBombs(board, nBombs);
            boolean gameOver = false;
            while (!gameOver) {
                System.out.println("Row: ");
                int row = scanner.nextInt();
                System.out.println("Column: ");
                int column = scanner.nextInt();
                App.awaitBomb();
                if (row >= 0 && row < app.sizeBoard && column >= 0 && column < app.sizeBoard) {
                    if (board[row][column] == 'B') {
                        App.boombTrue();
                        app.printBoard(board);
                        gameOver = true;
                    } else {
                        System.out.println("In the next you will die bastard");
                    }
                } else {
                    System.out.println("Choose wisely");
                }
            }
        }
    }
}
