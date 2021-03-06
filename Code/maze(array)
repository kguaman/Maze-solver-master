import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class maze {
	private Location c;
	private Location e;
	private LocationQueue Loc_qu;

	private char[][] a;

	maze(int startCol, int startRow, int endRow, int endCol, char[][] a) {
		c = new Location(startRow, startCol);
		e = new Location(endRow, endCol);
		
		Loc_qu = new LocationQueue();
		// c is current 
		Loc_qu.insert(c); 
		// add queue add c into queue
		this.a = a;

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		

		String filename;

		System.out.println("enter file");

		filename = getString();
		Scanner in = new Scanner(new File(filename));

		// converts to integer
		int rows = in.nextInt();
		int cols = in.nextInt();
		int startRow = in.nextInt();
		int startCol = in.nextInt();
		int endRow = in.nextInt();
		int endCol = in.nextInt();

		in.nextLine();
		char[][] c = new char[rows][cols];
		for (int i = 0; i < rows; i++)
			c[i] = in.nextLine().toCharArray();
		// for else
		for (char[] row : c)
			System.out.println(Arrays.toString(row));
		in.close();
	}

	public class Location {

		int row;
		int column;

		Location(int row, int col) {
			this.row = row;
			this.column = col;
		}

		int getRowLocation() {
			return row;
		}

		int getColLocation() {
			return column;
		}
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
