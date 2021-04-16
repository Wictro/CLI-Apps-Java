import java.util.Scanner;
class Dialogue{
	Scanner scan;
	static Scanner scan2;
	
	public Dialogue(){
		scan = new Scanner(System.in);
		scan2 = new Scanner(System.in);
	}
	
	public void greet(){
		System.out.println("Kjo eshte loja Tic-Tac-Toe. Lojtaret luajne me rradhe derisa njeri ka fituar apo tabela eshte mbushur.");
	}
	
	public static String setName(int rendi){
		System.out.print("Shenoni emrin e lojtarit " + rendi + ": ");
		return scan2.nextLine().trim();
	}
	
	public void alert(){
		System.out.println("Levizje e palejuar!");
	}
	
	public int getRow(){
		System.out.print("Shenoni rreshtin: ");
		return scan.nextInt() - 1;
	}
	
	public int getColumn(){
		System.out.print("Shenoni kolonen: ");
		return scan.nextInt() - 1;
	}
	
	public void noWinner(){
		System.out.println("Loja ka perfunduar pa fitues!");
	}
	
	public void winner(Player p){
		System.out.println("Loja ka perfunduar. Fituesi eshte: " + p.getName());
	}
}