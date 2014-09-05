Problem Description:
So we have an array of rows & columns. Each is a position in a game. The position of snake and ladder should be randomized at the beginning of the game.
It should be a multiplayer game. Each player rolls a die, gets a number, starts from position 1 and proceeds. If encountered a snake , he retreats to the position of the snake tail. The vice versa for ladder (where ladder is a short cut for moving upwards).
The player who reaches the destination first is the winner.


Assumption:
1. Board is square sized
2. No need to roll exact number to win (reach final position). for ex. player is in 97 th position. he can put any number between 3 - 6 to win.
3. Snake and ladder cant be positioned in 1st and last position.
4. No two connecting points share a single cell. (Connecting point means, I consider snakes and ladders are connectors between two cells. So each snake/ladder has two connecting points - start cell and end cell)
5. A single cell can be mapped to multiple players.

Note : 
GameHost is the mainclass that prgram starts
Each Class has its responsibilities at its top