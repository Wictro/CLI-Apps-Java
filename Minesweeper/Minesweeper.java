import java.util.Scanner;
public class Minesweeper
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int row, col, steps;
		
		int[][] backTable = new int[10][10];
		int bombs = MineOps.createBackTable(backTable);
		//MineOps.printTest(backTable);
		char[][] Table = MineOps.createTable();
		
		String flush;
		System.out.print("Welcome to Minesweeper. In each round you'll select the row and column that you want to reveal.\nPress Enter to start:");
		flush = scan.nextLine();
		
		MineOps.print(Table);
		steps = 0;
		row = MineOps.promptRow(Table);
		col = MineOps.promptCol(Table);
		
		while(backTable[row-1][col-1] >= 0)
		{
			if(Table[row-1][col-1] == '.')
			{
			steps += MineOps.reveal(Table, backTable, row, col);
			MineOps.print(Table);
			System.out.println(steps);
			}
			else
			{
				System.out.println("That slot is already opened!");
			}
			
			if(steps != 100 - bombs)
			{
			row = MineOps.promptRow(Table);
			col = MineOps.promptCol(Table);
			}
			else
				break;
		}	
		
		if(steps != 100 - bombs)
		{
			System.out.println("");
			System.out.println("GAME OVER! YOU LOST!");
			MineOps.reveal(Table, backTable);
			MineOps.print(Table);
		}
		else
		{
			System.out.println("");
			System.out.println("CONGRATULATIONS! YOU WON!");
			MineOps.reveal(Table, backTable);
			MineOps.print(Table);
		}
	}
}