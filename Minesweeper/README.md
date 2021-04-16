This is the Minesweeper game on the Command Line

Run from Minesweeper.main()

On each iteration - by specifying the row and column - the player opens a square

One wins iff they avoid all the mines

PROGRAMMING NOTES
1. This was written before having sufficient knowledge in OOP, so it may be hard to understand and maintain
2. The case when the player opens a 0-square, a DFS recursive algorithm opens the whole pool of 0s.
3. I learned recursion just to make this.