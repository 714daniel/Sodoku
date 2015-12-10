import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class SodokuBruteForceTest {
	public static void main(String[] args) throws FileNotFoundException {
		SodokuGrid s = new SodokuGrid(5);
		File f = new File(
				"H:\\My Documents\\eclipse\\Sodoku\\src\\sodokuProb.txt");
		s.fillGrid(f);
		printSolutions(s);
	}

	public static boolean[][][] solve(SodokuGrid s) {
		// Already known grid info
		Integer[][] grid = s.getGrid();
		// Stores true if loc at x,y can hold value
		boolean[][][] possible = new boolean[s.getLength()][s.getLength()][s
				.getLength() + 1];
		for (int x = 0; x < s.getLength(); x++) {
			for (int y = 0; y < s.getLength(); y++) {
				if (grid[x][y] == 0) {
					for (int tryAll = 1; tryAll <= s.getLength(); tryAll++) {
						possible[x][y][tryAll] = s.tryWith(x, y, tryAll);
					}
				}
			}
		}

		return possible;
	}

	public static void printSolutions(SodokuGrid s) {
		boolean[][][] sol = solve(s);
		for (int i = 0; i < s.getLength(); i++) {
			System.out.println(Arrays.deepToString(sol[i]));
		}

	}
}
