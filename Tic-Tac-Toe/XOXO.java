class XOXO{
	Player player1, player2, currentPlayer;
	Board tabela;
	Dialogue speaker;
	
	public XOXO(){
		tabela = new Board();
		speaker = new Dialogue();
		
		speaker.greet();
		
		player1 = new Player(1);
		player2 = new Player(2);
		
		currentPlayer = player1;
		
		System.out.println();
	}
	
	public void play(){
		while(!tabela.isFull() && !player1.isWinner() && !player2.isWinner()){
			tabela.display();
			tabela.move(currentPlayer, speaker);
			//tabela.evaluate(player1, player2);
			if(currentPlayer.equals(player1))
				currentPlayer = player2;
			else
				currentPlayer = player1;
		}
		
		tabela.display();
		
		if(player1.isWinner()){
			speaker.winner(player1);
		}
		else if(player2.isWinner()){
			speaker.winner(player2);
		}
		else{
			speaker.noWinner();
		}
	}
}