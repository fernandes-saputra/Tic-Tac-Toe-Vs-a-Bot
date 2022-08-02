import java.util.Scanner;
import java.math.*;
public class Main {
	String[][] boardGame = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};
	boolean gameTrue = true;
	int fullBoard = 0;
	boolean playerWin = false;
	boolean botWin = false;
	
	public Main(){
		while(gameTrue) {
			DrawBoardGame();
			Menu();
			BotMoves();
			DrawBoardGame();
			GameChecker();
			GameResult();
		}
	}
	
	public void GameResult() {
		if(playerWin) {
			System.out.println("Player wins");
		}
		if(botWin) {
			System.out.println("Bot wins");
		}
	}
	
	public void GameChecker() {
		//horizontal & Vertical check
		int[][] winCondition = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		for(int i=0;i<boardGame.length;i++) {
			for(int j=0;j<boardGame.length;j++) {
				if(boardGame[i][j]=="O") {
					winCondition[i][0]++;
				}
				if(boardGame[i][j]=="X") {
					winCondition[i][1]++;
				}
				if(boardGame[j][i]=="O") {
					winCondition[i][2]++;
				}
				if(boardGame[j][i]=="X") {
					winCondition[i][3]++;
				}
			}
		}
		
		//diagonal check
		int x = 2;
		for(int i=0;i<boardGame.length;i++) {
			
			if(boardGame[i][i]=="O"){
				winCondition[3][0]++;
			}
			if(boardGame[i][i]=="X"){
				winCondition[3][1]++;
			}
			if(boardGame[x][i]=="O"){
				winCondition[3][2]++;
			}
			if(boardGame[x][i]=="X"){
				winCondition[3][3]++;
			}
			x--;
		}
		
		/*//print win matrix
		for(int i=0; i < winCondition.length;i++) {
			for(int j=0;j<winCondition[0].length;j++) {
				System.out.print(winCondition[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		*/
		for(int i=0; i < winCondition.length;i++) {
			for(int j=0;j<winCondition[0].length;j++) {
				if(winCondition[i][j]==3) {
					if(j==0||j==2) {
						playerWin = true;
					}
					else {
						botWin = true;
					}
					gameTrue = false;
				}
			}
		}
		
	}
	
	public void DrawBoardGame() {
		System.out.println("  123");
		for(int i=0;i<boardGame.length;i++) {
			System.out.print(i+1 + " ");
			for(int j = 0;j<boardGame.length;j++) {
				System.out.print(boardGame[i][j]);
			}
			System.out.println("");
		}
	}
	
	public void BotMoves() {
		boolean moveValid = false;
		while(!moveValid) {
			int x = (int)(Math.random()*3)+0;
			int y = (int)(Math.random()*3)+0;
			if(boardGame[x][y]== "-") {
				boardGame[x][y]="X";
				moveValid = true;
				fullBoard++;
			}
			if(fullBoard==9) {
				moveValid = true;
				gameTrue = false;
			}
		}
	}
	
	public void Menu() {
		boolean moveValid = false;
		Scanner sc = new Scanner(System.in);
		while(!moveValid) {
			System.out.print("Enter Value: ");
			String input = sc.nextLine();
			String[] splittedInput = input.split(",",2);
			
			if(boardGame[Integer.parseInt(splittedInput[0])-1][Integer.parseInt(splittedInput[1])-1]=="-") {
				boardGame[Integer.parseInt(splittedInput[0])-1][Integer.parseInt(splittedInput[1])-1] = "O";
				moveValid = true;
				fullBoard++;
			}
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}
}
