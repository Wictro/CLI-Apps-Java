class Board{
	char[][] elements;
	short takenSlots;
	
	public Board(){
		elements = new char[3][3];
		this.fill(elements);
		
		takenSlots = 0;
	}
	
	private void fill(char[][] matrix){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				matrix[i][j] = '*';
			}
		}
	}
	
	public void display(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(elements[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean isFull(){
		return takenSlots >= 9;
	}
	
	private boolean isValidPosition(int row, int col){
		if(row >= 3 || col >= 3)
			return false;
		if(elements[row][col] != '*')
			return false;
		return true;
	}
	
	public void move(Player player, Dialogue speaker){
		System.out.println("Rradha e " + player.getName());
		
		int row, col;
		
		while(true){
			row = speaker.getRow();
			col = speaker.getColumn();
			if(isValidPosition(row, col)){
				elements[row][col] = player.getSign();
				takenSlots++;
				System.out.println();
				break;
			}
			else{
				speaker.alert();
			}
		}
		
		evaluate(player, row, col);
	}
	
	public void evaluate(Player player, int row, int col){
		int counter = 0;
		char sign = player.getSign();
		
		//row check
		for(int j = 0; j < 3; j++){
			if(elements[row][j] == sign)
				counter++;
		}
		if(counter == 3){
			player.makeWinner();
			return;
		}
		else{
			counter = 0;
		}
		
		//column check
		for(int j = 0; j < 3; j++){
			if(elements[j][col] == sign)
				counter++;
		}
		if(counter == 3){
			player.makeWinner();
			return;
		}
		else{
			counter = 0;
		}
		
		//diagonal check
		if(row == col){//first diagonal
			for(int i = 0; i < 3; i++){
			if(elements[i][i] == sign)
				counter++;
			}
			if(counter == 3){
				player.makeWinner();
				return;
			}
			else{
				counter = 0;
			}
		}
		
		if(row == 2 - col){//second diagonal
			for(int i = 2; i >= 0; i--){
			if(elements[i][2-i] == sign)
				counter++;
			}
			if(counter == 3){
				player.makeWinner();
				return;
			}
			else{
				counter = 0;
			}
		}
	}
}