import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SodokuGrid {
	private int length;
	private static Integer[][] grid;

	public SodokuGrid(int length) {
		this.length = length;
		grid = new Integer[length][length];
	}

	public void fillGrid(File f) throws FileNotFoundException {

		Scanner sc = new Scanner(f);
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < length; y++) {
				grid[x][y] = sc.nextInt();
			}
		}
		sc.close();
	}

	public Integer[][] getGrid() {
		return grid;

	}

	public static int getNum(int x, int y) {
		return grid[x][y];
	}
	public int getLength() {
		return length;
	}
	
	public boolean tryWith(int x, int y, int val) {
		for(int x1 = 0; x1<length; x1++) {
			if (grid[x1] [y] == val && x1 !=x)
				return false;
		}
		
		for(int y1 = 0; y1<length; y1++) {
			if (grid[x] [y1] == val && y1 !=y)
				return false;
		}
		return true;
	}
}
