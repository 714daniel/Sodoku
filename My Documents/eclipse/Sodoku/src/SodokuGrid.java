import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SodokuGrid {
    private int length;
    private static int[][] grid;
    public static ArrayList<Integer> squares;
    private static int[][] subSquares;

    public SodokuGrid(int length) {
        this.length = length;
        grid = new int[length][length];
        squares = new ArrayList<Integer>();
    }

    public SodokuGrid(int[][] grid) {
    this.grid = grid;
    squares = new ArrayList<Integer>();
    this.length = 9;
}

    public void fillGrid(File f) throws FileNotFoundException {

        Scanner sc = new Scanner(f);
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                grid[x][y] = sc.nextInt();
            }
        }
        sc.close();
        subSquares = solveSubSquares();


    }

    public int[][] getGrid() {
        return grid;

    }

    public int getNum(int x, int y) {
        return grid[x][y];
    }

    public int getLength() {
        return length;
    }

    public int[][] getSubSquares() {
        return subSquares;
    }
    public SodokuGrid setTo(int x, int y, int val) {
        grid[x][y] = val;
        return this;
    }

    public boolean tryWith(int x, int y, int val) {
        int getXsub = x;
        int getYsub = y;
        int ss = 0;
        while (getXsub - 3 > 0 || getYsub - 3 > 0) {
            if (getXsub - 3 > 0) {
                getXsub -= 3;
                ss++;
            } else if (getYsub - 3 > 0) {
                getYsub -= 3;
                ss += 3;
            }
        }
        boolean unique = true;
        for (int x1 = 0; x1 < length; x1++) {
            if (grid[x1][y] == val && x1 != x)
                return false;
        }

        for (int y1 = 0; y1 < length; y1++) {
            if (grid[x][y1] == val && y1 != y)
                return false;
        }

        return true;

    }

    public int[][] solveSubSquares() {
        int x = 0;

        for (int y = 0; y < 9; y++) {
            squares.add(grid[x % 3][y]);
            x++;
            squares.add(grid[x % 3][y]);
            x++;
            squares.add(grid[x % 3][y]);
            x++;
        }

        for (int y = 0; y < 9; y++) {
            squares.add(grid[x % 3 + 3][y]);
            x++;
            squares.add(grid[x % 3 + 3][y]);
            x++;
            squares.add(grid[x % 3 + 3][y]);
            x++;
        }

        for (int y = 0; y < 9; y++) {
            squares.add(grid[x % 3 + 6][y]);
            x++;
            squares.add(grid[x % 3 + 6][y]);
            x++;
            squares.add(grid[x % 3 + 6][y]);
            x++;
        }
        int[][] subSquares = new int[9][9];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int v = 0; v < 9; v++) {
                subSquares[i][v] = squares.get(index);
                index++;
            }
        }

        return subSquares;
    }
    public boolean isValid() {
    return true;
    }


}



