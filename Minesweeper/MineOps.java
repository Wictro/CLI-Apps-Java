//mines are -1;
import java.util.*;
class MineOps
{
	private static void add(int[][] arr, int row, int col) //adds 1 to the surrounding stuff if theyre positive or equal to zer0 (works only for rectangular arr)
	{
		boolean left, right;
		left = (col - 1 >= 0);
		if(left && arr[row][col-1] >= 0){arr[row][col-1]++;}
				
		right = (col + 1 < arr[row].length);
		if(right && arr[row][col+1] >= 0){arr[row][col+1]++;}
				
		if(row-1 >= 0)
		{
			if(arr[row-1][col] >= 0){arr[row-1][col]++;}
					
			if(left && arr[row-1][col-1] >= 0)
			{
				arr[row-1][col-1]++;
			}
					
			if(right && arr[row-1][col+1] >= 0)
			{
				arr[row-1][col+1]++;
			}
		}
				
		if(row+1 < arr.length)
		{
			if(arr[row+1][col] >= 0){arr[row+1][col]++;}
					
			if(left && arr[row+1][col-1] >= 0)
			{
				arr[row+1][col-1]++;
			}
					
			if(right && arr[row+1][col+1] >= 0)
			{
				arr[row+1][col+1]++;
			}
		}
	}
	
	public static int createBackTable(int[][] arr)
	{
		Random random = new Random();
		int x = 0;
		
		//arr = new int[10][10];
		//the size and other stuff may depend on the parameters given in the method
		//we'll assume that 10% of the table will be full of mines
		for(int row = 0; row < arr.length; row++)
		{
			for(int col = 0; col < arr[row].length; col++)
			{
				if((random.nextInt(100)+1) <= 10)
				{
					arr[row][col] = -1;
					add(arr, row, col);
					x++;
				}
			}
		}
		
		return x;
	}
	
	public static char[][] createTable()
	{
		char[][] arr = new char[10][10]; //the size and other stuff may depend on the parameters given in the method
		for(int row = 0; row < arr.length; row++)
		{
			for(int col = 0; col < arr[row].length; col++)
			{
				arr[row][col] = '.';
			}
		}
		
		return arr;
	}
	
	public static void print(char[][] arr)
	{
		for(int row = 0; row < arr.length; row++)
		{
			for(int col = 0; col < arr[row].length; col++)
			{
				System.out.print(arr[row][col] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public static void printTest(int[][] arr)
	{
		for(int row = 0; row < arr.length; row++)
		{
			for(int col = 0; col < arr[row].length; col++)
			{
				if(arr[row][col] >= 0){System.out.print(arr[row][col] + " ");}
				else{System.out.print("* ");}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public static int promptRow(char[][] arr)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Select Row: ");
		int x = scan.nextInt();
		String flush = scan.nextLine();
		
		while(x <= 0 || x > arr.length)
		{
			System.out.println("Enter Valid Row!");
			System.out.print("Select Row: ");
			x = scan.nextInt();
			flush = scan.nextLine();
		}
		return x;
	}
	
	public static int promptCol(char[][] arr)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Select Column: ");
		int x = scan.nextInt();
		String flush = scan.nextLine();
		
		while(x <= 0 || x > arr.length)
		{
			System.out.println("Enter Valid Column!");
			System.out.print("Select Column: ");
			x = scan.nextInt();
			flush = scan.nextLine();
		}
		return x;
	}
	
	private static int revealX(char[][] Table, int[][] backTable, int row, int col){
		
		int x = 0;
		Table[row][col] = '0';
		x++;
		//start with up
		if(row-1 >= 0 && Table[row-1][col] == '.')
		{
			if(backTable[row-1][col] == 0)
			{
				x += revealX(Table, backTable, row-1, col);
			}
			else
			{
				Table[row-1][col] = (new Integer(backTable[row-1][col])).toString().charAt(0);
				x++;
			}
		}
		//now right
		if(col+1 <= 9 && Table[row][col+1] == '.')
		{
			if(backTable[row][col+1] == 0)
			{
				x += revealX(Table, backTable, row, col+1);
			}
			else
			{
				Table[row][col+1] = (new Integer(backTable[row][col+1])).toString().charAt(0);
				x++;
			}
		}
		//now down
		if(row+1 <= 9 && Table[row+1][col] == '.')
		{
			if(backTable[row+1][col] == 0)
			{
				x += revealX(Table, backTable, row+1, col);
			}
			else
			{
				Table[row+1][col] = (new Integer(backTable[row+1][col])).toString().charAt(0);
				x++;
			}
		}
		//now left
		if(col-1 >= 0 && Table[row][col-1] == '.')
		{
			if(backTable[row][col-1] == 0)
			{
				x += revealX(Table, backTable, row, col-1);
			}
			else
			{
				Table[row][col-1] = (new Integer(backTable[row][col-1])).toString().charAt(0);
				x++;
			}
		}
		return x;
	}
	
	public static int reveal(char[][] Table, int[][] backTable, int row, int col)
	{
		row--;
		col--;
		if(backTable[row][col] != 0){
			Table[row][col] = (new Integer(backTable[row][col])).toString().charAt(0);
			return 1;
		}
		else{
			return revealX(Table, backTable, row, col);
		}
	}
	
	public static void reveal(char[][] Table, int[][] backTable)
	{
		for(int row = 0; row < backTable.length; row++)
		{
			for(int col = 0; col < backTable[row].length; col++)
			{
				if(backTable[row][col] < 0)
				{
					Table[row][col] = 'X';
				}
				else
				{
					Table[row][col] = '.';
				}
			}
		}
		
		return;
	}
}