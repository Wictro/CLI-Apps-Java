class Player{
	String emri;
	char sign;
	boolean isWinner;
	
	public Player(int rendi){
		emri = Dialogue.setName(rendi);
		sign = (rendi == 1)? 'X' : 'O';
		isWinner = false;
	}
	
	public String getName(){
		return emri;
	}
	
	public boolean isWinner(){
		return isWinner;
	}
	
	public char getSign(){
		return sign;
	}
	
	public boolean equals(Player p){
		return this.emri.equals(p.getName());
	}
	
	public void makeWinner(){
		isWinner = true;
	}
	
	public String toString(){
		return emri;
	}
}
