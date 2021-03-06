import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SodokuBruteForceTest {
	public static ArrayList<Integer> zer = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException {
		SodokuGrid s = new SodokuGrid(9);
		File f = new File(
				"My Documents\\eclipse\\Sodoku\\src\\sodokuProb.txt");


		s.fillGrid(f);
		System.out.println((getSolutionFinal(s, printSolutions(s))));
		//System.out.println(Arrays.deepToString(s.getSubSquares()));
	}

	public static boolean[][][] solve(SodokuGrid s) {
		// Already known grid info
		int[][] grid = s.getGrid();
		// Stores true if loc at x,y can hold value
		boolean[][][] possible = new boolean[s.getLength()][s.getLength()][s
				.getLength() + 1];
		for (int x = 0; x < s.getLength(); x++) {
			for (int y = 0; y < s.getLength(); y++) {
				if (grid[x][y] == 0) {
				zer.add(x * 9 + y);
						for (int tryAll = 1; tryAll <= s.getLength(); tryAll++) {
						possible[x][y][tryAll] = s.tryWith(x, y, tryAll);
					}
				}
			}
		}

		return possible;
	}

	public static ArrayList<ArrayList<Integer>> printSolutions(SodokuGrid s) {
		ArrayList<ArrayList<Integer>> solu = new ArrayList<ArrayList<Integer>>();
		boolean[][][] sol = solve(s);
		for (int x = 0; x < s.getLength(); x++) {
			for(int y = 0; y < s.getLength(); y++) {
					if(s.getNum(x,y) == 0) {
					solu.add(new ArrayList<Integer>());
						for(int i = 1; i<10; i++) {
						if(sol[x][y][i])
							solu.get(solu.size() - 1).add(i);
					}
				System.out.println();
				}
			}
		}

	return solu;
	}

	public static ArrayList<SodokuGrid> getSolutionFinal(SodokuGrid s,java.util.ArrayList<java.util.ArrayList<java.lang.Integer>> solu ) {


	ArrayList<SodokuGrid> s1 = new ArrayList <SodokuGrid>();
		return getRecSolution(s, solu, 0, s1);
	}

	public static ArrayList<SodokuGrid> getRecSolution(SodokuGrid s,ArrayList<ArrayList<Integer>> solu, int zeroInd, ArrayList<SodokuGrid> s1      ) {
		if(zeroInd == solu.size()) {
				System.out.println("yes");
					return s1;
			}
		ArrayList<Integer> newPos = new ArrayList<Integer>();
		for(Integer i:solu.get(zeroInd)) {
			if (s.tryWith(zer.get(zeroInd) & 9, zer.get(zeroInd) / 9, i)) {
				System.out.println(zeroInd);
			newPos.add(i);
			}
		}
		return 	s1.addAll(getRecSolution(s.setTo(zer.get(zeroInd) % 9, zer.get(zeroInd) / 9, i), solu, zeroInd, s1));;
	}

}
